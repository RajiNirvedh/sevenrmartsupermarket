package sevenrmartsupermarket_tests;

import org.testng.annotations.Test;

import sevenrmartsupermarket_base.Base;
import sevenrmartsupermarket_pages.DashBoardPage;
import sevenrmartsupermarket_pages.HomePage;
import sevenrmartsupermarket_pages.LoginPage;

public class DashBoardTest extends Base{
	LoginPage loginpage;
	HomePage homepage;
	DashBoardPage dashboardpage;
	
	@Test
	
	public void verifyTheDetailsOfaProduct()
	{
		loginpage=new LoginPage(driver);
		homepage=loginpage.login("admin", "admin");
		dashboardpage=homepage.clickDashBoard();
		//dashboardpage.getProductList("tomato");
		System.out.println(dashboardpage.getProductList("tomato"));
	}
	

}
