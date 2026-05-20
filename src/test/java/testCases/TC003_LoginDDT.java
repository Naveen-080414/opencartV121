package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Myaccountpage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="DataDriven")   // getting data provider from different class
	public void verify_loginDDT(String email, String pwd, String expectedResult)
	{
		
		try {
		// HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickloginlink();
				
				
		// LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);      // we  will get the email and password from the config.properties file
		lp.setpassword(pwd);
		lp.clicklogin();
				
				
		// MyaccountPage
				
		Myaccountpage maac=new Myaccountpage(driver);
		boolean targetpage=maac.isMyaccountExist();
		
		
		// Validation 
		/* Data is Valid  - login success - test pass - logout
		                  -  login failed - test fail
		 
		 * Data is invalid - login success - test fail - logout
		                   - login fail  - test pass 
		 */
		
		if(expectedResult.equalsIgnoreCase("valid"))
		{
			if(targetpage==true)
			{
				maac.clicklogout();               // after assertion no statements will execute.
				Assert.assertTrue(true);
		
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(expectedResult.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				maac.clicklogout();                // after assertion no statements will execute.
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}

}
