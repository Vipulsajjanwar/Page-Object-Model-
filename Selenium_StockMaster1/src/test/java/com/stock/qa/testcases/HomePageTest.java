package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.pages.DispatchMaterial;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.PurchaseMaterialPage;
import com.stock.qa.pages.ReturnMaterial;
import com.stock.qa.pages.Settings;
import com.stock.qa.pages.SiteEstimate;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
import com.stock.qa.base.TestBase;
@Listeners(CustomListener.class)

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	PurchaseMaterialPage PurchasePage;
	DispatchMaterial DispatchPage;
	ReturnMaterial ReturnPage;
	Settings SettingsPage;
	SiteEstimate SiteEstimatePage;
	public HomePageTest() {
		super();
	}
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		PurchasePage = new PurchaseMaterialPage();
		DispatchPage = new DispatchMaterial();
		ReturnPage = new ReturnMaterial();
		SettingsPage= new Settings();
		SiteEstimatePage= new SiteEstimate();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1,groups="sanity")
	public void Verify_HomePageTitle_Test(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Admin Dashboard");
	}

	@Test(priority=2,groups="sanity")
	public void Verify_CorrectCompanyLogo_Test(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectCompanyLogo());
	}

	@Test(priority=3)
	public void Verify_DispatchMaterialLink_Test(){
		//testUtil.switchToFrame();
		DispatchPage = homePage.clickOnDispatchLink();
	}
	@Test(priority=4)
	public void Verify_ReturnMaterialLink_Test(){
		//testUtil.switchToFrame();
		ReturnPage = homePage.clickOnReturnLink();
	}@Test(priority=5)
	public void Verify_SettingsLink_Test(){
		//testUtil.switchToFrame();
	SettingsPage = homePage.ClickOnSettingsLink();
	}
	@Test
	public void Verify_SiteEstimateLink_Test() {
		SiteEstimatePage = homePage.ClickOnSiteEstimate();
	}
	@Test(priority=6)
	public void Verify_LogoutBtn_Test(){
		//testUtil.switchToFrame();
	loginPage = homePage.clickOnLogoutBtn();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}