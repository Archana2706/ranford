package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class NewRole extends Base {

	public static WebElement Newrole_Button() {
		return driver.findElement(getElement("NewRole"));
	}
	public static WebElement Rolename_textbox() {
		return driver.findElement(getElement("RoleName"));
	}
	public static WebElement Roledesc_textbox() {
		return driver.findElement(getElement("RoleDesc"));
	}
	public static WebElement RoleType_dropdown() {
		return driver.findElement(getElement("RoleType1"));
	}
	public static WebElement Submit_button() {
		return driver.findElement(getElement("Rsubmit"));
	}
}
