package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase {

	
	//object repository
	@FindBy(xpath = "//span[text()='Your Cart']") private WebElement cartTitle;
	@FindBy(xpath = "//div[@class='cart_quantity_label']")private WebElement cartQtyLabel;
	@FindBy(xpath = "//div[@class='cart_desc_label']")private WebElement cartDescLabel;
	@FindBy(xpath = "//button[@name='continue-shopping']") private WebElement contiShoppingBtn;
	@FindBy(xpath = "//button[@id='checkout']") private WebElement checkoutBtn;
	
	
	
	//calling
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//method
	
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyPageTitle ()
	{
		return cartTitle.getText();
	}
	
	public String verifyCartQty()
	{
		return cartQtyLabel.getText();
	}
	
	public String verifyPageDescTxt()
	{
		return cartDescLabel.getText();
	}
	
	public String  clickOnContinueShoppingBtn()
	{
		contiShoppingBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String clickOnCheckoutBtn()
	{
		 checkoutBtn.click();
		 return driver.getCurrentUrl();
	}
	
}
