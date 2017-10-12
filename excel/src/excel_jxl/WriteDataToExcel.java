package excel_jxl;
import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
public class WriteDataToExcel {

	public static void main(String[] args)throws Exception
	
	{
       WritableWorkbook wb=Workbook.createWorkbook(new File("C:\\Users\\Lab\\Documents\\Login.xls"));
       WritableSheet Ws=wb.createSheet("HRM",0);
      // WritableSheet Ws1=wb.createSheet("RES",1);
       Label l=new Label(0,0,"username");
       Label l1=new Label(1,0,"password");
       Label r1=new Label(0,1,"qaplanet1");
       Label r2=new Label(1,1,"admin");
       Ws.addCell(l);
       Ws.addCell(l1);
       Ws.addCell(r1);
       Ws.addCell(r2);
       wb.write();      
       wb.close();
       
       
    		   
	}

}
