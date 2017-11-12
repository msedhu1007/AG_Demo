package com.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectAModel {
	private WebDriver driver;
	private String carModell;
	private static int time = 15;

	//Constructor
	public SelectAModel (WebDriver driver){
		this.driver=driver;
		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	// Locators

	@FindBy(how = How.XPATH, using = "//img[@alt='\"+ carModell +\"']")
	private WebElement carModel;

	@FindBy(how = How.XPATH, using = "//h1[@class='contentTitle___S_Ugq' and contains(text(),'Select a')]")
	private WebElement heading;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter City or Zip']")
	private WebElement cityOrZipTextField;

	@FindBy(how = How.XPATH, using = "//button[text()='USE MY LOCATION']")
	private WebElement useMyLocation;

	@FindBy(how = How.XPATH, using = "//button[text()='FIND']")
	private WebElement buttonFind;

	@FindBy(how = How.XPATH, using = "//img[@alt='3 Series for Car Financing']")
	private WebElement img3seriesbmw;

	@FindBy(how = How.CSS, using = "div.container-fluid")
	private WebElement divCarModels;
	
	private By txtZip = By.cssSelector("input[placeholder='Enter City or Zip']");

	public boolean isPageOpened(){
		return heading.getText().toString().contains("Model");
	}

	public void clickModel(String carModell){
		this.carModell = carModell;
		carModel.click();
	}

	public void clickUseMyLocation() {
		useMyLocation.click();
	}

	public void setCityZip(String ziporcity) {
		cityOrZipTextField.sendKeys(ziporcity);
	}

	public void clickFind() {
		buttonFind.click();
	}

	public Boolean isFindButtonEnabled() {
		return (buttonFind).isEnabled();
	}

	public void click3Series() {
		img3seriesbmw.click();
	}

	public void waitforSelectModelPageToOpen() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		   
	}


	public void printproperties() {
		List<WebElement> ele = divCarModels.findElements(By.tagName("img"));
		for(WebElement a:ele) {
			System.out.println(a.getAttribute("alt"));
		}
}		

	public void clickCarModel(String carModel){
		driver.findElement(By.xpath("//img[@class='image___1R4ra' and contains(@alt,'"+ carModel +"')]")).click();
	}
	
	public void waitforZipcode() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(txtZip));
		
	}
	
	

}
