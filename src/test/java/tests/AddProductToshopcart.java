package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderDetailPage;
import pages.ProductDetailPage;
import pages.ShoppingPage;
import pages.WishlistPAge;

public class AddProductToshopcart extends BaseTest{
	HomePage homeObj;
	LoginPage login;
	String productName="Apple MacBook Pro 13-inch";
	ProductDetailPage productDetailsObj;
ShoppingPage shopObj;	
CheckoutPage checkObj;
OrderDetailPage orderObject;

	@Test
	public void useraddproducttoshop() throws InterruptedException {
		homeObj=new HomePage(driver);
		homeObj.OpenLoginPage();
		login = new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		login.UserLogin("anasswelam@gmail.com", "987654321");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homeObj.searchproductusingautosuggest("Apple MacBook Pro 13-inch");
		productDetailsObj = new ProductDetailPage(driver);
		productDetailsObj.Addtocart();
		driver.navigate().to("https://demo.nopcommerce.com/cart");
		shopObj = new ShoppingPage(driver);
	Assert.assertTrue(shopObj.totalLbl.getText().contains("3,600"));
	shopObj.openCheckoutPage();
	checkObj = new CheckoutPage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	checkObj.CheckoutProduct("Anas", "swelam", "Egypt", "anasswelam@gmail.com", "sss", "123456", "0000000", "ds", productName);
	Assert.assertTrue(checkObj.prodcutName.isDisplayed());
	Assert.assertTrue(checkObj.prodcutName.getText().contains(productName));
	checkObj.confirmOrder();
	orderObject = new OrderDetailPage(driver);
	checkObj.viewOrderDetails();
	Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
	orderObject.DownloadPDFInvoice();
	
	}
	

}
