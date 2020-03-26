package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;

public class SearchTest extends BaseTest {
	HomePage homeObj;
	ProductDetailPage prodObj;
String productname = "Apple MacBook Pro 13-inch";
	
	@Test
	public void UserSearch() {
		homeObj = new HomePage(driver);
		homeObj.UserSearch(productname);
		prodObj = new ProductDetailPage(driver);
		homeObj.OpenproductDetailPage(productname);
		Assert.assertEquals(prodObj.successsearchname.getText(), productname);
		
		
	}

}
