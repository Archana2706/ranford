package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class NewEmployee extends Base{
	public static WebElement Newemployee_button() {
		return driver.findElement(getElement("NewEmployee"));
	}
	public static WebElement Ename_textbox() {
		return driver.findElement(getElement("EmployerName"));
	}
	public static WebElement Loginpwd_textbox() {
		return driver.findElement(getElement("LoginPassword"));
	}
	public static WebElement ERole_dropdown() {
		return driver.findElement(getElement("Role"));
	}
	
	public static WebElement Branch_dropdown() {
		return driver.findElement(getElement("R_Branch"));
	}
	public static WebElement Esubmit_button() {
		return driver.findElement(getElement("E_Submit"));
	}


}
