package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckOut_Step_One_Page extends TestBase
{
	
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@id='last-name']")private WebElement lastNameTxtBox;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement postCodeTxtBox;
	@FindBy(xpath = "//input[@id='continue']")private WebElement continueBtn;
	@FindBy(xpath = "//span[text()='Checkout: Your Information']")private WebElement pageTitle;
	@FindBy(xpath="//button[@id='cancel']") private WebElement cancelBtn;
	
	
	public CheckOut_Step_One_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String inputInformation() throws EncryptedDocumentException, IOException
	{
		firstNameTxtBox.sendKeys(ReadData.readExcelCheckout(0, 0));
		lastNameTxtBox.sendKeys(ReadData.readExcelCheckout(0, 1));
		postCodeTxtBox.sendKeys(ReadData.readExcelCheckout(0, 2));
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String clickOnCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
}
