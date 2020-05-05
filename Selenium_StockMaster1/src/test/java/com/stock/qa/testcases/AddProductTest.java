package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddProduct;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class AddProductTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	AddProduct AddProductPage;
	Settings SettingsPage;
	TestUtil testUtil;
	String sheetName= "add-product";
	public AddProductTest() {
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
	@Test(priority=0,groups="sanity")
	public void Verify_AddproducttitleName_Test() throws InterruptedException {
		SettingsPage.ClickOnAddProduct();
		Assert.assertEquals(AddProductPage.verify_addproductpage_titlename(),"Add Product");
	}
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=1,groups="sanity", dataProvider = "getTestData")
	public void Verify_AddProduct_Functionality_Test(String category_name,String product_name,String hsn_no,String alias_name,
			String storage_unit1, String storage_unit2) throws Exception {
		SettingsPage.ClickOnAddProduct();
		AddProductPage.Verify_addproduct(category_name, product_name, hsn_no, alias_name, storage_unit1, storage_unit2);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
