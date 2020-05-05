package com.stock.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class DispatchMaterial extends TestBase {
	@FindBy(xpath="//span[@id='select2-SupervisorID-container']")
	WebElement selectsupervisorname;
	@FindBy(xpath="//input[@id='dispatchDate']")
	WebElement dispatchdate;
	@FindBy(xpath="//span[@id='select2-siteId2-container']")
	WebElement selectsitename;
	@FindBy(xpath="//span[@id='select2-dispatchSite2-container']")
	WebElement selectreceiversupervisor;
	@FindBy(xpath="//input[@id='chkId']")
	WebElement checkbox;
	@FindBy(xpath="//span[@id='select2-ProductId-container']")
	WebElement selectproductname;
	@FindBy(xpath="//input[@id='QuantityId']")
	WebElement productquantity;
	@FindBy(xpath="//button[@id='subBut']")
	WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	Actions A= new Actions(driver);
	public DispatchMaterial() {
		PageFactory.initElements(driver, this);

	}
	public String Verify_TitleName() {
		return driver.getTitle();
	}
	public DispatchMaterial Verify_Dispatch_Functionality() {
		selectsupervisorname.sendKeys(prop.getProperty("supervisor_name"));
		dispatchdate.sendKeys(prop.getProperty("dispatch_date"));
		selectsitename.sendKeys(prop.getProperty("site_name"));
		A.moveToElement(checkbox).build().perform();
		checkbox.click();
		selectreceiversupervisor.sendKeys(prop.getProperty("receiversupervisor_name"));
		selectproductname.sendKeys(prop.getProperty("product_name"));
		productquantity.sendKeys(prop.getProperty("product_qty"));
		submitbtn.click();
		return new DispatchMaterial();

	}
}
