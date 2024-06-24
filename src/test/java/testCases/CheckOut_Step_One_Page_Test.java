package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Cart_Page;
import pages.CheckOut_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class CheckOut_Step_One_Page_Test extends TestBase{

	public LoginPage login;
	public Inventory_Page invent;
	public Cart_Page cart;
	public CheckOut_Step_One_Page check1;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		intialization();
		login= new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOut_Step_One_Page();
		login.loginToApplication();	
		invent.add6Products();
		invent.clickOnCartIcon();	
		cart.clickOnCheckoutBtn(); //to navigate to another page
	}
	
	@Test(groups= {"smoke"})
	public void inputInformationTest() throws EncryptedDocumentException, IOException
	{
		String expURL =ReadData.readExcelCheckout(0, 3); //(0,3)https://www.saucedemo.com/checkout-step-two.html
		String  actURL = check1.inputInformation();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkout Page 2 URL = "+ actURL);
	}
	
	@Test(groups= {"smoke"})
	public void clickOnCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcelCheckout(0, 4); //carturl
	   String actURL= check1.clickOnCancelBtn();
	   Assert.assertEquals(expURL, actURL);
	   Reporter.log("After cancel the url is = "+ actURL);
	}	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName()); //give fail method name
		}
		driver.close();
	}
	
	
}
