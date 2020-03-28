package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTestwithParalelTest extends BaseTest2{
	
	
	Faker fake = new Faker();
	String email = fake.internet().emailAddress();
	String password = fake.number().digits(8).toString();
	String firstname = fake.name().firstName();
	String lastname = fake.name().lastName();
	HomePage homeObj;
	RegisterPage regObj;
	LoginPage loginObj;
	
	@Test
	public void UserRegestSuccessfully() {
		homeObj= new HomePage(getdriver());
		homeObj.OpenRegtPage();
		regObj = new RegisterPage(getdriver());
		regObj.UserRegister(firstname, lastname, email, password);
		Assert.assertTrue(regObj.successMessage.getText().contains("Your registration completed"));
		regObj.Userlogout();
		homeObj.OpenLoginPage();
		loginObj = new LoginPage(getdriver());
		loginObj.UserLogin(email, password);
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	

}
