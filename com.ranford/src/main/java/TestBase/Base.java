package TestBase;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Base {
  public static Properties property;
	public static WebDriver driver;
	public static void loadproperty() {
	
	try {
		File path = new File(".\\src\\main\\java\\configuration\\or.properties");
		
		FileReader fr = new FileReader(path);
  property = new Properties();
		property.load(fr);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static By getElement(String key) {
		
		loadproperty();
	By loc=null;
		String value= property.getProperty(key);
		String loctype= value.split(":")[0];
		String locval= value.split(":")[1];
		
		switch(loctype){
		
			case"name":
			loc=By.name(locval);
			break;
			case"id":
			loc=By.id(locval);
			break;
			case"xpath":
			loc=By.xpath(locval);
			break;
			case"className":
			loc=By.className(locval);
			break;
			case"linkText":
			loc=By.linkText(locval);
			break;
			case"partialLinkTest":
			loc=By.partialLinkText(locval);
			break;
			case"cssSelector":
			loc=By.cssSelector(locval);
			case"tagName":
			loc=By.tagName(locval);
			break;
			
		}
		
	return loc;
	}
	
		public static void loadpropertyconfig() {
			
			try {
				File way = new File(".\\src\\main\\java\\configuration\\config.properties");
				
				FileReader frr = new FileReader(way);
		  property = new Properties();
				property.load(frr);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
public static String getconfig(String key){
	loadpropertyconfig();
	String k=property.getProperty(key);
	return k;
	
}
}
