package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//img[@class='light-logo']")
	WebElement CompanyLogo;
	
	@FindBy(linkText = "Dashboard")
	WebElement DashboardLink;

	@FindBy(linkText = "Settings")
	WebElement SettingsLink;
		
	@FindBy(linkText = "Purchase Material")
	WebElement PurchasematerialLink;
	
	@FindBy(linkText = "Dispatch Material")
	WebElement DispatchmarialLink;
	
	@FindBy(linkText = "Return Material")
	WebElement ReturnmaterialLink;
	
	@FindBy(linkText = "Site Estimate")
	WebElement SiteEstimateLink;
	
	@FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
	WebElement logoutbtn;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;

	// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
				
		public boolean verifyCorrectCompanyLogo(){
			return CompanyLogo.isDisplayed();
		}
		
		public PurchaseMaterialPage clickOnPurchaseLink(){
//			PurchasematerialLink.click();
	    	js.executeScript("arguments[0].click();", PurchasematerialLink);

			return new PurchaseMaterialPage();
		}
		
		public DispatchMaterial clickOnDispatchLink(){
//			DispatchmarialLink.click();
	    	js.executeScript("arguments[0].click();", DispatchmarialLink);

			return new DispatchMaterial();
		}
		
		public ReturnMaterial clickOnReturnLink(){
//			ReturnmaterialLink.click();
	    	js.executeScript("arguments[0].click();", ReturnmaterialLink);

			return new ReturnMaterial();
		}
		public Settings ClickOnSettingsLink() {
//		SettingsLink.click();
    	js.executeScript("arguments[0].click();", SettingsLink);

		return new Settings();
		}
		public SiteEstimate ClickOnSiteEstimate() {
			js.executeScript("arguments[0].click();", SiteEstimateLink);
			return new SiteEstimate();
		}
		public LoginPage clickOnLogoutBtn() {
//			logoutbtn.click();
	    	js.executeScript("arguments[0].click();", logoutbtn);

			return new LoginPage();
		}

}