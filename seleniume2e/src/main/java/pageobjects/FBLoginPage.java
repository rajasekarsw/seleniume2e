package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;
import base.BaseClass;

public class FBLoginPage extends BaseClass{
	
	
	Action action =new Action();
	@FindBy(xpath="//input[@id='email']")
	private WebElement userName;
	
	
	@FindBy(name="pass")
	private WebElement passWord;
	
	@FindBy(xpath="//button[@name=\"login\"]")
	WebElement loginButton;
	public FBLoginPage() {
		
		PageFactory.initElements(getDriver(), this);
	
	}

	public void enterUserName(String username)
	{
		if(action.findElement(getDriver(), userName))
		userName.sendKeys(username);
	}
	
	
	
	
	public void enterPassword(String password)
	{
		if(action.findElement(getDriver(), passWord))
		passWord.sendKeys(password);
	}

	public void clickLogin()
	{
		if(action.findElement(getDriver(), loginButton))
		loginButton.click();
	}
}
