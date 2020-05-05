package com.stock.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stock.qa.base.TestBase;
public class LoginPage extends TestBase{
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='userName']")
	WebElement username;

	@FindBy(name="pass")
	WebElement password;

	@FindBy(xpath="//button[@class='btn btn-success float-right']")
	WebElement loginBtn;

	@FindBy(xpath="//span[@class='text-center']")
	WebElement StockMLogo;

	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public boolean validateStockLogo(){
		return StockMLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
//		loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}

}
