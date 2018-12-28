package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import TestBase.Base;

public class BranchesPage extends Base{

	public static WebElement Country_dropdown() {
		return driver.findElement(getElement("Country"));
		
	}
	public static WebElement State_dropdown() {
		return driver.findElement(getElement("State"));
		 
	}
	public static WebElement City_dropdown() {
		return driver.findElement(getElement("City"));
		
	}
	public static WebElement Search_button() {
		return driver.findElement(getElement("Search"));
	}
	public static WebElement Edit_Button() {
		return driver.findElement(getElement("Edit"));
	}
}
