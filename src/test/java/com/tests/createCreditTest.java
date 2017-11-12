package com.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pageobjects.ChooseACar;
import com.pageobjects.EmploymentInfoPage;
import com.pageobjects.HomePage;
import com.pageobjects.ReviewDetailsPage;
import com.pageobjects.ReviewVehicle;
import com.pageobjects.SearchForFinancing;
import com.pageobjects.SelectAModel;
import com.pageobjects.SelectMakePage;


public class createCreditTest {

	WebDriver driver;
	private static int time = 15;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeClass
	public void setup(){
		htmlReporter = new ExtentHtmlReporter(".//AutomationReport.html");
		htmlReporter.setAppendExisting(true);
		extent = new ExtentReports();
		extent.setSystemInfo("OS","Windows");

		extent.attachReporter(htmlReporter);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Auto Gravity Demo");
		htmlReporter.config().setReportName("Auto Gravity Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setCSS("body:not(.default) {overflow: scroll !important;}");

		//use FF Driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void createCredit() {
		try {
			test = extent.createTest("Test Case 1", "Verify Credit in AG Application");
			test.assignCategory("Auto Gravity Demo");

			
			HomePage objHP = new HomePage(driver);
			objHP.waitforHomePageToOpen();

			//Check if page is opened
			Assert.assertTrue(objHP.isPageOpened());
			test.pass("Home Page is Opened successfully");
			// click on Get Started button
			objHP.clickOnGetStartedButton();
			
			SelectMakePage objSMP = new SelectMakePage(driver);
			objSMP.waitforSelectMakePageToOpen();

			//Check if page is opened
			Assert.assertTrue(objSMP.isPageOpened(),"Verify if the Select Make page is open");
			test.pass("Navigated to Select Make Page successfully");
			// click on the car make icon
			objSMP.clickOnMake("Acura");
			
			SelectAModel objSAM = new SelectAModel(driver);
			
			// wait for the page to load
			objSAM.waitforSelectModelPageToOpen();
			
			// check if the page is opened
			Assert.assertTrue(objSAM.isPageOpened());
			
		//	objSAM.printproperties();
			
			// click on the Car Model
			objSAM.clickCarModel("MDX");
			test.pass("Car Model has been selected successfully");
			// wait for the Zip Code
			objSAM.waitforZipcode();
			
			// Enter Zip code
			objSAM.setCityZip("91381");
			objSAM.clickFind();
			
			
			ChooseACar objCC = new ChooseACar(driver);
			
			objCC.waitforSelectMakePageToOpen();
			
			// Select the car in Choose the Car Page
			objCC.clickCarModel(4);
			test.pass("Car Model version has been selected successfully");
			// initialise next page 
			ReviewVehicle objRV = new ReviewVehicle(driver);
			
			// wait for the page to load
			objRV.waitforPageLoad();
			
			//Click Next button
			objRV.clickNextButton();
			
			ReviewDetailsPage objRDP = new ReviewDetailsPage(driver);
			objRDP.waitforPageLoad();
			
			// Click next button
			objRDP.clickNextButton();
			
			SearchForFinancing objSFF = new SearchForFinancing(driver);
			objSFF.submitPersonalInfo("Test","User","10/10/1985","6616616616","cnxq@testing.com", "Passw0rd","Passw0rd");
			test.pass("User has submitted Personal information successfully");
			
			objSFF.submitResidenceinf("Rent","7273 Chesterton Lane","02/2014","2000");
			test.pass("User has submitted Residence information successfully");
			
			EmploymentInfoPage objEIP = new EmploymentInfoPage(driver);
			
			objEIP.FillEmploymentInfo("Full Time", "IUHealth","Automation Architect","01/2015","6673335555","6000");
			test.pass("User has submitted Employment information successfully");
			
			driver.quit();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{ 
		if(result.getStatus()== ITestResult.FAILURE){
			String screenshotpath = GetFullPageScreenShot.capture(driver, "screenshot");
			test.log(Status.FAIL,MarkupHelper.createLabel(result.getName()+" Test Case FAILED due to below issues:", ExtentColor.BROWN));
			test.fail(result.getThrowable());
			test.fail("Snapshot below: "+test.addScreenCaptureFromPath(screenshotpath));
			driver.close();
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED",ExtentColor.GREEN));
		}
		else{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED",ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
		extent.flush();
	}
}
