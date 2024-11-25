package sevenrmartsupermarket_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sevenrmartsupermarket_utilities.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalutility;
	String productTitle;

	@FindBy(xpath = "//li//p[contains(text(),'Manage product')]")
	private WebElement manageProduct;
	@FindBy(xpath = "//table//tr//td[1]")
	private List<WebElement> productList;
	

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProductList(String title) {
		manageProduct.click();
		generalutility = new GeneralUtility();
		generalutility.getTextOfElements(productList);
		int count = generalutility.getTextOfElements(productList).size();
		for (int i = 0; i < count; i++) {
			i++;
			boolean condition = generalutility.getTextOfElements(productList).get(i).contains(title);
			if (condition == true) {
				 productTitle = productList.get(i).getText();
				 System.out.println(productTitle);
				List<WebElement> dataList = driver.findElements(By.xpath("//tbody//tr[" + i + "]//td"));
				int newCount = dataList.size();
				for (int x =0; x<newCount; x++) {
					x++;
					String data = dataList.get(x).getText();
					System.out.println(data);
				}

			}
		}
		 return productTitle;
	}

}
