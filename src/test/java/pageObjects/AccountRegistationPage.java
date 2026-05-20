package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage{
	
	
	
	   public AccountRegistationPage(WebDriver driver)
	   {
		   super(driver);
	   }
	   
// locators
	   
	   
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLattname;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txttelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpwd;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtconfirmpwd;

@FindBy(xpath="//input[@name='agree']")
WebElement chkpolicy;

@FindBy(xpath="//input[@value='Continue']")
WebElement txtcontinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgconfirmation;


// action methods
	
	public void setFirstName(String fname)
	{
		txtFirstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLattname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String teleno)
	{
		txttelephone.sendKeys(teleno);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void setConfirmpassword(String pwd)
	{
		txtconfirmpwd.sendKeys(pwd);
	}
	
	public void checkprivacyBox()
	{
		chkpolicy.click();
	}
	
	public void btncontinue()
	{
		txtcontinue.click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgconfirmation.getText());
		} catch(Exception e)
		{
			return (e.getMessage());
		}
	}


}
