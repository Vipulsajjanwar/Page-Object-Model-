package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;

public class AddProductCategory extends TestBase {

	@FindBy(xpath= "//input[@id='alphaID']")
	WebElement addProductCategoryTxtBox;
	
	@FindBy(xpath="//button[@class='btn btn-success btn-md float-center']")
	WebElement submitbtn;
	
	@FindBy(xpath="//a[@class='btn btn-warning btn-md']")
	WebElement cancelbtn;
	
	@FindBy(xpath="//legend[contains(text(),'Category Details')]")
	WebElement categorydetailstitle;
	JavascriptExecutor js = (JavascriptExecutor)driver;

	// Initializing the Page Objects:
			public AddProductCategory() {
				PageFactory.initElements(driver, this);
			}
			public String VerifyAddProductCategoryPageTitle(){
				return driver.getTitle();
			}
			public boolean VerifyAddProductCategoryTxtBox(){
				return addProductCategoryTxtBox.isDisplayed() ;
			}
			public boolean VerifyAddProductCategorySubmitBtn(){
				return	submitbtn.isDisplayed();
			}
			public HomePage VerifyAddProductCategoryCancelBtn(){
				cancelbtn.isDisplayed();
				cancelbtn.click();
				return new HomePage();
			}	
			public AddProductCategory Enter_Addproductcategory(String category_name) {
//				addProductCategoryTxtBox.clear();
//				addProductCategoryTxtBox.click();
				js.executeScript("arguments[0].click();", addProductCategoryTxtBox);

				addProductCategoryTxtBox.sendKeys(category_name);
				submitbtn.click();
				return new AddProductCategory();
			}
			
}
