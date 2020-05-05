package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class AddSupervisor extends TestBase{
	@FindBy(xpath="//input[@id='supplierID']")
	WebElement supervisorname;
	@FindBy(xpath="//textarea[@id='address']")
	WebElement address;
	@FindBy(xpath="//input[@id='supEmail']")
	WebElement emailid;
	@FindBy(xpath="//input[@id='supCon']")
	WebElement contactno;
	@FindBy(xpath="//input[@id='supplier_altNo']")
	WebElement altno;
	@FindBy(xpath="//input[@id='supAdhar']")
	WebElement adharid;
	@FindBy(xpath="//input[@id='supPan1']")
	WebElement panno;
	@FindBy(xpath="//button[@class='btn btn-success btn-md']")
	WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public AddSupervisor() {
		PageFactory.initElements(driver, this);
	}
	public String verify_AddSupervisor_titlename() throws InterruptedException {
		Thread.sleep(3000);
		return driver.getTitle();
	}
	public AddSupervisor verify_addsupervisor_functionality(String supervisor_name,String address1,String email_id,
			String contact_no,String alt_contact_no,String adhar_no,String pan_no ) {
		supervisorname.sendKeys(supervisor_name);
		address.sendKeys(address1);
		emailid.sendKeys(email_id);
		contactno.click();
		contactno.sendKeys(contact_no);
		altno.sendKeys(alt_contact_no);
		adharid.sendKeys(adhar_no);
		panno.sendKeys(pan_no);
		submitbtn.click();
		return new AddSupervisor();
	}
	
	
	
	
	
	
}
