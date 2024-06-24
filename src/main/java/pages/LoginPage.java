package pages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;
import utility.ReadData;
//write actual logic in this class
public class LoginPage extends TestBase
{
	
	@FindBy(xpath = "//input[@id='user-name']") private WebElement userTxtBox; //standarduser
	@FindBy(xpath = "//input[@id='password']") private WebElement passWordTextBox; //secretsauce
	@FindBy(xpath = "//input[@id='login-button']")private WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String  loginToApplication() throws IOException
	{
		userTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		passWordTextBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl(); //https://www.saucedemo.com/inventory.html
	}
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication() 
	{
		return driver.getTitle();
	}
	//for multiple values login 
	public String verifyMultiCredentials(String userName, String password)
	{
		userTxtBox.sendKeys(userName);
		passWordTextBox.sendKeys(password);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
}
