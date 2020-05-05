package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.util.CustomListener;
@Listeners(CustomListener.class)

public class LoginTestCase extends TestBase{
	LoginPage loginPage;
	HomePage homePage;

	public LoginTestCase(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}

	@Test(priority=1, groups="sanity")
	public void Verify_LoginPageTitle_Test(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Stock Master");

	}

	@Test(priority=2,groups="sanity")
	public void Verify_StockLogoImage_Test(){
		boolean flag = loginPage.validateStockLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=3,groups="sanity")
	public void Verify_login_Test(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
