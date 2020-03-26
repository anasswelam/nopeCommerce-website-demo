package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="Email")
	WebElement emailbox;
	
	@FindBy(id="Password")
	WebElement passbox;
	
	@FindBy(xpath="//input[contains(@class,'login-button')]")
	WebElement loginbtn;
	
	@FindBy(linkText="Log out")
	 public	WebElement logOutbtn;
	
	@FindBy(css="a.ico-account")
	public WebElement myaccountbtn;
	
	public void UserLogin(String email, String password) {
		sendkeys(emailbox, email);
		sendkeys(passbox, password);
		clickbutton(loginbtn);
	}
	
	public void openmyaccountPage() {
		clickbutton(myaccountbtn);
	}
	
	public void userlogout() {
		clickbutton(logOutbtn);
	}
	
	
	
}
