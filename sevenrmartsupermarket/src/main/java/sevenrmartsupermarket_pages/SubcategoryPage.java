package sevenrmartsupermarket_pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sevenrmartsupermarket_constants.Constants;
import sevenrmartsupermarket_utilities.GeneralUtility;
import sevenrmartsupermarket_utilities.PageUtility;

public class SubcategoryPage {
	WebDriver driver;
	GeneralUtility generalutility=new GeneralUtility();
	@FindBy(xpath="//a[@onclick='click_button(2)']")
	WebElement serachicon;
	@FindBy(xpath="//select[@class='form-control selectpicker']")
	WebElement categorydropdown;
	@FindBy(xpath="//input[@placeholder='Sub Category']")
	WebElement subCategory;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;
	@FindBy(xpath="//span[@id='res']//center")
	WebElement invalidsearchResult;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@placeholder='Enter the Subcategory']")
	WebElement addSubcategory;
	@FindBy(xpath="//button[@type='submit']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement saveAlert;
	@FindBy(xpath="//span[contains(text(),'Active')]")
	WebElement activeIcon;
	////tbody//tr//td[1]
	@FindBy(xpath="//tbody//tr//td[1]")
	List<WebElement> categoryupdation;

	
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
	
	//public String updateExistingSubcategory(String subCategory)
	{
		generalutility.getTextOfElements(categoryupdation);
		////tbody//tr[2]//td[5]//a[1]
	
		//return
	}
	
	public String getActiveStatusIconBackgroundcolor()
	{
		return generalutility.getCssValue(activeIcon,"background-color");
	}
	
}
