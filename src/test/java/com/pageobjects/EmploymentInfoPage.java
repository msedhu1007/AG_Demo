package com.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class EmploymentInfoPage {

	private WebDriver driver;
	private static int time = 15;
	
	//Constructor
		public EmploymentInfoPage (WebDriver driver){
			this.driver=driver;
			//Initialise Elements
			PageFactory.initElements(driver, this);
		}
		
		// Locators

		 @FindBy(how = How.XPATH, using = "//h4[text()='Employment Information']")
		 private WebElement heading;
		 
		 @FindBy(how = How.XPATH, using = "(//button[@type='button'])[1]")
		 private WebElement btn_EmploymentStatus;
		 
		 @FindBy(how = How.XPATH, using = "//div[@id='agselectemployment-status']/div[1]")
		 private WebElement lst_EmploymentStatus;
		 
		 @FindBy(how = How.ID, using = "employer-name")
		 private WebElement txtEmployerName;
		 
		 @FindBy(how = How.ID, using = "employee-title")
		 private WebElement txtTitle;
		 
		 @FindBy(how = How.ID, using = "employee-start-date")
		 private WebElement txtStartDate;
		 
		 @FindBy(how = How.ID, using = "employer-phone-number")
		 private WebElement txtEmployerPhNo;
	
		
		 @FindBy(how = How.XPATH, using = "//input[@id='gross-monthly-income']")
		 private WebElement txtGrossIncome;	 
		 		 
		 @FindBy(how = How.XPATH, using = "button.btn.btn-primary")
		 private WebElement btnNxt;
		 
		 private By listEmpStatus = By.xpath("//div[@id='agselectemployment-status']/div[1]");
		 private By buttonNext = By.cssSelector("button.btn.btn-primary");
		 private By txtEmployer = By.id("employer-name");
		 
		 public boolean isPageOpened(){
				return (heading).getText().toString().contains("Employment Information");
			}
		 
		 
			public void waitforEmploymentInfoPageToOpen() {
				WebDriverWait wait = new WebDriverWait(driver, time);
				wait.until(ExpectedConditions.presenceOfElementLocated(listEmpStatus));		   
			}
			
			public void clickbtnEmploymentStatus() {
				btn_EmploymentStatus.click();
			}
			
			public void selectEmploymentStatus(String value) {
				//(//span[@role='menuitem'])[1]
				List<WebElement> ele = driver.findElements(By.xpath("(//span[@role='menuitem'])"));
				for(WebElement e:ele) {
					System.out.println(e.getText());
					if(e.getText().equalsIgnoreCase(value)) {
						e.click();
						break;
					}
				}
			}
			
			public void setEmployerName(String value) {
				try {
					fluentWait(txtEmployer);
					Actions actions = new Actions(driver);
					actions.moveToElement(txtEmployerName);
					actions.click();
					actions.sendKeys(value);
					Thread.sleep(2000);
					actions.build().perform();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*int len = value.length();
				for(int i=0; i<len;i++) {
					String s = new StringBuilder().append(value.charAt(i)).toString();
					txtEmployerName.sendKeys(s);
				}*/
				
			}
			
			private WebElement fluentWait(final By locator) {
			    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) //
			            .withTimeout(5, TimeUnit.SECONDS) //
			            .pollingEvery(20, TimeUnit.SECONDS) //
			            .ignoring(NoSuchElementException.class);

			    WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			        public WebElement apply(WebDriver driver) {
			            return driver.findElement(locator);
			        }
			    });
			    return foo;
			}

			
			public void setTitle(String value) {
				txtTitle.sendKeys(value);
			}
			
			public void setStartDate(String value) {
				txtStartDate.sendKeys(value);
			}
			
			public void setEmployerPhNo(String value) {
				txtEmployerPhNo.sendKeys(value);
			}
			
			public void setGrossIncome(String value) {
				txtGrossIncome.sendKeys(value);
			}
			
			public void clickNxtbutton() {
				try {
					fluentWait(buttonNext);
					Thread.sleep(2000);
					driver.findElement(buttonNext).click();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			public void FillEmploymentInfo(String empStatus, String empName, String empTitle, String StDate, String phNumber, String grossIncome) {
				clickbtnEmploymentStatus();
				selectEmploymentStatus(empStatus);
				setEmployerName(empName);
				setTitle(empTitle);
				setStartDate(StDate);
				setEmployerPhNo(phNumber);
				setGrossIncome(grossIncome);
				clickNxtbutton();
			}
			
}

