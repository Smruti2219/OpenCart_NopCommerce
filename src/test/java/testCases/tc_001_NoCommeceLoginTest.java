package testCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NoCommerceHome;
import pageObjects.NoCommerceMyAccount;
import pageObjects.nopCommerceLogin;
import testBase.BaseClass;
import testBase.nopCommerceBase;

public class tc_001_NoCommeceLoginTest extends nopCommerceBase{
	WebDriver driver;
	
	@Test(groups= {"sanity", "master"})
	public void verify_login() {
		logger.info("*** Starting NoCommeceLoginTest ****");
		logger.debug("capturing application debug logs...");
		
		NoCommerceHome hp= new NoCommerceHome(nopCommerceBase.driver);
		hp.clickLoginlink();
		logger.info("clicked on login link...");
		
		nopCommerceLogin lp= new nopCommerceLogin(nopCommerceBase.driver);
		logger.info("Entering valid email and password...");
		lp.setLoginEmail(p.getProperty("email"));
		lp.setLoginPass(p.getProperty("password"));
		lp.ClickLogin();
		logger.info("Clicked login button...");
		
		NoCommerceMyAccount acc= new NoCommerceMyAccount(nopCommerceBase.driver);
		boolean target=acc.isMyaccountExists();
		if(target==true) {
			logger.info("Login test passed...");
			Assert.assertTrue(true);
		}
		else {
			logger.error("Login test Failed...");
			Assert.fail();
		}
		acc.clickLogout();
		logger.info("*** Finished NoCommeceLoginTest ***");
		}
		
		
	
}
