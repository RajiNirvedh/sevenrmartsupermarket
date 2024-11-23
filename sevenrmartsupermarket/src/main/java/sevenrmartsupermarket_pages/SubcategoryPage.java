package sevenrmartsupermarket_pages;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import sevenrmartsupermarket_utilities.GeneralUtility;
import sevenrmartsupermarket_utilities.PageUtility;

public class SubcategoryPage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	private WebElement serachicon;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	private WebElement categorydropdown;
	@FindBy(xpath="//input[@placeholder='Sub Category']")
	private WebElement subCategory;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	private WebElement searchButton;
	@FindBy(xpath="//span[@id='res']//center")
	private WebElement invalidsearchResult;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@placeholder='Enter the Subcategory']")
	private WebElement addSubcategory;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")
	private WebElement saveAlert;
	@FindBy(xpath="//span[contains(text(),'Active')]")
	private WebElement activeIcon;
	@FindBy(xpath="//tbody//tr//td[1]")
	private List<WebElement> categorylisttable;
	@FindBy(xpath="//button[contains(text(),'Update')]")
	private WebElement updateButton;
	@FindBy(xpath="//h5[contains(text(),' Alert!')]")
	private WebElement updateAlert;


	
	public SubcategoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);

	}
	
	public void clickOnSearchIcon()
	{
		serachicon.click();
	}
	
	public void searchSubCategory(String category,String subCategorydata)
	{
		clickOnSearchIcon();
		selectCategory(category);
		enterSubCategory(subCategorydata);
		PageUtility pageutility=new PageUtility(driver);
		pageutility.waitAndClick(searchButton);
	
	}
	public void selectCategory(String Category)
	{
		PageUtility pageutility=new PageUtility(driver);
		pageutility.select_ByVisibleTex(categorydropdown, Category);
		categorydropdown.sendKeys(Category);
	}
	
	public void enterSubCategory(String subCategorydata )
	{
		subCategory.click();
		subCategory.sendKeys(subCategorydata);
	}
	
	public String getSearchResult()
	{
		
		return generalutility.getAttribute(subCategory, "value");
		//return subCategory.getAttribute("value");
	}
	
	public String getInvalidSearchResult()
	{
		return invalidsearchResult.getText();
	}
	
	public void enterNewSubCategory(String subCategorydata)
	{
		addSubcategory.click();
		addSubcategory.sendKeys(subCategorydata);
	}
	
	public String addNewSubcategory(String category,String subCategorydata)
	{
		newButton.click();
		selectCategory(category);
		enterNewSubCategory(subCategorydata);
		saveButton.click();
		return saveAlert.getText();
	}
	
	public String updateExistingSubcategory(String subCategory,String newSubCategory)
	{
		generalutility.getTextOfElements(categorylisttable);
		int count=generalutility.getTextOfElements(categorylisttable).size();
		for(int i=0;i<count;i++)
		{
				boolean condition=generalutility.getTextOfElements(categorylisttable).get(i).contentEquals(subCategory);
				if(condition==true)
				{
					WebElement updatebutton=driver.findElement(By.xpath("//tbody//tr["+i+"]//td[5]//a[1]"));
					//pageutility.jsClick(updatebutton);
					updatebutton.click();
					addSubcategory.click();
					addSubcategory.clear();
					addSubcategory.sendKeys(newSubCategory);
					updateButton.click();
				}
				}
				return updateAlert.getText();
		}
		
	
	public String getActiveStatusIconBackgroundcolor()
	{
		return generalutility.getCssValue(activeIcon,"background-color");
	}
	
}
