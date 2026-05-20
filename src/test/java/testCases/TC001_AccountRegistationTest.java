package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistationTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_Account_Registation()
	{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistationPage regepage=new AccountRegistationPage(driver);
		regepage.setFirstName(randomString().toUpperCase());
		regepage.setLastName(randomString().toUpperCase());
		regepage.setEmail(randomString()+"@gmail.com");   // randomly generated the email
		regepage.setTelephone(randomNumber());
		
		String password=randomAlphaNumberic();
		
		regepage.setPassword(password);
		regepage.setConfirmpassword(password);
		
		regepage.checkprivacyBox();
		regepage.btncontinue();
		
		String confirmationmsg=regepage.getConfirmationMsg();
		
		
		Assert.assertEquals(confirmationmsg, "Your Account Has Been Created!");
		
	
	}
	
	
	
	
	
	
	

}
