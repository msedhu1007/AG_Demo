package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewDetailsPage {

	private WebDriver driver;
	private static int time = 15;
	
	
	//Constructor
			public ReviewDetailsPage (WebDriver driver){
				this.driver=driver;
				//Initialise Elements
				PageFactory.initElements(driver, this);
			}
			
			
	// Locators
		@FindBy(how = How.XPATH, using = "//button[text()='NEXT']")
		private WebElement btnNext;
	
		By btnnextt = By.xpath("//button[text()='NEXT']");
		By btnNextt = By.xpath("//button[text()='Next']");
		
		public void waitforPageLoad() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(btnnextt));
			} catch (Exception e) {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.presenceOfElementLocated(btnNextt));
			}
		}
		
		// Click Next button in Review Details Page
		public void clickNextButton(){
			try {
				btnNext.click();
			} catch (Exception e) {
				driver.findElement(btnNextt).click();
			}
		}
}
