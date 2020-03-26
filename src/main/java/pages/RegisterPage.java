package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="FirstName")
	WebElement fnbox;
	
	@FindBy(id="LastName")
	WebElement lnbox;
	
	@FindBy(id="Email")
	WebElement emailbox;
	
	@FindBy(id="Password")
	WebElement passwordbox;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassbox;
	
	@FindBy(id="register-button")
	WebElement regtbox;
	
	@FindBy(css="div.result")
	public WebElement successMessage ; 
	
	@FindBy(linkText="Log out")
 public	WebElement logOutbtn;
	
	@FindBy(linkText="My account")
	WebElement myAccountbtn;
	
	public void UserRegister(String firstname, String lastname , String email, String password) 
	{
		sendkeys(fnbox, firstname);
		sendkeys(lnbox, lastname);
		sendkeys(emailbox, email);
		sendkeys(passwordbox, password);
		sendkeys(confirmPassbox, password);
clickbutton(regtbox);	
	}
	
	public void OpenMyAccountPAge() {
		clickbutton(myAccountbtn);
	}
	
	public void Userlogout() {
		clickbutton(logOutbtn);
	}
	
	
}
