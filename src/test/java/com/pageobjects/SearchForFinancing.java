package com.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.gson.annotations.Until;

public class SearchForFinancing {

	private WebDriver driver;
	private static int time = 15;
	WebDriverWait wait;
	
	//Constructor
		public SearchForFinancing (WebDriver driver){
			this.driver=driver;
			//Initialise Elements
			PageFactory.initElements(driver, this);
		}
	
		
		
	//Locators
	@FindBy(how = How.ID, using = "firstNameTextField")
	private WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "lastNameTextField")
	private WebElement txtLastName;
	
	@FindBy(how = How.ID, using = "dobTextField")
	private WebElement txtDOB;
	
	@FindBy(how = How.ID, using = "mobilePhoneTextField")
	private WebElement txtMobile;

	@FindBy(how = How.ID, using = "emailTextField")
	private WebElement txtemail;
	
	@FindBy(how = How.ID, using = "passwordTextField")
	private WebElement txtPassword;
	
	@FindBy(how = How.ID, using = "confirmPasswordTextField")
	private WebElement txtConfPassword;
	
	
	@FindBy(how = How.CSS, using = "button.btn.btn-primary")
	private WebElement btnCreateContinue;
	
	private By txtFirstNm = By.id("firstNameTextField"); 
	
	@FindBy(how = How.XPATH, using = "//div[@id='agselecthouseinfo']//button")
	private WebElement btnResidenceStatus;
	
	@FindBy(how = How.ID, using = "aginputaddress")
	private WebElement txtAddres;
	
	@FindBy(how = How.ID, using = "aginputcity")
	private WebElement txtcity;
	
	@FindBy(how = How.ID, using = "aginputzip")
	private WebElement txtzip;

	@FindBy(how = How.ID, using = "aginputzip")
	private WebElement lstState;
	
	@FindBy(how = How.XPATH, using = "//div[@id='agselectstate']/div[1]/button")
	private WebElement btnState;
	
	@FindBy(how = How.ID, using = "aginputmoveindate")
	private WebElement txtMoveinDate; 
	
	@FindBy(how = How.ID, using ="aginputpayment")
	private WebElement txtMortgage;
	
	@FindBy(how = How.XPATH, using = "//div[@class='pac-container pac-logo']//div[1]/span[2]")
	private WebElement listAddres;
	
	@FindBy(how = How.CSS, using = "button.btn.btn-primary")
	private WebElement btnNxt;
	
	
	private By listAddress = By.cssSelector("div.pac-container.pac-logo");
	
	private By txtAddress = By.id("aginputaddress");
	
	public void waitforSelectMakePageToOpen() {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(txtFirstNm));		   
	}
	
	
	public void setFirstName(String value) {
		txtFirstName.sendKeys(value);		   
	}
	
	public void setLastName(String value) {
		txtLastName.sendKeys(value);		   
	}
	
	public void setDOB(String value) {
		txtDOB.sendKeys(value);		   
	}
	
	public void setMobilePhone(String value) {
		txtMobile.sendKeys(value);		   
	}
	
	public void setEmail(String value) {
		txtemail.sendKeys(value);		   
	}
	
	public void setPwd(String value) {
		txtPassword.sendKeys(value);		   
	}
	
	public void setConfPwd(String value) {
		txtConfPassword.sendKeys(value);		   
	}
	
	public void ClickContinuebtn() {
		btnCreateContinue.click();		   
	}
	
	public void submitPersonalInfo(String firstname, String lastname,String DOB, String mobile, String email, String pwd, String confpwd) {
		waitforSelectMakePageToOpen();
		setFirstName(firstname);
		setLastName(lastname);
		setDOB(DOB);
		setMobilePhone(mobile);
		setEmail(email);
		setPwd(pwd);
		setConfPwd(confpwd);
		ClickContinuebtn();
	}
	
	public void waitforResidencePageToOpen() {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(txtAddress));		   
	}
	
	
	public void clickbtnResidenceStatus() {
		btnResidenceStatus.click();
	}
	
	public void selectCurrentResidence(String value) {
		//(//span[@role='menuitem'])[1]
		List<WebElement> ele = driver.findElements(By.xpath("(//span[@role='menuitem'])[1]"));
		for(WebElement e:ele) {
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(value)) {
				e.click();
			}
		}
	}
	
	
	public void setAddress(String value) {
		//txtAddres.sendKeys(value);
	//	JavascriptExecutor executor = (JavascriptExecutor)driver;
	//	executor.executeScript("arguments[0].value="+value+";", txtAddres);
	//	txtAddres.sendKeys(value);
		int len = value.length();
		
		for(int i=0; i<len;i++) {
			String s = new StringBuilder().append(value.charAt(i)).toString();
			txtAddres.sendKeys(s);
		}
		fluentWait(listAddress);
		listAddres.click();
    			//listAddress.findElements(By.xpath("//div[1]/span[2]/span"));
		
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
	
	public void setCity(String value) {
		txtzip.sendKeys(value);
	}
	
	public void setZipcode(String value) {
		txtzip.sendKeys(value);
	}
	
	public void selectState(String value) {
		txtAddres.sendKeys(value);
	}
	
	public void setMoveinDate(String value) {
		txtMoveinDate.sendKeys(value);
	}
	
	public void clickState(String value) {
		btnState.sendKeys(value);
	}
	
	public void setRental(String value) {
		txtMortgage.sendKeys(value);
	}
	
	public void clkNxtbtn() {
		btnNxt.click();
	}
	
	
	public void submitResidenceinf(String ResidenceStatus, String address,String moveinDate,String rental) {
		waitforResidencePageToOpen();
		clickbtnResidenceStatus();
		selectCurrentResidence(ResidenceStatus);
		setAddress(address);
		//setCity("Indianapolis");
		setMoveinDate(moveinDate);
		setRental(rental);
		clkNxtbtn();
	}
}
