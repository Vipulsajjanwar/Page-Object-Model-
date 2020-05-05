package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddProduct;
import com.stock.qa.pages.AddProductCategory;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class Setting_test extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AddProductCategory AddproductCategoryPage;
	TestUtil testUtil;
	AddProduct AddProductPage;
	Settings SettingsPage;
	
	public Setting_test() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		AddProductPage = new AddProduct();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(groups="sanity")
	public void Verify_Setting_Test() throws InterruptedException {
		 
		SettingsPage.ClickOnSettings();
		Assert.assertTrue(SettingsPage.verifyClickOnSettings());
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
	