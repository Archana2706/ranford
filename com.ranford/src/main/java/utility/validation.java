package utility;

import org.openqa.selenium.By;

import TestBase.Base;

public class validation extends Base{

	public static boolean isTextPresent(String expected) {
		boolean b=driver.findElement(By.tagName("tbody")).getText().contains(expected);
		return b;
	}
	public static boolean isTitlePresent(String expected) {
		boolean b=driver.getTitle().contains(expected);
		return b;
	}
	
}
