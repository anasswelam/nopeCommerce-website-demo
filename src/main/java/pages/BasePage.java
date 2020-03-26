package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	WebDriver driver;
	JavascriptExecutor jse;
	public Select select;
	public Actions action;
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	public void clickbutton(WebElement button) {
		button.click();
		
	}
	
	public  void sendkeys(WebElement text, String value) {
		text.sendKeys(value);
	}
	
	public  void scroll() {
		jse.executeScript("scrollBy(0,2500)"); 
	}
	public void creartext(WebElement text) {
		text.clear();
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
		}
		return false;
	}
	
	public boolean isAlertpresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
		}
		return false;
	}
	  
	}

