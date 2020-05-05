package com.stock.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.stock.qa.base.TestBase;
import com.stock.qa.pages.AddSupervisor;
import com.stock.qa.pages.HomePage;
import com.stock.qa.pages.LoginPage;
import com.stock.qa.pages.Settings;
import com.stock.qa.util.CustomListener;
import com.stock.qa.util.TestUtil;
@Listeners(CustomListener.class)

public class AddSupervisorTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	Settings SettingsPage;
	TestUtil testUtil;
	AddSupervisor AddSupervisorPage;
	String sheetName="add-supervisor";
	public AddSupervisorTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {

		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		SettingsPage= new Settings();
		AddSupervisorPage=new AddSupervisor();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=0,groups="sanity")
	public void Verify_AddSupervisorTitleName_Test() throws InterruptedException {
		SettingsPage.ClickOnAddSupervisor();
		Assert.assertEquals(driver.getTitle(),"Add Supervisor");
	}
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=1,groups="sanity", dataProvider = "getTestData")
	public void Verify_AddSupervisorFunctionality_Test(String supervisor_name,String address1,String email_id,
			String contact_no,String alt_contact_no,String adhar_no,String pan_no ) throws InterruptedException {
		SettingsPage.ClickOnAddSupervisor();
		AddSupervisorPage.verify_addsupervisor_functionality(supervisor_name,address1,email_id,contact_no,
				alt_contact_no,adhar_no,pan_no);
	}
	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
