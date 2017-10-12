package workingWithJXL;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.*;

import jxl.Workbook;

import java.io.*;
public class poiEX {
	public static void main(String[] args) throws Exception
	{
		File f=new File("C:\\Users\\Lab\\Desktop\\123.xls");
		HSSFWorkbook wb=new HSSFWorkbook();
		//sheet 
		DataFormatter formatter = new DataFormatter();
		Sheet s=wb.getSheet("Sheet2");
		//---------------
		
		for(Row i : s)
		{
			for(Cell j : i)
			{
				CellReference cellRef = new CellReference(i.getRowNum(), j.getColumnIndex());
	            System.out.print(cellRef.formatAsString());
	            System.out.print(" - ");
			}
		}
	}

}
