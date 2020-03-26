package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.HomePage;
import pages.RegisterPage;
import tests.BaseTest;

public class UserRegistration extends BaseTest {
	HomePage homeObj;
	RegisterPage regtObt;
	
	@Given("^the user at home page$")
	public void the_user_at_home_page() throws Throwable {
		homeObj=new HomePage(driver);
		homeObj.OpenRegtPage();
	   
	}

	@When("^the user click on register link$")
	public void the_user_click_on_register_link()   {
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	 
	}

	@When("^enter the \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\"$")
	public void enter_the(String firstname,String lastname , String email, String password)  {
		regtObt = new RegisterPage(driver);
		regtObt.UserRegister(firstname, lastname, email, password);
	   
	}

	@Then("^the registration is displayed successfully$")
	public void the_registration_is_displayed_successfully()  {
		regtObt.Userlogout();
	
	}

}
