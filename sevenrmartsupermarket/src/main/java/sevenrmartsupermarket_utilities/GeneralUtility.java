package sevenrmartsupermarket_utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String getAttribute(WebElement element, String attribute)// for passing attribute
	{
		return element.getAttribute(attribute);
	}

	public String getCssValue(WebElement element, String Css_property) {
		return element.getCssValue(Css_property);
	}

	public List<String> getTextOfElements(List<WebElement> elements) {
		List<String> data = new ArrayList<String>();
		for (WebElement element : elements) {
			data.add(element.getText());
		}
		return data;
	}
	
	public static String getRandomName()
	{
		Faker faker=new Faker();
		return faker.name().firstName();
		
	}
	public static String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}

}
