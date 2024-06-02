package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class tc_001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"regression", "master"})
	public void verify_account_registration()  
	{
		logger.info("********starting tc_001_AccountRegistrationTest********");
		logger.debug("application logs...");
		try {
		
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on My Account link");
		
		hp.ClickRegister();
		logger.info("Clicked on registration link");
		
		logger.info("*****Entering Customer Details*******");
		AccountRegistrationPage regpage= new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		//regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy(driver);
		regpage.clickContinue(driver);
		logger.info("Clicked on 'Continue'");
		
		String confmsg= regpage.getConfirmationMsg();
		logger.info("Validating confirmation message...");
		
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			logger.info("Test Passed...");
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed...");
			Assert.assertFalse(false);
		}
		}
		catch(Exception e) {
			logger.error("test failed...");
			logger.debug("debug logs");
			Assert.fail();
		}
		logger.info("********Finished tc_001_AccountRegistrationTest***********");
		
		}
	
}
