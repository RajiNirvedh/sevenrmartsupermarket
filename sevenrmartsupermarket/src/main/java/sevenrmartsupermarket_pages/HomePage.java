package sevenrmartsupermarket_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sevenrmartsupermarket_utilities.GeneralUtility;
import sevenrmartsupermarket_utilities.PageUtility;

public class HomePage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	LoginPage loginpage;
	
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
	@FindBy(xpath="(//p[contains(text(),'Admin Users')]//following::a[1])[2]")
	private WebElement adminUser;
	@FindBy(xpath="//div[@class='col-lg-3 col-6'][8]//a[text()='More info ']")
	private WebElement manageProduct;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary'][text()=' Search']")
	private WebElement productSearchButton;
	@FindBy(xpath="//input[@placeholder='Title']")
	private WebElement titleInput;
	@FindBy(xpath="//input[@placeholder='Product Code']")
	private WebElement productCodeInput;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchButton;
	@FindBy(xpath = "//table//tr//td[7]")
	private WebElement productStatusdata;

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
	public void clickManageProduct()
	{
		manageProduct.click();
	
	}
	
	public void clickProductSearchButton()
	{
		productSearchButton.click();
	}
	
	public void productSearchWithTitle(String productTitle,CharSequence code)
	{
		clickManageProduct();
		clickProductSearchButton();
		titleInput.sendKeys(productTitle);
		productCodeInput.sendKeys(code);
		searchButton.click();
		
	}
	

	public String getProductStatus()
	{
		String productStatus=productStatusdata.getText();
		return productStatus;
	}
	
	public void clickLogoutButton()
	{
		adminlogo.click();
		logoutbutton.click();
	}
	
	public String getLogoutPageText()
	{
		adminlogo.click();
		
		PageUtility pageutility=new PageUtility(driver);
		pageutility.waitAndClick(logoutbutton);
		WebElement loginText=driver.findElement(By.xpath("//p[@class='login-box-msg']"));
		pageutility.waitAndClick(loginText);;
		return loginText.getText();
		
	}
	
	public void getAdminUser()
	{
		adminUser.click();
	}
	
}
