package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddSuppliers;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.TestUtil;

public class AddSuppliersTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	TestUtil testUtil;
	AddSuppliers AddSupplierPage;
	String sheetName="add-supplier";
	public AddSuppliersTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		AddSupplierPage=new AddSuppliers();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0,groups="sanity")
	public void Verify_AddproducttitleName_Test() throws InterruptedException {
		SettingsPage.ClickOnAddSuppliers();
		Assert.assertEquals(driver.getTitle(),"Add Supplier");
	}
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,groups="sanity",dataProvider = "getTestData")
	public void Verify_Addsupplier_Functionality_Test(String supplier_name, String address, String email_id, String contact_no,
			String contact_personname, String gst_no, String adhar_no,String pan_no) throws InterruptedException {
		SettingsPage.ClickOnAddSuppliers();
		AddSupplierPage.Verify_addsupplier_funtionality(supplier_name,address,email_id,contact_no,contact_personname,gst_no,adhar_no,pan_no);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
