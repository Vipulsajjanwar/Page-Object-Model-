package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddProductCategory;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class AddProductCategoryTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	AddProductCategory AddproductCategoryPage;
	TestUtil testUtil;
	Settings SettingsPage;
	String sheetName="add-productcategory";
	public AddProductCategoryTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		AddproductCategoryPage= new AddProductCategory();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=0,groups="sanity")
	public void Verify_Settings_Test() throws InterruptedException {
		SettingsPage.ClickOnSettings();
		Assert.assertTrue(SettingsPage.verifyClickOnSettings());
	}
	@Test(priority=1,groups="sanity")
	public void Verify_Addproduct_Category_TitleNameTest() throws InterruptedException {
		SettingsPage.ClickOnAddProductCategory();
		Assert.assertEquals(driver.getTitle(), "Add Product Category");
	}
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2,groups="sanity", dataProvider = "getTestData")
	public void Verify_Addproductcategory_Test(String category_name) throws InterruptedException {
		SettingsPage.ClickOnAddProductCategory();
//		Thread.sleep(3000);
		AddproductCategoryPage.Enter_Addproductcategory(category_name);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
}
