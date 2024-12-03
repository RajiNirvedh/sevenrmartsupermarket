package sevenrmartsupermarket_tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import sevenrmartsupermarket_base.Base;
import sevenrmartsupermarket_constants.Data_Provider;
import sevenrmartsupermarket_pages.HomePage;
import sevenrmartsupermarket_pages.LoginPage;
import sevenrmartsupermarket_pages.SubcategoryPage;


public class SubcategoryTest extends Base{
	SubcategoryPage subcategorypage;
	LoginPage loginpage;
	HomePage homepage;
	DataProvider data_provider;
	
	@Test(retryAnalyzer =sevenrmartsupermarket_listeners.RetryAnalyzer.class)
	
	public void verifySubCategoryListUsingSearchButton()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "Apple141124031848");
		String actualSearchResult=subcategorypage.getSearchResult();
		Assert.assertEquals(actualSearchResult, " Apple141124031848");
	}
	
	@Test(groups ={"smoke","regression"})
	public void verifyInvalidSearchOnSubcategoryList()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.searchSubCategory("Electronics", "SamsungS20");
		String actualSearchResult=subcategorypage.getInvalidSearchResult();
		Assert.assertEquals(actualSearchResult, ".........RESULT NOT FOUND.......");
		
	}
	
	@Test(dataProvider="SubCategory",dataProviderClass=Data_Provider.class)
	public void verifyaddingNewSubcategory(String subcategory,String category)
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.addingNewSubcategorywithImage(subcategory,category);
		String actualAlertText=subcategorypage.subCategoryAlert();
		Assert.assertEquals(actualAlertText, "Alert!");
		
	}
	
	@Test(dataProvider="DeleteSubCategory",dataProviderClass=Data_Provider.class)
	public void verifysubCategorydeletion(String subcategory)
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		String actualAlert=subcategorypage.deletingExistingSubcategory(subcategory);
		Assert.assertEquals(actualAlert, "Alert!");
	}
	
	@Test(groups="sanity")
	public void verifyTheColorOfActiveSubCategoryListIcon()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		String actualIconColor=subcategorypage.getActiveStatusIconBackgroundcolor();
		Assert.assertEquals(actualIconColor, "rgba(40, 167, 69, 1)");
	}
	
	@Test
	public void verifysubCategoryUpdation()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		subcategorypage=homepage.clickSubCategory();
		subcategorypage.updateExistingSubcategory("Jana","Broccoli");
		String actualAlert=subcategorypage.subcategoryUpdateAlert();
		Assert.assertEquals(actualAlert, "Alert!");
	}
	
	
}
