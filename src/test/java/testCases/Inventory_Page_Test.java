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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase {

	public LoginPage login ;
	public Inventory_Page invent;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		intialization();
		login = new LoginPage();	
		invent = new Inventory_Page();
		login.loginToApplication();
	}
	
	@Test(groups= {"smoke"})
	public void verifyTwitterLogoTest() throws  IOException {
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result, true); 
		Reporter.log("Twitter Logo is present= "+ result);
	}
	
	@Test(groups= {"smoke"})
	public void add6ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=  ReadData.readExcel(0, 3);//"5" (0,3)
		String actCount =invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Actual count is= "+ actCount);
	}
	
	@Test
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount= ReadData.readExcel(0, 4); //"3"(0,4)
		String actCount= invent.remove2Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("After removing 2 products total count is = "+actCount);
	}
	
	@Test
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle =ReadData.readExcel(0, 5); //Products(0,5)
		String actTitle =invent.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("The page title is = "+actTitle);
	}
	

	@Test
	public void verifyBackPackNameTest() throws EncryptedDocumentException, IOException
	{
		String expName= ReadData.readExcel(0, 6); //Sauce Labs Backpack(0,6)
		String actName = invent.verifyBackPackName();
		Assert.assertEquals(expName, actName);
		Reporter.log("The product name is ="+ actName);
	}
	@Test(groups= {"smoke"})
	public void verifyBackPackDescTest() throws EncryptedDocumentException, IOException
	{
		String expDesc= ReadData.readExcel(0, 7);//carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.(0,7)
		String actDesc = invent.verifyBackPackDesc();
		Assert.assertEquals(expDesc, actDesc);
		Reporter.log("The Description is = "+ actDesc);
	}
	@Test
	public void verifyBackPackPriceTest() throws EncryptedDocumentException, IOException
	{
		String expPrice = ReadData.readExcel(0, 8);//$29.99"(0,8)
		String actPrice = invent.verifyBackPackPrice();
		Assert.assertEquals(expPrice, actPrice);
		Reporter.log("Price of product is = "+ actPrice);
	}
	@Test
	public void verifyFacebookLogoTest()
	{
		boolean logoResult = invent.verifyFacebookLogo();
		Assert.assertEquals(logoResult, true);
		Reporter.log("Facebook logo is present = "+logoResult);
	}
	@Test(groups= {"smoke"})
	public void verifyLinkedInLogoTest()
	{
		boolean logoResult = invent.verifyLinkedInLogo();
		Assert.assertEquals(logoResult, true);
		Reporter.log("LinkedIn logo is present = "+logoResult);
	}
	@Test
	public void verifyCopyrightTest()
	{
		boolean result = invent.verifyFooter();
		Assert.assertEquals(result, true);
		Reporter.log(" footer text is present = "+result);
	}
		
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName()); //give fail method name
		}
		
		driver.close();
	}
	
}
