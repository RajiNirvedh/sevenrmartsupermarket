package sevenrmartsupermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sevenrmartsupermarket_utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	PageUtility pageutility;
	

	@FindBy(xpath="//div[@class='col-sm-12']//a[2]")
	private WebElement adminUserSearchButton;
	@FindBy(xpath="//div[@class='col-sm-6 form-group']//input[@class='form-control']")
	private WebElement username;
	@FindBy(xpath="//div[@class='card-body']//button[@class='btn btn-block-sm btn-danger']")
	private WebElement searchButton;
	@FindBy(xpath="//table//tbody//tr//td[5]//a[3]")
	private WebElement deleteIcon;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String deletingUserData(String name)
	{
		adminUserSearchButton.click();
		username.click();
		username.sendKeys(name);
		searchButton.click();
		deleteIcon.click();
		PageUtility pageutility=new PageUtility(driver);
		String alert=driver.switchTo().alert().getText();
		pageutility.dismissJsAlert();
		return alert;
	}
	
}
