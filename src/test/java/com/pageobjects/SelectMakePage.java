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


public class SelectMakePage {
	private WebDriver driver;
	String car_make ;
	private static int time = 15;

	//Constructor
	public SelectMakePage (WebDriver driver){
		this.driver=driver;
		//Initialise Elements
		PageFactory.initElements(driver, this);
	}

	// Locators

	 @FindBy(how = How.XPATH, using = "//h1[@class='contentTitle___S_Ugq' and text()='Select Make']")
	 private WebElement heading;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='BMW']/.")
	 private WebElement BMWMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Acura']/.")
	 private WebElement AcuraMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Alfa Romeo']/.")
	 private WebElement AlfaRomeaMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Audi']/.")
	 private WebElement AudiMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Bentley']/.")
	 private WebElement BentleyMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Buick']/.")
	 private WebElement BuickMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Cadillac']/.")
	 private WebElement CadillacMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Chevrolet']/.")
	 private WebElement ChevroletMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Chrysler']/.")
	 private WebElement ChryslerMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Dodge']/.")
	 private WebElement DodgeMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Ferrari']/.")
	 private WebElement FerrariMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Fiat']/.")
	 private WebElement FiatMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Ford']/.")
	 private WebElement FordMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Genesis']/.")
	 private WebElement GenesisMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='GMC']/.")
	 private WebElement GMCMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Honda']/.")
	 private WebElement HondaMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Hyundai']/.")
	 private WebElement HyundaiMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Infiniti']/.")
	 private WebElement InfinitiMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Lincoln']/.")
	 private WebElement LincolnMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Maserati']/.")
	 private WebElement MaseratiMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Mazda']/.")
	 private WebElement MazdaMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='McLaren']/.")
	 private WebElement McLarenMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Mercedes-Benz']/.")
	 private WebElement MercedesBenzMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Mini']/.")
	 private WebElement MiniMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Mitsubishi']/.")
	 private WebElement MitsubishiMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Nissan']/.")
	 private WebElement NissanMake  ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Porsche']/.")
	 private WebElement PorscheMake  ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Rolls-Royce']/.")
	 private WebElement RollsRoyceMake  ;
	 

	
	 @FindBy(how = How.XPATH, using = "//img[@title='Smart']/.")
	 private WebElement SmartMake ;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Subaru']/.")
	 private WebElement SubaruMake ;
	 
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Tesla']/.")
	 private WebElement TeslaMake ;
	 
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Toyota']/.")
	 private WebElement ToyotaMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Volkswagen']/.")
	 private WebElement VolkswagenMake;
	 
	 @FindBy(how = How.XPATH, using = "//img[@title='Volvo']/.")
	 private WebElement VolvoMake;
	 
	 private By btnNew = By.cssSelector("button.btn.active");
	 private By imgVolvo = By.xpath("//img[@title='Volvo']/.");
	
	private By carMakers = By.xpath("//img[@title='"+car_make+"']/.");
//
	
//Cadillac,Acura,Ford, BMW
//	ATS Sedan for Car Financing,RLX for Car Financing,C-Max Energi for Car Financing,7 Series for Car Financing
	



	public boolean isPageOpened(){
		return (heading).getText().toString().contains("Select Make");
	}

	public void clikOnBMWMake(){
		BMWMake.click();
	}
	
	/*public void clikOnModel(String car_make){
		this.car_make = car_make;
		driver.findElement(carMakers).click();
	}*/
	public void clickOnMake(String car_make){
		switch(car_make) {
		case "Acura":
         AcuraMake.click();
            break;
		
		case "Alfa Romeo": 
			AlfaRomeaMake.click();
			break;
			
		case "Audi": 
			AudiMake.click();
			break;
			
		case "Bentley": 
			BentleyMake.click();
			break;
			
		case "BMW": 
			BMWMake.click();
			break;
			
		case "Buick": 
			BuickMake.click();
			break;	
			
		case "Cadillac": 
			CadillacMake.click();
			break;	
			
		case "Chevrolet": 
			ChevroletMake.click();
			break;	
			
		case "Chrysler": 
			ChryslerMake.click();
			break;	
		
		case "Dodge": 
			DodgeMake.click();
			break;	
			
		case "Ferrari": 
			FerrariMake.click();
			break;	
			
		case "Fiat": 
			FiatMake.click();
			break;	
			
		case "Ford": 
			FordMake.click();
			break;	
			
		case "Genesis": 
			GenesisMake.click();
			break;	
			
		case "GMC": 
			GMCMake.click();
			break;	
			
		case "Honda": 
			HondaMake.click();
			break;	
			
		case "Hyundai": 
			HyundaiMake.click();
			break;	
			
		case "Infiniti": 
			InfinitiMake.click();
			break;	
			
		case "Lincoln": 
			LincolnMake.click();
			break;	
			
		case "Maserati": 
			MaseratiMake.click();
			break;	
			
		case "Mazda": 
			MazdaMake.click();
			break;	
			
		case "McLaren": 
		McLarenMake.click();
			break;	
			
		case "MercedesBenz": 
			MercedesBenzMake.click();
			break;	
			
		case "Mini": 
			MiniMake.click();
			break;	
			
		case "Mitsubishi": 
			MitsubishiMake.click();
			break;	
			
		case "Nissan": 
			NissanMake.click();
			break;	
			
		case "Porsche": 
			PorscheMake.click();
			break;
			
		case "RollsRoyce": 
			RollsRoyceMake.click();
			break;
			
		case "Smart": 
			SmartMake.click();
			break;	
			
		case "Subaru": 
			SubaruMake.click();
			break;	
			
		case "Tesla": 
			TeslaMake.click();
			break;
			
		case "Toyota": 
			ToyotaMake.click();
			break;
			
		case "Volkswagen": 
			VolkswagenMake.click();
			break;
			
		case "Volvo": 
			VolvoMake.click();
			break;
		}
	}
	

	public void waitforSelectMakePageToOpen() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(imgVolvo));
	//	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}


}
