package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest{

	HomePage homeObj;
	ContactUsPage contactObj;
	String email= "anasswelam@gmail.com";
	String name ="anasswelam";
	String enquiry ="helooo";
	
	@Test
	public void getcontactus() {
		homeObj = new HomePage(driver);
		homeObj.OpenContactUs();
		contactObj = new ContactUsPage(driver);
		contactObj.Contactus(name, email, enquiry);
		Assert.assertEquals(contactObj.successMessage.getText(), "Your enquiry has been successfully sent to the store owner.");
		
	}
}
