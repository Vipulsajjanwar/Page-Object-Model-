package com.stock.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.DispatchMaterial;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.PurchaseMaterialPage;
import com.stock.qa.pages.ReturnMaterial;
import com.stock.qa.pages.Settings;
import com.stock.qa.pages.SiteEstimate;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;

@Listeners(CustomListener.class)
public class SiteEstimateTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	DispatchMaterial DispatchPage;
	PurchaseMaterialPage PurchasePage;
	ReturnMaterial ReturnPage;
	Settings SettingsPage;
	TestUtil testutil;
	SiteEstimate SE;
	String sheetName= "site-estimate";
	public SiteEstimateTest(){
		super();
	}
	@BeforeTest
	public void Setup() {
		initialization();
		testutil = new TestUtil();
		PurchasePage = new PurchaseMaterialPage();
		DispatchPage = new DispatchMaterial();
		ReturnPage = new ReturnMaterial();
		SettingsPage= new Settings();
		loginPage = new LoginPage();
		SE =new SiteEstimate();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

//	@Test
//	public void SiteEstimateList() {
//		homePage.ClickOnSiteEstimate();
//		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//		SE.web_list();
//		
//	}
	@Test(priority=1)
	public void verify_SiteEstimateTitle() throws InterruptedException {
		
		homePage.ClickOnSiteEstimate();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String site=SE.verify_SiteEstimatePage_TitleName();
		Assert.assertEquals(site, "Site");
	}
	@DataProvider()
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider = "getTestData")
	public void Verify_SiteEstimate_Functionality_Test(String Site_Name, String Product_Name, String Unit, String Quantity ) {
		homePage.ClickOnSiteEstimate();
		SE.Verify_SiteEstimateFunctionality(Site_Name, Product_Name, Unit, Quantity);
		Assert.assertTrue(true);
	}
	
	@AfterSuite
	public void TearDown() {
		driver.close();
	}

}
