package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NoCommerceMyAccount extends BasePage{
	WebDriver driver;
	
	public NoCommerceMyAccount(WebDriver driver) {
		super(driver);
		}
		
		@FindBy(xpath="//a[@class='ico-account']")
		WebElement messageHeading;
		
		@FindBy(xpath="//a[@class='ico-logout']")
		WebElement lnklogout;
		
		public boolean isMyaccountExists() {
			try {
				return(messageHeading.isDisplayed());
			}
			catch(Exception e){
				return(false);
			}
		}
		public void clickLogout() {
			lnklogout.click();
		}
	
}
