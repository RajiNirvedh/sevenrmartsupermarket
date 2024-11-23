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
	public void verifyUserIsSuccessfullyLoggedOutAndDirectedToLoginPage()
	{
		
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		homepage.clickLogoutButton();
		String actualLoginBoxText=loginpage.loginBoxText();
		Assert.assertEquals(actualLoginBoxText, "Sign in to start your session");
	}
	

}
