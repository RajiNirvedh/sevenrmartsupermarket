package sevenrmartsupermarket_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import sevenrmartsupermarket_base.Base;
import sevenrmartsupermarket_pages.AdminUsersPage;
import sevenrmartsupermarket_pages.HomePage;
import sevenrmartsupermarket_pages.LoginPage;

public class AdminUsersTest extends Base {
	HomePage homepage;
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	
	@Test(groups="smoke")
	public void verifyAlertMessageForDeletingUserDetails()
	{
		loginpage = new LoginPage(driver);
		homepage=loginpage.login("admin","admin");
		adminuserspage=new AdminUsersPage(driver);
		homepage.getAdminUser();
		String actualAlert=adminuserspage.deletingUserData("Emma Sarah");
		Assert.assertEquals(actualAlert,"Do you want to delete this User?");
		
	}
	

}
