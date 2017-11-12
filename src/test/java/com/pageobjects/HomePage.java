package com.pageobjects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	private static int time = 15;
	//Page URL
	private static String PAGE_URL="https://www-staging.autogravity.com/";

	// Locators
	 @FindBy(how = How.CSS, using = "button.btn.btn-inverted.homeButton___3IaYm")
	 private WebElement buttonGetStarted;
	 
	 @FindBy(how = How.XPATH, using = "//a[text()='Calculator']")
	 private WebElement linkCalculator;
	 
	 @FindBy(how = How.XPATH, using = "//a[text()='Log In']")
	 private WebElement linkLogin;
	
	 
	//Constructor
	public HomePage(WebDriver driver){
		this.driver=driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}
	
	public void openBrowser(String browser){
		try{

			if(browser.equalsIgnoreCase("IE")){
				System.setProperty("webdriver.ie.driver",".//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			else if (browser.equalsIgnoreCase("CH")){
				System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
					driver = new ChromeDriver();

			}
			else if(browser.equalsIgnoreCase("FF")){
				System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
					driver = new FirefoxDriver();
				
			}
			else if(browser.equalsIgnoreCase("Edge")){
				System.setProperty("webdriver.edge.driver",".//MicrosoftWebDriver.exe"); //put actual location
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("Ghost")) {
				driver = new PhantomJSDriver();
			}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	// Click on Get Started button
	public void clickOnGetStartedButton(){
		buttonGetStarted.click();

	
	}

	//Click on Get login link
	public void clickOnLoginlink(){
		linkLogin.click();
	}

	// Click on Calculator link
	public void clickOnCalculatorlink(){
		linkCalculator.click();
	}

	//Veirfy whether the page is opened
	public boolean isPageOpened(){
		return buttonGetStarted.isDisplayed();
	}

	public void waitforHomePageToOpen() {
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		   
	}

	




}
