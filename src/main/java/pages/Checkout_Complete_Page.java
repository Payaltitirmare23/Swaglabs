package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Checkout_Complete_Page extends TestBase
{
	@FindBy(xpath = "//span[text()='Checkout: Complete!']")public WebElement pageTitle;
	@FindBy(xpath = "//img[@alt='Pony Express']")public WebElement ponyExpressImg ; 
	@FindBy(xpath = "//h2[@class='complete-header']")public WebElement thankYouHeader; 
	@FindBy(xpath = "//div[@class='complete-text']")public WebElement completeTxt ; 
	@FindBy(xpath = "//button[@id='back-to-products']")public WebElement backToHomeBtn; 

	public Checkout_Complete_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle() {
		return pageTitle.getText();
	}
	public boolean verifyPonyExpressImg()
	{
		return ponyExpressImg.isDisplayed();
	}
	public String verifyThankYouHeader()
	{
		return thankYouHeader.getText();
	}
	public String verifyCompleteTxt()
	{
		return completeTxt.getText();
	}
	public String clickOnBackToHomeBtn()
	{
		backToHomeBtn.click();
		return driver.getCurrentUrl();
	}
}
