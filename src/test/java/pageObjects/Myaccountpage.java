package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage{
	
	public Myaccountpage(WebDriver driver)
	{
		super(driver);
		
	}
	

    @FindBy(xpath="//h2[normalize-space()='My Account']")     // my account heading
    WebElement msgheading;
    
    @FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
    WebElement lnklogout;
    
   
    public boolean isMyaccountExist()
    {
    	try
    	{
    		return(msgheading.isDisplayed());
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    
    public void clicklogout()
    {
    	lnklogout.click();    
    }
    
    
    
    
    
    
}
