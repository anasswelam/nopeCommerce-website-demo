package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;
import pages.ProductReviewPage;

public class AddProductReviewTest extends BaseTest{
	HomePage homeObj;
	LoginPage login;
	ProductDetailPage productObj;
	ProductReviewPage reviewObj;
	String productName = "Apple MacBook Pro 13-inch"; 
	String email = "anasswelam@gmail.com";
	String password ="987654321";
	

	@Test
	public void useraddreview() {
		homeObj = new HomePage(driver);
		homeObj.OpenLoginPage();
		login = new LoginPage(driver);
		login.UserLogin(email, password);
		homeObj.searchproductusingautosuggest(productName);
		productObj= new ProductDetailPage(driver);
		Assert.assertEquals(productObj.successsearchname.getText(), productName);
		productObj.OpenAddreviewPage();
		reviewObj = new ProductReviewPage(driver);
		reviewObj.addreview("new", "the product is good");
		Assert.assertTrue(reviewObj.successmessage.getText().contains("Product review is successfully added"));
		login.userlogout();
		
	}

}
