package com.pagelibrary.com.ranford;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;

public class Generic extends Base {
     
	public static Select dd_handle(WebElement element) {
		Select s= new Select(element);
		return s;
	}
	
	public static Alert Alert_handle() {
		Alert alrt=driver.switchTo().alert();
		return alrt;
	}
	
	
}
