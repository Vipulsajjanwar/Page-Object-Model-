package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.ReturnMaterial;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class ReturnMaterialTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	ReturnMaterial ReturnMaterialPage;
	TestUtil testUtil;

	public ReturnMaterialTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		ReturnMaterialPage = new ReturnMaterial();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0,groups="sanity")
	public void Verify_AddproducttitleName_Test() throws InterruptedException {
		homePage.clickOnReturnLink();
		Assert.assertEquals(ReturnMaterialPage.Verify_TitleName(), "Return Product");
	}
	@Test(priority=0,groups="sanity")
	public void Verify_ReturnMaterial_Functionality_Test() throws InterruptedException {
		homePage.clickOnReturnLink();
		ReturnMaterialPage.Verify_returnMaterial_functionality();
	}
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
