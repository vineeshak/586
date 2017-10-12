package workingWithJXL;
import java.io.File;
import jxl.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class JXLEg4 {
public static void main(String[] args) throws Exception{
	 System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
     ChromeDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     Thread.sleep(1000);
     //open app
     driver.get("http://classroom:90/qahrm/login.php");
     //read data from sheet
     File f2=new File("C:\\Users\\Lab\\Desktop\\123.xls");
     Workbook WB=Workbook.getWorkbook(f2);
     Sheet s=WB.getSheet(1);
     
     //write data objects
     
}
}
