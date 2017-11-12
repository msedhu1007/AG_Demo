package com.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseACar {
	private WebDriver driver;
	private static int time = 15;
	
	//*[@alt='MDX for Car Financing'][1]
	
	//Constructor
	public ChooseACar (WebDriver driver){
		this.driver=driver;
		//Initialise Elements
		PageFactory.initElements(driver, this);
	}
	
	
	// Locators
	@FindBy(how = How.XPATH, using = "//img[@alt='\"+ carModell +\"']")
	private WebElement carModel;
	
	@FindBy(how = How.XPATH, using = "//article")
	private WebElement cartype;
	
	private By cartyp = By.xpath("//article"); 
	
	// Select the Car from Choose Car page
	public void clickCarModel(int id){
		driver.findElement(By.xpath("(//img[@class='image___1R4ra'])["+ id +"]")).click();
	}
	
	
	public void waitforSelectMakePageToOpen() {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.presenceOfElementLocated(cartyp));		   
	}
	
	
}
