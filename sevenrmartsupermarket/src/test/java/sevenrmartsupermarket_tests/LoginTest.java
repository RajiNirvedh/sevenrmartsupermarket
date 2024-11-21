package sevenrmartsupermarket_tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import sevenrmartsupermarket_constants.Data_Provider;
import sevenrmartsupermarket_base.Base;
import sevenrmartsupermarket_pages.HomePage;
import sevenrmartsupermarket_pages.LoginPage;
import sevenrmartsupermarket_utilities.ExcelReader;
import sevenrmartsupermarket_utilities.ScreenshotCapture;

public class LoginTest extends Base {
	
	ExcelReader excelreader=new ExcelReader();
	SoftAssert softassert=new SoftAssert();
	LoginPage loginpage;
	HomePage homepage;
	DataProvider data_provider;
	

	@Test
	public void verifyAdminUserLogin() {
		excelreader.setExcelFile("LoginPageData", "SignInData");
		String userNameData=excelreader.getCellData(0,1);
		String passwordData=excelreader.getCellData(1,1);
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login(userNameData,passwordData);
		String actualProfileName = homepage.getProfileName();
		Assert.assertEquals(actualProfileName, "Password");
	}
	
	@Test
	public void VerifySignInButtonIsEnabled()
	{
		loginpage = new LoginPage(driver);
		boolean actualResult=loginpage.isSignInButtonEnabled();
		Assert.assertEquals(actualResult, true);
	}
	
	@Test(dataProvider = "Login",dataProviderClass = Data_Provider.class)
	public void verifyAlertMessageOfInvalidUserLogin(String username,String password)
	{
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login(username, password);
		String actualAlertMessage=loginpage.getAlertMessageOnInvalidLoginAtempt();
		Assert.assertEquals(actualAlertMessage, "Alert!");
		
		
		
		
	}
	
	@Test
	public void verifyRememberMeCheckBoxIsEnabled()
	{
		loginpage = new LoginPage(driver);
		boolean actualResult=loginpage.isRememberMeCheckBoxIsEnabled();
		Assert.assertEquals(actualResult, true);
	}
	
	@Test
	public void verifyApplicationTitle()
	{
		loginpage = new LoginPage(driver);
		String actualText=loginpage.loginPageText();
		Assert.assertEquals(actualText, "7rmart supermarket");
	}

}
