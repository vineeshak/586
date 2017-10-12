package workingWithJXL;
import java.io.File;
import jxl.*;
public class JXLEg2 {
public static void main(String[] args) throws Exception
{
	File f2=new File("C:\\Users\\Lab\\Desktop\\123.xls");
	//load work book
	Workbook WB1=Workbook.getWorkbook(f2);
	Sheet s1=WB1.getSheet("Sheet2");
	//get row count
	int Rows=s1.getRows();
	//apply for loop to print the content
	for(int i=0;i<Rows;i++)
	{
		String sUN=s1.getCell(0,i).getContents();
		String sPWD=s1.getCell(1,i).getContents();
		System.out.println(sUN+" "+sPWD);
		
	}
}
}
