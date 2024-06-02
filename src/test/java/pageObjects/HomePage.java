package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(), \"My Account\")]")
	WebElement linkMyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement linkRegister;
	
	public void ClickMyAccount() {
		linkMyaccount.click();	
		}
	public void ClickRegister() {
		linkRegister.click();
	}
}
