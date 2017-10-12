package excel_jxl;
import java.io.File;
import jxl.Workbook;
import jxl.Sheet;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import jxl.Workbook;

public class Read_write_intoExcel 
{
	public static void main(String[] args)throws Exception
	{
		System.setProperty("webdriver.gecko.driver","D:\\tet\\Selenium_Demp\\geckodriver-v0.16.1-win32\\geckodriver.exe");
		//create obj for webdriver
		WebDriver Brow=new FirefoxDriver();
		Brow.manage().window().maximize();
        WebDriverWait wait=new WebDriverWait(Brow,20);		
        //open app
        Brow.get("http://classroom:90/qahrm/login.php");
        //Read data objects
        File fls=new File("C:\\Users\\Lab\\Documents\\RW.xls");
        Workbook objwb=Workbook.getWorkbook(fls);
        Sheet InputSheet=objwb.getSheet(0);
        //write dat objs
        WritableWorkbook wb=Workbook.createWorkbook(new File("C:\\Users\\Lab\\Documents\\res.xls"));
        WritableSheet OutputSheet=wb.createSheet("HRM",0);
        Label l=new Label(0,0,"username");
        Label l1=new Label(1,0,"password");
        Label l2=new Label(1,0,"result");
        OutputSheet.addCell(l);
        OutputSheet.addCell(l1);
        OutputSheet.addCell(l2);
        
        Label r1;
        Label r2;
        Label r3;
        //get row count
        int Rcount=InputSheet.getRows();
        System.out.println(Rcount);
        for(int i=1;i<Rcount;i++)
        	
        {
        	
        	System.out.println("Iterartion no:"+i);
        
       //obj for username
        WebElement objun=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtUserName")));
        objun.clear();
        objun.sendKeys(InputSheet.getCell(0,i).getContents());
        //obj for password
        WebElement objpwd=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtPassword")));
        objpwd.clear();
        objpwd.sendKeys(InputSheet.getCell(1,i).getContents());
        //click on login
        WebElement objLogin=wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Submit")));
        objLogin.click();
        Thread.sleep(2000);
        String res="passed";
        String res1="failed";
        //verify orange HRM
        if(Brow.getTitle().equals("OrangeHRM"))
        {
        	System.out.println("Login Successful");
        	r1=new Label(0,i,InputSheet.getCell(0,i).getContents());
        	r2=new Label(1,i,InputSheet.getCell(1,i).getContents());
        	r3=new Label(2,i,res);
        	  OutputSheet.addCell(r1);
              OutputSheet.addCell(r2);
              OutputSheet.addCell(r3);
              Brow.findElement(By.linkText("Logout")).click();
              Thread.sleep(2000);
        }
        else
        {
        	System.out.println("login failed");
        	r1=new Label(0,i,InputSheet.getCell(0,i).getContents());
        	r2=new Label(0,i,InputSheet.getCell(1,i).getContents());
        	r3=new Label(2,i,res);
        	OutputSheet.addCell(r1);
            OutputSheet.addCell(r2);
            OutputSheet.addCell(r3);
            Thread.sleep(2000);
            Brow.findElement(By.name("clear")).click();

          }
        }
        wb.write();
        wb.close();
        Brow.close();
        Brow.quit();
        	
        	
        }
        
	}


