package sevenrmartsupermarket_pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sevenrmartsupermarket_constants.Constants;
import sevenrmartsupermarket_utilities.GeneralUtility;

public class LoginPage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	Properties properties = new Properties();
	
	@CacheLookup
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement passwordField;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath="//label[@for='remember']")
	private WebElement checkBox;
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	private WebElement loginPageText;
	@FindBy(xpath="//div//h5[contains(text(),'Alert!')]")
	private WebElement alerttext;
	@FindBy(xpath="//div//a[@class='d-block']")
	private WebElement signinperson;
	@FindBy(xpath="//p[@class='login-box-msg']")
	private WebElement loginBoxText;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void enterUserName(String userName)
	{
		userNameField.sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	
	public void clickSignInButton()
	{
		signInButton.click();
	}
	
	public HomePage login(String userName,String password)
	{
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
		return new HomePage(driver);
		
	}
	
	public String login()
	{
		String userName=properties.getProperty("username");
		String password=properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickSignInButton();
		return signinperson.getText();
	
	}
	public String getLoginPageTitle()
	{
			return driver.getTitle() ;
	}
	
	public String getAlertMessageOnInvalidLoginAtempt()
	{
		return alerttext.getText();
	}
	
	public boolean isRememberMeCheckBoxIsEnabled()
	{
		checkBox.click();
		return checkBox.isEnabled();
	}
	
	public String loginPageText()
	{
		return loginPageText.getText();
	}
	
	public String loginBoxText()
	{

		return loginBoxText.getText();
		
	}
	
	public boolean isSignInButtonEnabled()
	{
		return signInButton.isEnabled();
	}
	
	
}
