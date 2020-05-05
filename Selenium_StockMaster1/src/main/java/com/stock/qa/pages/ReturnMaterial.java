package com.stock.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class ReturnMaterial extends TestBase {
	@FindBy(xpath="//input[@id='returnDate']")
	WebElement returndate;
	@FindBy(xpath="//span[@id='select2-SupervisorID-container']")
	WebElement supervisorname;
	@FindBy(xpath="//input[@class='checkbox']")
	WebElement checkbox;
	@FindBy(xpath="//span[@id='select2-siteId2-container']")
	WebElement sitename;
	@FindBy(xpath="//input[@id='narrationID']")
	WebElement narration;
	@FindBy(xpath="//span[@id='select2-ProductId-container']")
	WebElement productname;
	@FindBy(xpath="//span[@id='select2-unitId-container']")
	WebElement unit;
	@FindBy(xpath="//input[@id='QuantityId']")
	WebElement quantity;
	@FindBy(xpath="//button[@id='subBut']")
	WebElement submitbtn;
	Actions A=new Actions(driver);
	public ReturnMaterial() {
		PageFactory.initElements(driver, this);
	}
	public String Verify_TitleName() {
		return driver.getTitle();
	}
	public ReturnMaterial Verify_returnMaterial_functionality() {
		returndate.clear();
		returndate.sendKeys(prop.getProperty("return_date"));
		returndate.sendKeys(Keys.ENTER);
//		A.moveToElement(returndate).build().perform();
//		returndate.click();
//		supervisorname.clear();
//		supervisorname.click();
		supervisorname.sendKeys(prop.getProperty("supervisor_name"));
		supervisorname.sendKeys(Keys.ENTER);
		checkbox.click();
		sitename.click();
		sitename.sendKeys(prop.getProperty("site_name"));
		narration.click();
		narration.sendKeys(prop.getProperty("narration"));
		productname.click();
		productname.clear();
		productname.sendKeys(prop.getProperty("product_name"));
		unit.sendKeys(prop.getProperty("units"));
		quantity.sendKeys(prop.getProperty("quantity"));
		submitbtn.click();
		
		return new ReturnMaterial();
	}
	
	
	
}
