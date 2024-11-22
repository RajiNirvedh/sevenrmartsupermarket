package sevenrmartsupermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath="//img[@alt='AdminLTE Logo']")
	private WebElement logo;
	@FindBy(xpath="//a//img[@alt='User Image']")
	private WebElement adminlogo;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")
	private WebElement logoutbutton;
	@FindBy(xpath="(//p[contains(text(),'Sub Category')]//following::a[1])[2]")
	private WebElement subcategory;
	@FindBy(xpath="//a//i[@class='nav-icon fas fa-th-large']")
	private WebElement dashboard;
	

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfileName() {
		return profileName.getText();
	}
	
	public boolean isLogoDisplayed()
	{
		return logo.isDisplayed();
	}
	
	public SubcategoryPage clickSubCategory()
	{
	subcategory.click();
	return new SubcategoryPage(driver);
	}
	
	public DashBoardPage clickDashBoard()
	{
		dashboard.click();
		return new DashBoardPage(driver);
	}
	
	public void clickLogoutButton()
	{
		adminlogo.click();
		logoutbutton.click();
	}
}
