package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.TestBase;

public class Checkout_Step_Two extends TestBase 
{
	@FindBy(xpath="//span[text()='Checkout: Overview']")private WebElement pageTitle ;
	@FindBy(xpath="//div[@class='cart_quantity_label']")private WebElement cartQtyLabel;
	@FindBy(xpath="//div[@class='cart_desc_label']")private WebElement cartDescLabel ;
	@FindBy(xpath="//div[text()='Payment Information:']")private WebElement paymentInfoLabel;
	@FindBy(xpath="//div[text()='SauceCard #31337']")private WebElement paymentValueLabel ;
	@FindBy(xpath="//div[text()='Shipping Information:']")private WebElement shippingInfoLabel;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']")private WebElement shippingValueLabel;
	@FindBy(xpath="//div[text()='Price Total']")private WebElement priceTotalLabel;
	@FindBy(xpath="//div[contains(text(),'Item total: $')]")private WebElement subTotalLabel ;
	@FindBy(xpath="//div[@class='summary_tax_label']")private WebElement taxLabel;
	@FindBy(xpath="//div[@class='summary_total_label']")private WebElement totalLabel;
	@FindBy(xpath="//button[@id='cancel']")private WebElement cancelButton;
	@FindBy(xpath="//img[@class='back-image']")private WebElement backImg;
	@FindBy(xpath="//button[@id='finish']")private WebElement finishBtn;
	
	public Checkout_Step_Two()
	{
	  PageFactory.initElements(driver, this);
	}	
	//methods
	public String verifyPageTitle()
	{
		return pageTitle.getText();
	}
	
	public String verifyCartQtyLabel()
	{
		return cartQtyLabel.getText();
	}
	public String verifyCartDescLabel()
	{
		return cartDescLabel.getText();
	}
	public String verifyPaymentInfoLabel()
	{
		return paymentInfoLabel.getText();
	}
	public String verifyPaymentValueLabel()
	{
		return paymentValueLabel.getText();
	}
	public String verifyShippingInfoLAbel()
	{
		return shippingInfoLabel.getText();
	}
	public String verifyShippingValueLabel()
	{
		return shippingValueLabel.getText();	
	}
	public String verifyPriceTotalLabel()
	{
		return priceTotalLabel.getText();
	}
	public String verifySubTotalLabel()
	{
		return subTotalLabel.getText();
	}
	public String verifyTaxLabel()
	{
		return taxLabel.getText();			
	}
	public String verifyTotalLabel()
	{
		return totalLabel.getText();
	}
	public String clickOnCancelButton()
	{
		cancelButton.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyBackImg()
	{
		return backImg.isDisplayed();
	}
	public String clickOnFinishBtn()
	{
		finishBtn.click();
		return driver.getCurrentUrl();
	}
	
	
}
