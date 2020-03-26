package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
@FindBy(css="strong.current-item")
public WebElement successhover;
	
	@FindBy(linkText="Log in")
	WebElement loginbtn;
	
	@FindBy(linkText="Register")
	WebElement regbtn;
	
	@FindBy(linkText="Wishlist")
	WebElement wishlistbtn;
	
	@FindBy(linkText="Shopping cart")
	WebElement shoppingbtn;
	
	@FindBy(id="small-searchterms")
	WebElement searchtext;
	
	@FindBy (css="strong.current-item")
	public WebElement successSearch;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productlist;
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement producttitle;
	
	@FindBy(xpath="//input[contains(@class,'search-box-button')]")
	WebElement searchtbtn;
	
	@FindBy(linkText="Computers")
	WebElement ComputerMenu; 
	
	@FindBy(linkText="Notebooks")
	WebElement NotbooksMenu; 
	 
	@FindBy(id="customerCurrency")
	WebElement currencybtn; 
	
	@FindBy(linkText="Contact us")
	WebElement contactusbtn; 
	
	public void OpenRegtPage() {
		clickbutton(regbtn);
	}
	
	public void OpenLoginPage() {
		clickbutton(loginbtn);
	}
	
	public void OpenCompMen() {
		clickbutton(ComputerMenu);
	}
	
	public void UserSearch(String value) {
		creartext(searchtext);
		sendkeys(searchtext, value);
		searchtbtn.submit();
	}
	public void searchproductusingautosuggest(String value) {
		sendkeys(searchtext, value);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productlist.get(0).click();
		}
	
	
	public void OpenproductDetailPage(String value) {
		sendkeys(producttitle, value);
		clickbutton(producttitle);
		
	}
	public void OpenContactUs() {
		scroll();
		clickbutton(contactusbtn);
	}
	
	public void ChangeCurency(String text) {
		Select select = new Select(currencybtn);
		select.selectByVisibleText(text);
	}
	
	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build()
		.perform();
	}
	
}
