package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingPage extends BasePage {

	public ShoppingPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "removefromcart")
	WebElement removeCheck;

	@FindBy(name = "updatecart")
	WebElement updateCartBtn;

	@FindBy(css = "input.qty-input valid")
	public WebElement quantityTxt;

	@FindBy(css = "span.product-subtotal")
	public WebElement totalLbl;

	
	@FindBy(id="checkout")
	WebElement checkoutBtn ; 
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckbox; 
	

	public void RemoveProductFromCart() {
		clickbutton(removeCheck);
		clickbutton(updateCartBtn);
	}

	public void UpdateProductQuantityInCart(String quantity) {
		creartext(quantityTxt);
		sendkeys(quantityTxt, quantity);
		clickbutton(updateCartBtn);
	}

	public void openCheckoutPage() 
	{
		clickbutton(agreeCheckbox);
		clickbutton(checkoutBtn);
	}
	
}



