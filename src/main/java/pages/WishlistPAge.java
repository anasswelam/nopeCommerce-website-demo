package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPAge extends BasePage{

	public WishlistPAge(WebDriver driver) {
		super(driver);
	}
	@FindBy(name="removefromcart")
WebElement remove;
	
	@FindBy(name="updatecart")
	WebElement update;
	
@FindBy(css=".no-data")
WebElement seccesstext;
	
	public void removefromwishlist() {
		clickbutton(remove);
		clickbutton(update);
	}
}
