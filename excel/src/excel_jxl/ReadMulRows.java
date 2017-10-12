package excel_jxl;
import java.io.File;
import jxl.*;

public class ReadMulRows
{

	public static void main(String[] args)throws Exception
	{
       File File=new File("C:\\Users\\Lab\\Documents\\mulrows.xls"); 
       Workbook objWb=Workbook.getWorkbook(File);
       //0 is the index of the sheet
       Sheet s1=objWb.getSheet(0);
       
       //Get row count
       int  rows=s1.getRows();
       for(int i=0;i<rows;i++)
       {
    	   String un=s1.getCell(0,i).getContents();
    	   String pwd=s1.getCell(1,i).getContents();
    	   System.out.println(un +" "+ pwd);
       }
       
	}
}
