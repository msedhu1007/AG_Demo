package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewVehicle {
	private WebDriver driver;
	private static int time = 15;
	
	//Constructor
		public ReviewVehicle (WebDriver driver){
			this.driver=driver;
			//Initialise Elements
			PageFactory.initElements(driver, this);
		}
		
		
		
	//
	@FindBy(how = How.CSS, using = "button.btn.btn-primary.buttonNext___2w_Xa")
	private WebElement btnNext;
	
	By btnnext = By.cssSelector("button.btn.btn-primary.buttonNext___2w_Xa");
	
	// Select the Car from Choose Car page
	public void clickNextButton(){
		btnNext.click();
	}
	
	
	public void waitforPageLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(btnnext));
		
	}
	
	
}
