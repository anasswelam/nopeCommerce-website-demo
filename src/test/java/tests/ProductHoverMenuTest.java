package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends BaseTest{
	HomePage homeObj;
	
	@Test
	public void userselecthover() {
		homeObj = new HomePage(driver);
		homeObj.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
