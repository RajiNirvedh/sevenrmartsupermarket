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
		homepage = new HomePage(driver);
		loginpage = new LoginPage(driver);
		loginpage.login();
		boolean actualResult=homepage.isLogoDisplayed();
		Assert.assertEquals(actualResult, true);
		
	}
	

}
