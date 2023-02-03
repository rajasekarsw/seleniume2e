package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class FBLogoutPage extends BaseClass{

	Action action =new Action();
	public FBLogoutPage() {
		PageFactory.initElements(getDriver(), this);
	}
	

	@FindBy(xpath="//div[@aria-label='Account controls and settings']/span")
	private WebElement profileButton;
	
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logout;
	
	
	public String getTitle()
	{
		
		if(action.findElement(getDriver(), profileButton))
		return getDriver().getTitle();
		else
			return "";
	}
	
	public void clickProfile()
	{
		if(action.findElement(getDriver(), profileButton))
		profileButton.click();
	}
	
	public boolean clickLogout()
	{
		if(action.findElement(getDriver(), logout))
			{
			logout.click();
			return true;
			}
		else
		{
			return false;
		}
		
	
	}
}
