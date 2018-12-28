package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class EditPage extends Base {
	public static WebElement BranchID_editbox() {
		return driver.findElement(getElement("BranchID"));
	}
	
	public static WebElement BranchName_editbox() {
	
		return driver.findElement(getElement("BranchName"));
	}
	public static WebElement EAddress_editbox() {
		return driver.findElement(getElement("Address1"));
	}
	public static WebElement EZipcode_editbox() {
		return driver.findElement(getElement("Zipcode"));
	}
	public static WebElement ECountry1_editbox() {
		return driver.findElement(getElement("country"));
	}
	public static WebElement EState_editbox() {
		return driver.findElement(getElement("State"));
	}
	public static WebElement ECity_editbox() {
		return driver.findElement(getElement("city"));
	}
	public static WebElement Update_button() {
		return driver.findElement(getElement("Update"));
	}
}
