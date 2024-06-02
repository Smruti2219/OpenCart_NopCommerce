package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.NoCommerceHome;
import pageObjects.NoCommerceMyAccount;
import pageObjects.nopCommerceLogin;
import testBase.nopCommerceBase;
import utilities.DataProviders;

public class TC_003_NoCommerce_Login_DataDriven_Test extends nopCommerceBase{
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String exp) {
		logger.info("***Staring TC_003_NoCommerce_Login_DataDriven_Test***");
		try {
		
		NoCommerceHome hp= new NoCommerceHome(nopCommerceBase.driver);
		hp.clickLoginlink();
		logger.info("clicked on login link...");
		
		nopCommerceLogin lp= new nopCommerceLogin(nopCommerceBase.driver);
		logger.info("Entering valid email and password...");
		lp.setLoginEmail(email);
		lp.setLoginPass(password);
		lp.ClickLogin();
		logger.info("Clicked login button...");
		
		NoCommerceMyAccount acc= new NoCommerceMyAccount(nopCommerceBase.driver);
		boolean target=acc.isMyaccountExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(target==true) {
				acc.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(target==true) {
				acc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******Finished Data Driven Testing******");
	}
}
