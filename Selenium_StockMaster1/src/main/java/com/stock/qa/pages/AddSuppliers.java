package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class AddSuppliers extends TestBase{
		@FindBy(xpath="//input[@id='supName1']")
		WebElement suppliernametxt;
		
		@FindBy(xpath="//textarea[@id='address']")
		WebElement addresstxt;
		@FindBy(xpath="//input[@id='supEmail']")
		WebElement emailtxt;
		@FindBy(xpath="//input[@id='supCon']")
		WebElement contacttxt;
		@FindBy(xpath="//input[@id='supplier_altNo']")
		WebElement altnotxt;
		@FindBy(xpath="//input[@id='nameAllValue2']")
		WebElement contpersonnametxt;
		@FindBy(xpath="//input[@id='supGst1']")
		WebElement gstno;
		@FindBy(xpath="//input[@id='supAdhar']")
		WebElement adharid;
		@FindBy(xpath="//input[@id='supPan1']")
		WebElement panno;
		@FindBy(xpath="//button[@class='btn btn-success btn-md float-center']")
		WebElement submitbtn;
		@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
		WebElement cancelbtn;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Actions A=new Actions(driver);

		public AddSuppliers() {
			PageFactory.initElements(driver, this);

		}
		public void verify_addsuppliers_titlename() {
			driver.getTitle();
			
		}
		public AddSuppliers Verify_addsupplier_funtionality(String supplier_name, String address, String email_id, String contact_no,
				String contact_personname, String gst_no, String adhar_no,String pan_no) {
			
			try {
				js.executeScript("arguments[0].click();",suppliernametxt );
				A.moveToElement(suppliernametxt).build().perform();
//			suppliernametxt.click();
				
				suppliernametxt.sendKeys(supplier_name);
				addresstxt.sendKeys(address);
				emailtxt.sendKeys(email_id);
				contacttxt.sendKeys(contact_no);
				contpersonnametxt.sendKeys(contact_personname);
				gstno.sendKeys(gst_no);
				adharid.sendKeys(adhar_no);
				panno.sendKeys(pan_no);
				submitbtn.click();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return new AddSuppliers();
		}
		
		
}
