package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class nopCommerceLogin extends BasePage{
	
	WebDriver driver;
	
	public nopCommerceLogin(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="Email")
	WebElement loginId;
	
	@FindBy(id="Password")
	WebElement loginPass;
	
	@FindBy(xpath="//button[contains(text(), 'Log in')]")
	WebElement submitbtn;
	
	public void setLoginEmail(String email) {
		loginId.sendKeys(email);
		}
	public void setLoginPass(String pass) {
		loginPass.sendKeys(pass);
	}
	public void ClickLogin() {
		submitbtn.click(); 
	}
}
