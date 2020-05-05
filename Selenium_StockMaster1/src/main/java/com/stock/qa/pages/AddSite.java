package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import com.stock.qa.base.TestBase;
import com.stock.qa.util.TestUtil;

public class AddSite extends TestBase{

	@FindBy(xpath="//input[@id='siteNameID']")
	WebElement sitename;
	@FindBy(xpath="//span[@class='select2-selection select2-selection--multiple']")
	WebElement selectsupervisor;
	@FindBy(xpath="//input[@id='supEmail']")
	WebElement officeemail;
	@FindBy(xpath="//input[@id='supCon']")
	WebElement officecontactno;
	@FindBy(xpath="//input[@id='nameAllValue2']")
	WebElement contactpersonname;
	@FindBy(xpath="//input[@id='supplier_altNo']")
	WebElement contactpersonno;
	@FindBy(xpath="//button[@class='btn btn-success btn-md float-center']")
	WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions A=new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	
	public AddSite() {
		PageFactory.initElements(driver, this);
	}
	public String verify_addsite_titlename() {
		return driver.getTitle();
	}
	public AddSite Verify_addsite_functionality(String site_name, String office_email,String office_contactno,
			String contact_personname,String contact_personno) {
    	js.executeScript("arguments[0].click();", sitename);
    	sitename.sendKeys(site_name);
//    	Select dropdown = new Select(selectsupervisor);  
//    	dropdown.selectByVisibleText(prop.getProperty("select_supervisor"));  
    	selectsupervisor.click();
    	selectsupervisor.sendKeys(Keys.ARROW_DOWN);
    	selectsupervisor.sendKeys(Keys.ENTER);
//		executor.executeScript("arguments[0].click();", selectsupervisor);
//    	selectsupervisor.sendKeys(prop.getProperty("select_supervisor"));
//		selectsupervisor.click();

    	officeemail.sendKeys(office_email);
		officecontactno.sendKeys(office_contactno);
    	js.executeScript("arguments[0].click();", contactpersonname);
    	TestUtil.implicitwait();
		contactpersonname.sendKeys(contact_personname);
		contactpersonno.sendKeys(contact_personno);
		submitbtn.click();
		return new AddSite();
	}
}
