package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoCommerceHome extends BasePage {
	
	WebDriver driver;
	
	public NoCommerceHome(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[@class='ico-login']")
	WebElement loginlink;
	
	public void clickLoginlink() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
		mywait.until(ExpectedConditions.elementToBeClickable(loginlink)).click();
	}

}
