package com.stock.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class PurchaseMaterialPage extends TestBase{
	@FindBy(xpath="//span[@id='select2-suppID-container']")
	WebElement selectsuppliername;
	@FindBy(xpath="//input[@id='billAmtId']")
	WebElement billamount;
	@FindBy(xpath="//input[@id='InvoiceId']")
	WebElement invoiceno;
	@FindBy(xpath="//span[@id='select2-productID-container']")
	WebElement selectproductname;
	@FindBy(xpath="//span[@id='select2-unitId-container']")
	WebElement selectunit;
	@FindBy(xpath="//input[@id='QuantityId']")
	WebElement quantity;
	@FindBy(xpath="//button[@id='subBut']")
	WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	@FindBy(xpath="//button[@class='btn btn-md btn-primary']")
	WebElement addproductbtn;
	@FindBy(xpath="//li[@id='select2-suppID-result-jho6-20']")
	WebElement supervisorName;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	Actions A=new Actions(driver);
	
	public PurchaseMaterialPage() {
		PageFactory.initElements(driver, this);
	}

	public String verify_purchase_titleName() {
		return driver.getTitle();
	}
	public PurchaseMaterialPage Verify_PurchaseMaterial_Functionality() {
		
		selectsuppliername.click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("vipul");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);	
		billamount.sendKeys("1234");
		invoiceno.sendKeys("1111");
		
		selectproductname.click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("laptop");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys((Keys.ENTER));
		selectunit.click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Qty");
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
		quantity.sendKeys("10");
		submitbtn.click();
		submitbtn.sendKeys(Keys.RETURN);

		return new PurchaseMaterialPage();
	}
}
