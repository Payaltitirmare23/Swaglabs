package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDownList;

public class Inventory_Page extends TestBase{

	//object repository
	//calling
	//methods
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement productBackpack;
	@FindBy(xpath ="//button[@id='add-to-cart-sauce-labs-bike-light']" )private WebElement productBikelight;
	@FindBy(xpath = "//span[@class='title']") private WebElement pageTitle;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//select[@class='product_sort_container']")private WebElement dropDown;
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")private WebElement cartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")private WebElement cartIcon;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")private WebElement productBoltTshirt;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement productFleeceJacket;
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']")private WebElement productOnesie;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")private WebElement backPackItemName;
	@FindBy(xpath = "//div[contains(text(),'carry.allTheThings() with the sleek,')]")private WebElement backPackItemDesc;
	@FindBy(xpath="//div[text()='29.99']")private WebElement backPackPrice;
	@FindBy(xpath = "//img[@src='/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg']")private WebElement backpackItemImage;
	@FindBy(xpath="//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath="//a[text()='LinkedIn']")private WebElement linkedInLogo; 
	@FindBy(xpath = "//div[text()='© ']")private WebElement footerTxt;

	@FindBy(xpath="//button[@id='remove-sauce-labs-onesie']")private WebElement removeProductOnesie;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")private WebElement removeProductBikelight;
	
	public Inventory_Page() { //calling by using constructor
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String verifyPageTitle() 
	{
		return pageTitle.getText();
	}
	
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyFacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifyLinkedInLogo()
	{
		return linkedInLogo.isDisplayed();
	}
	public boolean verifyFooter()
	{
		return footerTxt.isDisplayed();
	}
	public String add6Products() throws InterruptedException
	{
		HandleDropDownList.handleSelect(dropDown, "Price (low to high)");
		Thread.sleep(2000);
		productBackpack.click();
		productBikelight.click();
		productBoltTshirt.click();
		productFleeceJacket.click();
		productOnesie.click();
		return cartCount.getText();
	}
	
	public String remove2Products() throws InterruptedException
	{
		add6Products(); //first call add method then we remove products
		Thread.sleep(2000);
		removeProductBikelight.click();
		removeProductOnesie.click();
		return cartCount.getText();
	}
	
	public boolean verifyBackPackImage()
	{
		return backpackItemImage.isDisplayed();	
	}	
	public String verifyBackPackName()
	{
		return backPackItemName.getText();
	}
	  public String verifyBackPackDesc()
	  {
		  return backPackItemDesc.getText();
	  }
	public String verifyBackPackPrice()
	{
		return backPackPrice.getText();
	}
	
	public void clickOnCartIcon() 
	{
		cartIcon.click();
	}
	
}
