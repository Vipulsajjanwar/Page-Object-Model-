package com.stock.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class SiteEstimate extends TestBase
{	
	public static String strlink;
	@FindBy(xpath="//span[@class='select2-selection__rendered']")
	WebElement SiteEstimateLink;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement Searchbox;
	
	@FindBy(xpath="//span[@id='select2-siteID-container']")
	WebElement SelectSiteName;
	
	@FindBy(xpath="//span[@id='select2-productNamerr-container']")
	WebElement SelectProductName;
	
	@FindBy(xpath="//span[@id='select2-unitId-container']")
	WebElement SelectUnit;
	
	@FindBy(xpath="//input[@id='Qty']")
	WebElement EnterQuantity;
	
	@FindBy(xpath="//button[contains(text(),'Add')]")
	WebElement AddButton;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement SubmitButton;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement CancelButton;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions A=new Actions(driver);
	
	public SiteEstimate() {
		PageFactory.initElements(driver, this);
	}
	public String verify_SiteEstimatePage_TitleName() {
		return driver.getTitle();
	}
	public String web_list() {
		List<WebElement> objlinks = driver.findElements(By.tagName("div"));

		for (WebElement objcurrentlink : objlinks) {
			String strlink = objcurrentlink.getText();
			System.out.println(strlink);
		}
		return strlink;
	}
	public SiteEstimate Verify_SiteEstimateFunctionality(String Site_Name, String Product_Name, String Units, String Quantity) {
    	SelectSiteName.click();
		Searchbox.sendKeys(Site_Name);
		Searchbox.sendKeys(Keys.ENTER);
		
		SelectProductName.click();
		Searchbox.sendKeys(Product_Name);
		Searchbox.sendKeys(Keys.ENTER);
		
		SelectUnit.click();
		Searchbox.sendKeys(Units);
		Searchbox.sendKeys(Keys.ENTER);
		
		EnterQuantity.sendKeys(Quantity);
		A.moveToElement(AddButton).click().perform();
		A.moveToElement(SubmitButton).click().perform();
		return new SiteEstimate();
	}
	
}
