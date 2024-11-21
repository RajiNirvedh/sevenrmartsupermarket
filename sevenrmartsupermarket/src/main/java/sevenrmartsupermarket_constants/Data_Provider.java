package sevenrmartsupermarket_constants;

import org.testng.annotations.DataProvider;

import sevenrmartsupermarket_utilities.ExcelReader;

public class Data_Provider {
	ExcelReader excelreader=new ExcelReader();
	@DataProvider(name = "Login")
	public Object[][] logindata() {
		excelreader.setExcelFile("LoginPageData","UserData");
		return excelreader.getMultidimentionalData(2, 2);
	}
	@DataProvider(name = "SubCategory")
	public Object[][] subcategoryaddingdata() {
		excelreader.setExcelFile("SubCategory","CategoryData");
		return excelreader.getMultidimentionalData(2, 2);
	}
}
