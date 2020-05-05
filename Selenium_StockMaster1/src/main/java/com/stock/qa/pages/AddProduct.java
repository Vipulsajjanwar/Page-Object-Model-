package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class AddProduct extends TestBase {
	@FindBy(xpath="//div[@class='col-md-6 inner-addon right-addon']//input[@id='alphaID']")
	WebElement productcategorynametxt;
	@FindBy(xpath="//body/div[@id='main-wrapper']/div[@class='page-wrapper']/div[@class='container-fluid']/div"
			+ "[@class='row']/div[@class='col-12']/div[@class='card']/div[@class='card-body']/form/fieldset[@class="
			+ "'col-md-12']/div[2]/div[1]/input[1]")
	WebElement productnametxt;
	@FindBy(xpath="//input[@id='hsnNo']")
	WebElement Hsnnotxt;
	@FindBy(xpath="//input[@id='aliasID']")
	WebElement aliasnametxt;
	@FindBy(xpath="//input[@name='SmallQuantity']")
	WebElement storageunittxt1;
	@FindBy(xpath="//input[@name='LargeQuantity']")
	WebElement storageunittxt2;
	@FindBy(xpath="//button[@class='btn btn-success btn-md']")
	WebElement submitbtn;
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	public AddProduct() {
		PageFactory.initElements(driver, this);
	}
	
	public String verify_addproductpage_titlename() {
		return driver.getTitle();
	}
	
	public AddProduct Verify_addproduct(String category_name,String product_name,String hsn_no,String alias_name,
			String storage_unit1, String storage_unit2) throws Exception {
    	js.executeScript("arguments[0].click();", productcategorynametxt);
		productcategorynametxt.sendKeys(category_name);
		productnametxt.sendKeys(product_name);
		Hsnnotxt.sendKeys(hsn_no);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", aliasnametxt);
		Actions A=new Actions(driver);
		A.moveToElement(aliasnametxt).build().perform();
		
		aliasnametxt.sendKeys(alias_name);

		storageunittxt1.sendKeys(storage_unit1);
		storageunittxt2.sendKeys(storage_unit2);
		submitbtn.click();
		return new AddProduct();
	}
}
