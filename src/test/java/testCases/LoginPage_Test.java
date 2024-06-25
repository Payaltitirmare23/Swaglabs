package testCases;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;
public class LoginPage_Test extends TestBase{

	public LoginPage login;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException {
		intialization();
		login = new LoginPage();		
	}
	
	@Test
	public void verifyURLOfApplication() throws EncryptedDocumentException, IOException {
		String expURL =ReadData.readExcel(0, 1);  //https://www.saucedemo.com/
		String actURL = login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
	}
	 
	@Test(priority=1,enabled=false)
	public void verifyTitleOfApplication() throws EncryptedDocumentException, IOException {
		String expTitle =ReadData.readExcel(0, 2); //Swag Labs(0,2)
		String actTitle= login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
	}
	
	@Test
	public void loginToApplication() throws IOException {
		String expURL= ReadData.readExcel(0, 0);// https://www.saucedemo.com/inventory.html(0,0)
		String actURL = login.loginToApplication();
		Assert.assertEquals(expURL, actURL);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException {
		if(it.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName()); //give fail method name and take a ss
		}		
		driver.close();
	}
	
	
}
