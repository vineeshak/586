package excel_jxl;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
//import jxl.write.Label;
public class ex1 {
	public static void main(String[] args)throws Exception
	{
		File f1=new File("D:\\book1.xls");
		//load workbook
		Workbook WB=Workbook.getWorkbook(f1);
		//Get specific sheet
		Sheet s1=WB.getSheet("QAP");
		int i=1;
		//To retrieve data
		String gBrow=s1.getCell(0,i).getContents();
		String gURL=s1.getCell(1,i).getContents();
		String gUN=s1.getCell(2,i).getContents();
		String gPWD=s1.getCell(3,i).getContents();
		String gEmail=s1.getCell(4,i).getContents();
		
		System.out.println(gBrow);
		System.out.println(gURL);
		System.out.println(gUN);
		System.out.println(gPWD);
		System.out.println(gEmail);

		

	}

}
