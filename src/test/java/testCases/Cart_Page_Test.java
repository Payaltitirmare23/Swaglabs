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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase {
	
	public LoginPage login;
	public Inventory_Page invent;
	public Cart_Page cart;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		intialization();
		login= new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		login.loginToApplication();	
		invent.add6Products();
		invent.clickOnCartIcon();		
	}
	
	@Test
	public void verifyCartPageURLTest() throws  EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcelCart(0, 0); //0,0
		String actURL = cart.verifyCartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("The cart URL is ="+ actURL);
	}

	@Test(dependsOnMethods = "verifyCartPageURLTest")
	public void verifyCartTitleTest() throws EncryptedDocumentException, IOException
	{
		 String expTitle = ReadData.readExcelCart(0, 1); //(0,1)
	     String actTitle =	cart.verifyPageTitle();
	     Assert.assertEquals(expTitle, actTitle);
	     Reporter.log("Title of cart page is = "+actTitle);
	}
	
	@Test(dependsOnMethods = "verifyCartPageURLTest")
	public void verifyCartQtyTest() throws EncryptedDocumentException, IOException
	{
		String expTxt =ReadData.readExcelCart(0, 2); //(0,2)
		String actTxt = cart.verifyCartQty();
		Assert.assertEquals(expTxt, actTxt);
		Reporter.log("Quality text is displayed = "+ actTxt);		
	}
	
	@Test(dependsOnMethods = "verifyCartPageURLTest",priority=1)
	public void verifyCartDescTest() throws EncryptedDocumentException, IOException
	{
		String expDesc =ReadData.readExcelCart(0, 3); //(0,3)
		String actDesc = cart.verifyPageDescTxt();
		Assert.assertEquals(expDesc, actDesc);
		Reporter.log("Cart  Description  is displayed = "+ actDesc);		
	}
	
	@Test(dependsOnMethods = "verifyCartPageURLTest")
	public void clickOnContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcelCart(0, 4); //(0,4)https://www.saucedemo.com/inventory.html
		String actURL= cart.clickOnContinueShoppingBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Continue shopping page step one URL ="+ actURL);
	}
	
	@Test(dependsOnMethods = "verifyCartPageURLTest")
	public void clickOnCheckoutBtnTest() throws EncryptedDocumentException, IOException 
	{
		String expURL= ReadData.readExcelCart(0, 5); //https://www.saucedemo.com/checkout-step-one.html(0,5)
		String actURL =cart.clickOnCheckoutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("checkout page step one URL = "+ actURL);		
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException 
	{
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName()); //give fail method name
		}
		driver.close();
	}
	
}
