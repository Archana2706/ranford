package com.pagelibrary.com.ranford;


import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;

import Excel.Excel_class;

public class TestExecution extends Repository  {

	@Test(priority=0)
	 public void verifylaunch()
	 {
		launch();
	 }
	@Test(priority=0)
	public void verifyLogin()
	{
		login();
	}

	@Test(priority=1)
	public void verifyAdmin() {
	
		Admin();
	}
	@Test(priority=2)
	public void verifyBranch() {
		Branches();
	}
	@Test(priority=3)
	public void verifyNewBranch() {
		
		Excel_class.ExcelConnection("Data.xls","Sheet1");
		Excel_class.outputexcelconnection("Data.xls", "outputdata.xls","Sheet1" );
		int c=Excel_class.getcolcount();
		
		for(int r=1;r<Excel_class.getcolcount();r++) {
			
			
			NewBranches(Excel_class.getdata(0, r),Excel_class.getdata(1, r),Excel_class.getdata(2, r),Excel_class.getdata(3, r),Excel_class.getdata(4, r),Excel_class.getdata(5, r),Excel_class.getdata(6, r));
			String text=driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			if(text.contains("created successfully")){
				Excel_class.Writedata(c++, r, text);
				c--;
			}
		
	
		else if(text.contains("already exist")) {
			Excel_class.Writedata(c++,r,text);
			c--;
		}
		else {
			Excel_class.Writedata(c++,r,"n/a");
			c--;
		}
		}
			Excel_class.saveworkbook();
	}
	@Test(priority=4)
	public void verifyRole() {
		Role();
	}
	@Test(priority=5)
		public void verifyNewRole() {
		RoleCreation();
	}
	@Test(priority=6)
	public void verifyEmployee() {
		Employee();
	}
	@Test(priority=7)
	public void verifyNewEmployee() {
		EmployeeCreation();
}

}
