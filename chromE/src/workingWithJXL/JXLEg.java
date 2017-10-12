package workingWithJXL;
import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class JXLEg {
	public static void main(String[] args) throws Exception
	{
	//to tale file as input
	File f1=new File("C:\\Users\\Lab\\Desktop\\123.xls");
	//load workbook
	Workbook w=Workbook.getWorkbook(f1);
	//get specific sheet
	Sheet s=w.getSheet("QAP");
	int i=1;
	//get the data from cells
	String gBr=s.getCell(0, i).getContents();
	String gURL=s.getCell(1, i).getContents();
	String gUN=s.getCell(2, i).getContents();
	String gPWD=s.getCell(3, i).getContents();
	String gEMAIL=s.getCell(4, i).getContents();
	//print the contents
	System.out.println(gBr);
	System.out.println(gURL);
	System.out.println(gUN);
	System.out.println(gPWD);
	System.out.println(gEMAIL);
	}

}
