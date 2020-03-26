package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="strong.current-item")
	 public WebElement successsearchname;
	
@FindBy(linkText="16 review(s)")
WebElement reviewbtn;

@FindBy(linkText="Add your review")
WebElement Addreview;

@FindBy(id="add-to-cart-button-4")
WebElement Addtocart;

@FindBy(id="add-to-wishlist-button-4")
WebElement AddtoWishlist;

@FindBy(css=".button-2add-to-compare-list-button")
WebElement AddToComparelist;

@FindBy(css=".button-2 email-a-friend-button")
WebElement emailfriend;

@FindBy(xpath="//span[contains(@class,'actual-price')]")
public WebElement productPricelbl ;

public void addtowishlist() {
	clickbutton(AddtoWishlist);
}
public void addtocompare() {
	clickbutton(AddToComparelist);
}
public void Openemailfriendpage() {
	clickbutton(emailfriend);
	
}
public void OpenAddreviewPage() {
	clickbutton(Addreview);
	
}
public void Addtocart() {
	clickbutton(Addtocart);
}

}
