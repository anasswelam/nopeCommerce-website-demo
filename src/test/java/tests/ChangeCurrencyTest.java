package tests;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailPage;

public class ChangeCurrencyTest extends BaseTest {
	HomePage homeObj;
	ProductDetailPage productObj;
	
	
	@Test
	public void userChangeCurrency() {
		homeObj = new HomePage(driver);
		homeObj.ChangeCurency("Euro");
		homeObj.UserSearch("Apple MacBook Pro 13-inch");
		productObj = new ProductDetailPage(driver);
		Assert.assertTrue(productObj.productPricelbl.getText().contains("Ђ"));
		
	}

}
