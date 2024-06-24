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
import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;
import pages.Cart_Page;
import pages.CheckOut_Step_One_Page;
import pages.Checkout_Step_Two;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Checkout_Step_Two_Test extends TestBase
{
	public LoginPage login;
	public Inventory_Page invent;
	public Cart_Page cart;
	public CheckOut_Step_One_Page check1;
	public Checkout_Step_Two check2;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		intialization();
		login = new LoginPage();
		invent = new Inventory_Page();
		cart = new Cart_Page();
		check1 = new CheckOut_Step_One_Page();
		check2 =new Checkout_Step_Two();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCartIcon();
		cart.clickOnCheckoutBtn();
		check1.inputInformation();		
	}
	
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcelCheckout(4, 0); //(4,0)
		String actTitle = check2.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The Page Title is = "+ actTitle);		
	}
	@Test(groups= {"smoke"})
	public void verifyCartQtyLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcelCheckout(4, 1); //(4,1)
		String actLabel = check2.verifyCartQtyLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("The cart quality label  is = "+ actLabel);
	}
	@Test
	public void verifyCartDescLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcelCheckout(4, 2); //(4,2)
		String actLabel = check2.verifyCartDescLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("The cart Description label  is = "+ actLabel);
	}
	@Test(groups= {"smoke"})
	public void verifyPaymentInfoLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLabel = ReadData.readExcelCheckout(4, 3); //(4,3)
		String actLabel = check2.verifyPaymentInfoLabel();
		Assert.assertEquals(expLabel, actLabel);
		Reporter.log("The Payment Information  label  is = "+ actLabel);
	}
	@Test
	public void verifyPaymentValueLabelTest() throws EncryptedDocumentException, IOException
	{
		String expValue = ReadData.readExcelCheckout(4, 4); //(4,4)
		String actValue = check2.verifyPaymentValueLabel();
		Assert.assertEquals(expValue, actValue);
		Reporter.log("The Payment value is = "+ actValue);
	}
	@Test(groups= {"Retest"})
	public void verifyShippingInfoLAbelTest() throws EncryptedDocumentException, IOException
	{
		String expLable = ReadData.readExcelCheckout(4, 5); //(4,5)
		String actLable = check2.verifyShippingInfoLAbel();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("The shipping InformationLabel is = "+ actLable);
	}
	@Test(groups= {"Retest"})
	public void verifyShippingValueLabelTest() throws EncryptedDocumentException, IOException
	{
		String expValue = ReadData.readExcelCheckout(4, 6); //(4,6)
		String actValue = check2.verifyShippingValueLabel();
		Assert.assertEquals(expValue, actValue);
		Reporter.log("The shipping value is = "+ actValue);
	}
	@Test
	public void verifyPriceTotalLabelTest() throws EncryptedDocumentException, IOException
	{
		String expLable = ReadData.readExcelCheckout(4, 7); //(4,7)
		String actLable = check2.verifyPriceTotalLabel();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("The price Total Label is = "+ actLable);
	}
	@Test(groups= {"smoke"})
	public void verifySubTotalLabelTest() throws EncryptedDocumentException, IOException
	{
		String expsubTotal = ReadData.readExcelCheckout(4, 8); //(4,8)
		String actsubTotal = check2.verifySubTotalLabel();
		Assert.assertEquals(expsubTotal, actsubTotal);
		Reporter.log("The sub Total Label is = "+ actsubTotal);
	}
	@Test
	public void verifyTaxLabelTest() throws EncryptedDocumentException, IOException
	{
		String expTax = ReadData.readExcelCheckout(4, 9); //(4,9)
		String actTax = check2.verifyTaxLabel();
		Assert.assertEquals(expTax, actTax);
		Reporter.log("The tax is = "+ actTax);
	}
	@Test(groups= {"Retest"})
	public void verifyTotalLabelTest() throws EncryptedDocumentException, IOException
	{
		String expTotal = ReadData.readExcelCheckout(4, 10); //(4,10) Total: $123.07
		String actTotal = check2.verifyTotalLabel();
		Assert.assertEquals(expTotal, actTotal);
		Reporter.log("The Total is = "+ actTotal);
	}
	@Test
	public void clickOnCancelButtonTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcelCheckout(4, 11); //https://www.saucedemo.com/inventory.html(4,11)
		String actURL= check2.clickOnCancelButton();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on back button = "+ actURL);
	}
	
	@Test(groups= {"Retest"})
	public void clickOnFinishBtnTest() throws EncryptedDocumentException, IOException
	{
		String expURL= ReadData.readExcelCheckout(4, 12); //https://www.saucedemo.com/checkout-complete.html (4,12)
		String actURL= check2.clickOnFinishBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("After clicking on Finish button = "+ actURL);
	}
	@Test
	public void verifyBackImgTest()
	{
		boolean value = check2.verifyBackImg();
		Assert.assertEquals(value, true);
		Reporter.log("The back image is displayed = "+ value);
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
