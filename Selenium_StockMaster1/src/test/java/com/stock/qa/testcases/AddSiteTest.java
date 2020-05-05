package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddSite;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)
public class AddSiteTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	TestUtil testUtil;
	AddSite AddSitePage;
	String sheetName="add-site";
	public AddSiteTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		AddSitePage = new AddSite();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0,groups="sanity")
	public void Verify_AddSitetitleName_Test() throws InterruptedException {
		SettingsPage.ClickOnAddSite();
		Assert.assertEquals(driver.getTitle(),"Site");
	}
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void Verify_AddsiteFunctionality_Test(String site_name, String office_email,String office_contactno,
			String contact_personname,String contact_personno) throws InterruptedException {
		SettingsPage.ClickOnAddSite();
		AddSitePage.Verify_addsite_functionality(site_name,office_email,office_contactno,contact_personname,contact_personno);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
