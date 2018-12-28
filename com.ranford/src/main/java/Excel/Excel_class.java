package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import TestBase.Base;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;


public class Excel_class extends Base{

	
	public static String Excelpath= getconfig("Excelpath");
	static Workbook wb1;
	static Sheet sh1;
	static WritableWorkbook wwb;
	static WritableSheet wsh;
	
	
	public static void ExcelConnection(String filename,String sheetname) {
		try {
			File efile=new File(Excelpath+filename);
			wb1=Workbook.getWorkbook(efile);
			sh1=wb1.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static int getrowcount() {
		int Rows=sh1.getRows();
		return Rows;
	}
	
	public static int getcolcount() {
		int columns=sh1.getColumns();
		return columns;
	}
	
	public static String getdata(int row,int col) {
		String data=sh1.getCell(row, col).getContents();
		return data;
	}
	
	public static void outputexcelconnection(String ifilename,String ofilename,String sheetname) {
		try {
			FileInputStream fis=new FileInputStream(Excelpath+ifilename);
			wb1=Workbook.getWorkbook(fis);
			sh1=wb1.getSheet(sheetname);
			FileOutputStream fos=new FileOutputStream(Excelpath+ofilename);
			 wwb=Workbook.createWorkbook(fos,wb1);
			  wsh=wwb.getSheet(sheetname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
		public static void Writedata(int col,int row,String data) {
			try {
				Label l=new Label(col,row,data);
				wsh.addCell(l);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}

		public static void saveworkbook() {
			try {
				wwb.write();
				wwb.close();
				wb1.close();
			} catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
}
 