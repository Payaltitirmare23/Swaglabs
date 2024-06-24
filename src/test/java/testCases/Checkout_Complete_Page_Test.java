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
import pages.Checkout_Complete_Page;
import pages.Checkout_Step_Two;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Checkout_Complete_Page_Test extends TestBase
{
	public LoginPage login;
	public Inventory_Page invent;
	public Cart_Page cart;
	public CheckOut_Step_One_Page check1;
	public Checkout_Step_Two check2;
	public Checkout_Complete_Page checkComplete;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		intialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOut_Step_One_Page();
		check2 =new Checkout_Step_Two();
		checkComplete= new Checkout_Complete_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCartIcon();
		cart.clickOnCheckoutBtn();
		check1.inputInformation();
		check2.clickOnFinishBtn();
	}
	
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle= ReadData.readExcelCheckout(5, 0); //Checkout: Complete!(5,0)
		String actTitle = checkComplete.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Page Title is = "+actTitle);	
	}
	@Test
	public void verifyPonyExpressImgTest()
	{
		boolean value = checkComplete.verifyPonyExpressImg();
		Assert.assertEquals(value, true);
		Reporter.log("Image is displayed = "+value);
	}
	@Test
	public void verifyThankYouHeaderTest() throws EncryptedDocumentException, IOException
	{
		String expHeader= ReadData.readExcelCheckout(5, 1); //Thank you for your order!(5,1)
		String actHeader = checkComplete.verifyThankYouHeader();
		Assert.assertEquals(expHeader, actHeader);
		Reporter.log("Header is = "+ actHeader);	
	}
	@Test
	public void verifyCompleteTxtTest() throws EncryptedDocumentException, IOException
	{
		String expText= ReadData.readExcelCheckout(5, 2); //Your order has been dispatched, and will arrive just as fast as the pony can get there!(5,2)
		String actText = checkComplete.verifyCompleteTxt();
		Assert.assertEquals(expText, actText);
		Reporter.log("Complete Text is = "+actText);	
	}
	@Test
	public void clickOnBackToHomeBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcelCheckout(5, 3); //https://www.saucedemo.com/inventory.html(5,3)
		String actURL= checkComplete.clickOnBackToHomeBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Back to home click = "+ actURL);
	}
	
	@AfterMethod(alwaysRun = true)
 public void closeBrowser(ITestResult it ) throws IOException {
    	
    	if(it.FAILURE ==it.getStatus())
    	{
    		Screenshot.cs(it.getName());
    	}
    	driver.close();
    }

}
