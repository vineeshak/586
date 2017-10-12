package flipkart;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ex2
{
	public static void main(String[] args) throws InterruptedException, Exception
{
		 System.setProperty("webdriver.chrome.driver", "D:\\tet\\Selenium_Demp\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 WebDriverWait wait=new WebDriverWait(driver, 30);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.flipkart.com/");
		// driver.navigate().refresh();
		 wait.until(ExpectedConditions.titleIs("Online Shopping India | Buy Mobiles, Electronics, Appliances, Clothing and More Online at Flipkart.com"));
		 Thread.sleep(2000);
		 WebElement objele=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span"));
		 WebElement objappl=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[2]/a/span"));
		 WebElement objmen=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[3]/a/span"));
		 WebElement objwomen=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[4]/a/span"));
		 WebElement objbk=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[5]/a/span"));
		 WebElement objhf=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[6]/a/span"));
		 WebElement objbm=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[7]/a/span"));
		 WebElement objoz=driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[8]/a/span"));
		 if(objele.isDisplayed() && objappl.isDisplayed())
		 {
			 System.out.println("Electronics and Applications are displayed");
		 }
		 else
		 {
			 System.out.println("Electronics and Applications are not displayed");
		 }
		 if(objmen.isDisplayed() && objwomen.isDisplayed())
		 {
			 System.out.println("Men and Women are displayed");
		 }
		 else
		 {
			 System.out.println("Men and Women are not displayed");
		 }
		 if(objbk.isDisplayed() && objhf.isDisplayed())
		 {
			 System.out.println("Baby & Kids and Home & Furniture are displayed");
		 }
		 else
		 {
			 System.out.println(" Baby & Kids and Home & Furniture are not displayed");
		 }
		 if(objbm.isDisplayed() && objoz.isDisplayed())
		 {
			 System.out.println("Books & More and Home & OfferZone are displayed");
		 }
		 else
		 {
			 System.out.println(" Books & More and OfferZone are not displayed");
		 }
		 //Thread.sleep(1000);
		 Actions act = new Actions(driver);
		 act.moveToElement(objele).click().perform();
		 
		 // code edited here 
		 
		 
		 // Electronic  //*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span")));
		 WebElement eletronic =driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span"));
		//clicking on the Electronics link and clickinging the samsung link
		 act.moveToElement(eletronic).click().perform();;
		 Thread.sleep(2000);
		 WebElement samsungmenu =driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]"));
	     act.click(samsungmenu).perform();;

		Thread.sleep(1000); 
		 
		 //====================================================
		 //samsumg mobile prices and name 
		//========================================================
		Thread.sleep(2000);
		 
		 //taking the count of the number of mobiles present
		 
		List< WebElement> mbname = driver.findElements(By.xpath("//*[@id='container']/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/a/div[2]/div[1]/div[1]"));
		
		List<WebElement> mbprice = driver.findElements(By.xpath("//*[@id='container']/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div/a/div[2]/div[2]/div[1]/div/div[1]"));  
		System.out.println(mbname.size());
		
		//printing only the mobile names

		for(WebElement mn : mbname)
		{
      
		System.out.println(mn.getText());
		 
		}
		System.out.println("name are printed done");
		
		//printing the mobile names and prices
		
		for (int i = 0 ;i<mbname.size();i++)
		{
			System.out.println(mbname.get(i).getText() +"   "+mbprice.get(i).getText());
			
		}
		//========================================================================
		//Writing the data to the Excel sheet
		//========================================================================
		WritableWorkbook wwb=Workbook.createWorkbook(new File("D:\\vamsi1\\flipkart_excelsheet22.xls"));
		WritableSheet ws=wwb.createSheet("Flipkart", 0);
		Label l=new Label(0, 0, "Mobile Name");
		Label l1=new Label(1, 0, "Mobile price");
		ws.addCell(l);
		ws.addCell(l1);					
		for(int j=0;j<mbname.size();j++)
		
		{
			String mmn1= mbname.get(j).getText();
			String mmp1= mbprice.get(j).getText();
			
			Label r1=new Label(0, j, mmn1);
            Label r2=new Label(1, j, mmp1);
          
			ws.addCell(r1);
			ws.addCell(r2);			
		}
						
		wwb.write();
		wwb.close();
      }
	}
