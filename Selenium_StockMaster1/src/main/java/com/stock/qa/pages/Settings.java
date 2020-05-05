package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class Settings extends TestBase {
	@FindBy(linkText="Settings")
	WebElement SettingsLink;
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Settings'])[1]/following::span[1]")
	WebElement AddProductCategoryLink;
	@FindBy(xpath="//li[@class='sidebar-item']//li[2]//a[1]//span[1]")
	WebElement AddproductLink;
	@FindBy(xpath="//span[contains(text(),'Add Suppliers')]")
	WebElement AddSuppliersLink;
	@FindBy(xpath="//span[contains(text(),'Add Supervisor')]")
	WebElement AddSupervisorLink;
	@FindBy(xpath="//span[contains(text(),'Add Site')]")
	WebElement AddSiteLink;
	Actions A=new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public Settings() {
		PageFactory.initElements(driver, this);
	}

	public AddProductCategory ClickOnSettings() throws InterruptedException {
		//				SettingsLink.click();
		js.executeScript("arguments[0].click();", SettingsLink);
		A.moveToElement(SettingsLink).build().perform();

		Thread.sleep(1000L); //wait is just to see how the mouse hovers on menu bar
		SettingsLink.click();
		AddProductCategoryLink.isDisplayed();
		return new AddProductCategory();
	}
	public boolean verifyClickOnSettings() {
		js.executeScript("arguments[0].click();", SettingsLink);
		//				SettingsLink.click();
		return AddProductCategoryLink.isDisplayed();
	}
	public AddProductCategory ClickOnAddProductCategory() throws InterruptedException {
		js.executeScript("arguments[0].click();", SettingsLink);
		//				AddProductCategoryLink.click();
		A.moveToElement(AddProductCategoryLink).build().perform();
		 //wait is just to see how the mouse hovers on menu bar
		AddProductCategoryLink.click();
		Thread.sleep(10000L);
		return new AddProductCategory();
		
	}

	public AddProduct ClickOnAddProduct() throws InterruptedException {
		js.executeScript("arguments[0].click();", SettingsLink);
		//				AddproductLink.click();
		A.moveToElement(AddproductLink).build().perform();
		Thread.sleep(1000L); //wait is just to see how the mouse hovers on menu bar
		AddproductLink.click();

		return new AddProduct();
	}
	public AddSuppliers ClickOnAddSuppliers() throws InterruptedException {
		//				AddSuppliersLink.click();
		js.executeScript("arguments[0].click();", AddSuppliersLink);
		A.moveToElement(AddSuppliersLink).build().perform();
		Thread.sleep(1000L); //wait is just to see how the mouse hovers on menu bar
		AddSuppliersLink.click();

		return new AddSuppliers();
	}
	public AddSupervisor ClickOnAddSupervisor() throws InterruptedException {
		//				AddSupervisorLink.click();
		js.executeScript("arguments[0].click();", AddSupervisorLink);
		A.moveToElement(AddSupervisorLink).build().perform();
		Thread.sleep(1000L); //wait is just to see how the mouse hovers on menu bar
		AddSupervisorLink.click();
		return new AddSupervisor();
	}
	public AddSite ClickOnAddSite() throws InterruptedException {
		//				AddSiteLink.click();
		js.executeScript("arguments[0].click();", AddSiteLink);
		A.moveToElement(AddSiteLink).build().perform();
		Thread.sleep(1000L); //wait is just to see how the mouse hovers on menu bar
		AddSiteLink.click();
		return new AddSite();
	}

}
