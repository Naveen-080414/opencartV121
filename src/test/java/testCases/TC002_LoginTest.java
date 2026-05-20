package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		
		try
		{
		// HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickloginlink();
		
		
		// LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));      // we  will get the email and password from the config.properties file
		lp.setpassword("password");
		lp.clicklogin();
		
		
		// MyaccountPage
		
		Myaccountpage maac=new Myaccountpage(driver);
		boolean targetpage=maac.isMyaccountExist();
		
		Assert.assertEquals(targetpage, true);
		}
		catch(Exception e)
		{
			//Assert.fail();
		}
		
	}
	
	
	

}
