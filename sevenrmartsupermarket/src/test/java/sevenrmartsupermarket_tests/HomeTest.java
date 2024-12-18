package sevenrmartsupermarket_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sevenrmartsupermarket_base.Base;
import sevenrmartsupermarket_pages.HomePage;
import sevenrmartsupermarket_pages.LoginPage;

public class HomeTest extends Base{
	HomePage homepage;
	LoginPage loginpage;
	
	@Test(groups="smoke")
	
	public void verifyWhetherLogoIsDisplayed()
	{
		
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		boolean actualResult=homepage.isLogoDisplayed();
		Assert.assertEquals(actualResult, true);
	}
	
	@Test
	public void verifyWhetherUserAbleToSearchProductStatus()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		homepage.productSearchWithTitle("Carrot", "615");
		String actualStatus=homepage.getProductStatus();
		Assert.assertEquals(actualStatus, "Active");
	}
	@Test
	public void verifyUserIsSuccessfullyLoggedOutAndDirectedToLoginPage()
	{
		
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("admin1","admin");
		String actualLoginBoxText=homepage.getLogoutPageText();
		String expectedLoginBoxText=loginpage.loginBoxText();
		Assert.assertEquals(actualLoginBoxText,expectedLoginBoxText );
	}
	

}
