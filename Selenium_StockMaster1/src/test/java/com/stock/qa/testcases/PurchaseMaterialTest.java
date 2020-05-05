package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.PurchaseMaterialPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class PurchaseMaterialTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	TestUtil testUtil;
	PurchaseMaterialPage PurchasematerialPage;
	public PurchaseMaterialTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		PurchasematerialPage= new PurchaseMaterialPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void Verify_Purchasematerial_Titlename_Test() {
		homePage.clickOnPurchaseLink();
		Assert.assertEquals(PurchasematerialPage.verify_purchase_titleName(), "Purchase Product");
	}
	@Test
	public void Verify_Purchasematerial_functionality_Test() {
		homePage.clickOnPurchaseLink();
		PurchasematerialPage.Verify_PurchaseMaterial_Functionality();
		Assert.assertTrue(true, "passed");
	}
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
	
	
}
