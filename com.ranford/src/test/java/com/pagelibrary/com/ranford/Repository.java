package com.pagelibrary.com.ranford;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.Base;
import utility.Library;
import utility.validation;

public class Repository extends Base{

	public ExtentReports report;
	public ExtentTest extent;
	
	@BeforeTest
	
	@Parameters("browser")
	@BeforeClass
	public void selectBrowser(String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
			else if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty(getconfig("Chromedrivername"),getconfig("Chromedriverpath"));
				driver=new ChromeDriver();
			}
		driver.get(getconfig("Build1"));
		driver.manage().window().maximize();
		}
			
	
	public void ExtentReport() {
		report=new ExtentReports(".//ExtentReport//report.html",true);
	}
	@BeforeMethod
	public void beforemethod(Method method) {
		extent=report.startTest((this.getClass().getSimpleName()+"::"+method.getName()));
		extent.assignAuthor("Archana");
		extent.assignCategory("Regression");

	}
	@AfterTest
	public void saveReport() {
		report.flush();
	}
	
	
	
	public void launch() {

		driver= new FirefoxDriver();
		driver.get(getconfig("Build1"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(validation.isTextPresent(getconfig("exptext"))) {
			
			extent.log(LogStatus.PASS,"my exp"+getconfig("exptext")+"my actual"+driver.findElement(By.tagName("tbody")).getText());
			
		}
		else {
			Library.takescreenshot("launchMethod");
		}

	
		String acturl=driver.getCurrentUrl();
		String expurl=getconfig("Build1");
		if(acturl.contains(expurl))
		{
			extent.log(LogStatus.PASS,"my exp"+expurl+"is matching with actual url"+acturl);
			extent.log(LogStatus.INFO,"Webpage is launced successfully");
		}
		else
		{
			extent.log(LogStatus.FAIL,"my exp"+expurl+"is not matching with actual url"+acturl);
		extent.log(LogStatus.INFO,"Webpage is not navigated");
	    }
	
	}
	public void login() {
		
		Loginpage.username_editbox().sendKeys(getconfig("Username"));
		Loginpage.Password_editbox().sendKeys(getconfig("Password"));
		Loginpage.LoginBTN_editbox().click();
		
		String Atitle=driver.getTitle();
		String ETitle=getconfig("Title1");
		if(Atitle.contains(ETitle))
		{
			extent.log(LogStatus.PASS,"my exp"+ETitle+"is matching with actual title"+Atitle);
			extent.log(LogStatus.INFO,"Login is working fine");
		}
		else
		{
			extent.log(LogStatus.FAIL,"my exp"+ETitle+"is not matching with actual title"+Atitle);
		extent.log(LogStatus.INFO,"login got failed");
		}
	}
	
	
	public void Admin() {
		
		AdminPage.Branches_dropdown().click();
		
		boolean b=AdminPage.Branches_dropdown().isDisplayed();
		
		if(b=true) {
			extent.log(LogStatus.PASS,"elements are displayed as expected");
			extent.log(LogStatus.INFO,"Adminpage is working fine ");
		}
		if(b=false) {
			extent.log(LogStatus.FAIL,"elements are not displayed");
		extent.log(LogStatus.INFO,"Adminpage got failed ");
		}
		
	
	}
	
	public void Branches() {
		Generic.dd_handle(BranchesPage.Country_dropdown()).selectByVisibleText(getconfig("Country"));
		Generic.dd_handle(BranchesPage.State_dropdown()).selectByVisibleText(getconfig("State"));
		Generic.dd_handle(BranchesPage.City_dropdown()).selectByVisibleText(getconfig("City"));
		
}
	
		public void NewBranches(String BRANCHNAME,String ADDRESS,String AREA,String ZIPCODE,String COUNTRY,String STATE,String CITY)
		{
			NewBranch.Newbranch_Button().click();
			NewBranch.NBranchName_editbox().sendKeys(BRANCHNAME);
			NewBranch.NAddress1_editbox().sendKeys(ADDRESS);
			//NewBranch.NAddress2_editbox().sendKeys(getconfig("NB_Address2"));
			//NewBranch.NAddress3_editbox().sendKeys(ADDRESS);
			NewBranch.NArea_editbox().sendKeys(AREA);
			NewBranch.NZipcode_editbox().sendKeys(ZIPCODE);
			Generic.dd_handle(NewBranch.NCountry_editbox()).selectByVisibleText(COUNTRY);
			Generic.dd_handle(NewBranch.NState_editbox()).selectByVisibleText(STATE);
			Generic.dd_handle(NewBranch.NCity_editbox()).selectByVisibleText(CITY);
			NewBranch.Submit_button().click();
			
			String actualtext=driver.switchTo().alert().getText();
			System.out.println(actualtext);
			String ExpectedText=getconfig("Alert");
			if(actualtext.contains(ExpectedText)) {
				extent.log(LogStatus.PASS,"my actual text is:"+actualtext+"matching with expected text:"+ExpectedText);
				extent.log(LogStatus.INFO,"Alert is present");
			}
			else {
				extent.log(LogStatus.FAIL,"my actual text is:"+actualtext+"not matching with expected text:"+ExpectedText);
				extent.log(LogStatus.INFO,"Alert is not present");
			}
			
		//Generic.Alert_handle().accept(
			
			
			
		}
		public void Role() {
			AdminPage.Roles_dropdown().click();
			boolean C=AdminPage.Roles_dropdown().isDisplayed();
			
			if(C=true) {
				extent.log(LogStatus.PASS,"elements are displayed as expected");
				extent.log(LogStatus.INFO,"Adminpage is working fine ");
			}
			if(C=false) {
				extent.log(LogStatus.FAIL,"elements are not displayed");
			extent.log(LogStatus.INFO,"Adminpage got failed ");
			}
		}
		public void RoleCreation() {
			NewRole.Newrole_Button().click();
			NewRole.Rolename_textbox().sendKeys(getconfig("Role_Name"));
			NewRole.Roledesc_textbox().sendKeys(getconfig("Role_Desc"));
			Generic.dd_handle(NewRole.RoleType_dropdown()).selectByVisibleText(getconfig("RoleType"));
			NewRole.Submit_button().click();
			
			String acttext=driver.switchTo().alert().getText();
			System.out.println(acttext);
			String ExpText=getconfig("RoleAlert");
			if(acttext.contains(ExpText)) {
				extent.log(LogStatus.PASS,"my actual text is:"+acttext+"matching with expected text:"+ExpText);
				extent.log(LogStatus.INFO,"Alert is present");
			}
			else {
				extent.log(LogStatus.FAIL,"my actual text is:"+acttext+"not matching with expected text:"+ExpText);
				extent.log(LogStatus.INFO,"Alert is not present");
			}
			
		Generic.Alert_handle().accept();
		
		}
		public void Employee() {
			AdminPage.Employee_dropdown().click();
			boolean D=AdminPage.Employee_dropdown().isDisplayed();
			
			if(D=true) {
				extent.log(LogStatus.PASS,"elements are displayed as expected");
				extent.log(LogStatus.INFO,"Adminpage is working fine ");
			}
			if(D=false) {
				extent.log(LogStatus.FAIL,"elements are not displayed");
			extent.log(LogStatus.INFO,"Adminpage got failed ");
			}
		}
		public void EmployeeCreation() {
			NewEmployee.Newemployee_button().click();
			NewEmployee.Ename_textbox().sendKeys(getconfig("Employername"));
			NewEmployee.Loginpwd_textbox().sendKeys(getconfig("Loginpassword"));
			Generic.dd_handle(NewEmployee.ERole_dropdown()).selectByVisibleText(getconfig("E_Role"));
			Generic.dd_handle(NewEmployee.Branch_dropdown()).selectByVisibleText(getconfig("E_Branch"));
			NewEmployee.Esubmit_button().click();
			
			String ActAlert=driver.switchTo().alert().getText();
			System.out.println(ActAlert);
			String ExpecAlert=getconfig("EmpAlert");
			if(ActAlert.contains(ExpecAlert)) {
				extent.log(LogStatus.PASS,"my actual text is:"+ActAlert+"matching with expected text:"+ExpecAlert);
				extent.log(LogStatus.INFO,"Alert is present");
			}
			else {
				extent.log(LogStatus.FAIL,"my actual text is:"+ActAlert+"not matching with expected text:"+ExpecAlert);
				extent.log(LogStatus.INFO,"Alert is not present");
			}
			
		Generic.Alert_handle().accept();
			
			
			
		}
	}
	


