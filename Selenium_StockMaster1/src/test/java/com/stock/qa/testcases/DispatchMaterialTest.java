package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.DispatchMaterial;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class DispatchMaterialTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	TestUtil testUtil;
	DispatchMaterial DispatchmaterialPage;
	public DispatchMaterialTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		DispatchmaterialPage=new DispatchMaterial();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void Verify_DispatchMaterialTitleName_Test() {
		homePage.clickOnDispatchLink();
		Assert.assertEquals(DispatchmaterialPage.Verify_TitleName(), "Dispatch Products");
	}
	@Test
	public void Verify_DispatchMaterial_Functionality_Test() {
		homePage.clickOnDispatchLink();
		DispatchmaterialPage.Verify_Dispatch_Functionality();
	
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
