package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css=".change-password")
	WebElement changepassbtn;
	

	@FindBy(id="OldPassword")
	WebElement oldpassbox;
	

	@FindBy(id="NewPassword")
	WebElement NewPasswordbox;
	

	@FindBy(id="ConfirmNewPassword")
	WebElement ConfirmNewPasswordbox ;
	
	@FindBy(xpath="//input[contains(@class,'change-password-button')]")
	WebElement changepasswordbtn;
	
	@FindBy(css="div.result")
	public WebElement resultmessage;
	
	public void UserChangePasspage() {
		clickbutton(changepassbtn);
	}
	
	
	public void UserChangepass(String oldpass, String newpass) {
		sendkeys(oldpassbox, oldpass);
		sendkeys(NewPasswordbox, newpass);
		sendkeys(ConfirmNewPasswordbox, newpass);
clickbutton(changepasswordbtn);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
