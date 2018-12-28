package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class Loginpage extends Base
{

	public static WebElement username_editbox()
	{
		return driver.findElement(getElement("Username"));
	}
	
	public static WebElement Password_editbox()
	{
		return driver.findElement(getElement("Password"));
	}
	public static WebElement LoginBTN_editbox()
	{
		return driver.findElement(getElement("Login"));
	}
	
	
}
