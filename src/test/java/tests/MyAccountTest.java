package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends BaseTest{
	HomePage homeObj;
	LoginPage loginObj;
	MyAccountPage MyAccountObj;
	String oldpass ="123456789";
	String newpass="1441993";
	String email ="anasswelam@gmail.com";
	String password="123456789";
	
	@Test
	public void getMyAccount() {
		homeObj = new HomePage(driver);
		homeObj.OpenLoginPage();
		loginObj = new LoginPage(driver);
		loginObj.UserLogin(email, password);
		loginObj.openmyaccountPage();
		MyAccountObj = new MyAccountPage(driver);
		MyAccountObj.UserChangePasspage();
		MyAccountObj.UserChangepass(oldpass, newpass);
		Assert.assertEquals(MyAccountObj.resultmessage.getText(), "Password was changed");
	}

}
