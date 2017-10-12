package workingWithJXL;
import java.io.File;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JXLEg3 {
public static void main(String[] args) throws Exception
{
	WritableWorkbook WWB3=Workbook.createWorkbook(new File("C:\\Users\\Lab\\Desktop\\1234.xls"));
	WritableSheet ws1=WWB3.createSheet("hrm", 0);
	WritableSheet ws2=WWB3.createSheet("res", 1);
	//---------------------------------------
	Label l=new Label(0, 0, "usrName");
	Label l1=new Label(1, 0, "password");
	Label l2=new Label(0, 1, "qaplanet1");
	Label l3=new Label(1, 1, "user1");
	ws1.addCell(l);
	ws1.addCell(l1);
	ws1.addCell(l2);
	ws1.addCell(l3);
	WWB3.write();
	WWB3.close();
}
}
