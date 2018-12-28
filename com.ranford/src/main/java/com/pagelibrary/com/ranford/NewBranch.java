package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class NewBranch extends Base{
	public static WebElement Newbranch_Button() {
		return driver.findElement(getElement("NewBranch"));
	}
	public static WebElement NBranchName_editbox() {
		return driver.findElement(getElement("BranchName"));
	}
	public static WebElement NAddress1_editbox() {
		return driver.findElement(getElement("Address1"));
	}
	public static WebElement NAddress2_editbox() {
		return driver.findElement(getElement("Address2"));
	}
	public static WebElement NAddress3_editbox() {
		return driver.findElement(getElement("Address3"));
	}
	public static WebElement NArea_editbox() {
		return driver.findElement(getElement("Area"));
	}
	public static WebElement NZipcode_editbox() {
		return driver.findElement(getElement("Zipcode"));
	}
	public static WebElement NCountry_editbox() {
		return driver.findElement(getElement("Country1"));
	}
	public static WebElement NState_editbox() {
		return driver.findElement(getElement("State1"));
	}
	public static WebElement NCity_editbox() {
		return driver.findElement(getElement("City1"));
	}
	public static WebElement Submit_button() {
		return driver.findElement(getElement("Submit"));
	}
	
	
	
}
