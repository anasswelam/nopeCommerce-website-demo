package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends BasePage{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css="div.result")
	public WebElement successmessage;
	
	@FindBy(id="addproductrating_5")
	WebElement rating;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewtext;
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewtitle;
	
	@FindBy(name="add-review")
	WebElement submit;

	public void addreview(String title, String review) {
		sendkeys(reviewtitle, title);
		sendkeys(reviewtext, review);
		clickbutton(rating);
		clickbutton(submit);
	}
	
}
