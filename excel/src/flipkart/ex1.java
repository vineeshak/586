package flipkart;
import java.io.File;
import java.util.List;
//import java.util.concurrent.TimeUnit;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class ex1 {
	public static void main(String[] args)throws Exception
	{
            System.setProperty("webdriver.chrome.driver","D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
            ChromeDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            Thread.sleep(1000);
            driver.get("https://www.flipkart.com/");
            Thread.sleep(1000);
            Actions act=new Actions(driver);
            if(driver.getTitle().equals("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"))
            {
            	System.out.println("Home page is displayed");
            }
            else
            {
            	System.out.println("Home page is not displayed");
            }
          WebElement objappl=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[2]/a"));
          WebElement objmen=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[3]/a"));
          WebElement objwomen=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[4]/a/span"));
          if(objappl.isDisplayed())
          {
        	  System.out.println("appliances is displayed");
          }
          else
          {
        	  System.out.println("appliances is not displayed");

          }
          if(objmen.isDisplayed())
          {
        	  System.out.println("men  is displayed");
          }
          else
          {
        	  System.out.println("men is not displayed");

          }
          if(objwomen.isDisplayed())
          {
        	  System.out.println("women is displayed");
          }
          else
          { 
        	  System.out.println("women is not displayed");

          }
          //selecting samsung mobiles from list
         // Thread.sleep(1000);
          act.moveToElement(driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span"))).perform();
        //  Thread.sleep(2000);
          
          WebElement objsam=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a/span"));
          act.moveToElement(objsam).click().perform();
         if(driver.getTitle().equals("Samsung Mobiles | Buy Samsung Mobiles at Best Price in India | Flipkart.com"))
          {
        	  System.out.println("Samsung mobiles page is displayed");
          }
         else
         {
        	 System.out.println("samsung mobiles page is not displayed");
         }
          Thread.sleep(1000);
          //click on view all      
          act.moveToElement(driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div/div[3]/div/div/div[1]/div[1]/div/div/a"))).click().perform();
          //click on sort by
       /* act.moveToElement(driver.findElement(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/section/ul/li[2]"))).click().perform();
	     Thread.sleep(1000);
	    
         //printing names and prices on console
	    List<WebElement> mname=driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[1]/div[1]"));
	    List<WebElement> mprice=driver.findElements(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div/div/a/div[2]/div[2]/div/div/div"));
	    System.out.println("mname.size()");
	    
	    //printing mobile names
	    for(WebElement mn:mname)
	    {
	    	System.out.println(mn.getText());
	    }
	    System.out.println("names are printed");
  
       //printing both names and prices
	    for(int i=0;i<mname.size();i++)
	    {
	    	System.out.println(mname.get(i).getText()+"   "+mprice.get(i).getText());
	    }
	   // writing to file
	    WritableWorkbook wwb=Workbook.createWorkbook(new File("C:\\Users\\Lab\\Documents\\vvv.xls"));
	    WritableSheet ws= wwb.createSheet("Flipkart",0);
	    Label l=new Label(0,0,"Mobile name");
	    Label l1=new Label(0,1,"Mobile price");
	    
	    ws.addCell(l);
	    ws.addCell(l1);
	    for(int j=0;j<mname.size();j++)
	    {
	    	String exmn=mname.get(j).getText();
	    	String exmp=mprice.get(j).getText();
	    	
	    	Label r1=new Label(0,j,exmn);
	    	Label r2=new Label(1,j,exmp);
	    	
	    	ws.addCell(r1);
	    	ws.addCell(r2);
	    	
	    }
	   wwb.write();
	   wwb.close();*/
	
	}

}
