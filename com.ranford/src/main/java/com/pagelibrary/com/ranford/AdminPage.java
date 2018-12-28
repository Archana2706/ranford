package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class AdminPage extends Base {

	public static WebElement Branches_dropdown() {
		return driver.findElement(getElement("Branches"));
	}
	public static WebElement Roles_dropdown() {
		return driver.findElement(getElement("Roles"));
	}
	public static WebElement Users_dropdown() {
		return driver.findElement(getElement("Users"));
	}
	public static WebElement Employee_dropdown() {
		return driver.findElement(getElement("Employee"));
	}
	
}
