package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name="FullName")
	WebElement namebox;
	
	@FindBy(id="Email")
	WebElement mailbox;

	@FindBy(id="Enquiry")
	WebElement enquirybox;

	@FindBy(name="send-email")
	WebElement submitbtn;
	
	 @FindBy(css = "div.result")
	    public WebElement successMessage;

public void Contactus(String name,String email, String enquiry ) {
	sendkeys(namebox, name);
	sendkeys(mailbox, email);
	sendkeys(enquirybox, enquiry);
	clickbutton(submitbtn);
}
}
