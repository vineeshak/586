package workingWithJXL;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class flipkart {
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//maximize
		Driver.manage().window().maximize();
		//open apps
		Driver.get("https://www.flipkart.com/");
		//create web class object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//create action class object
		Actions Act=new Actions(Driver);	
	//verify the title
		String sT=Driver.getTitle();
		if(sT.equals("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More"))
		{
			System.out.println("Online Shopping Site for Mobiles, Fashion, Books, Electronics, Home Appliances and More is diplayed");
		
		}
	//create web element for electronics
		WebElement objELEC=Driver.findElement(By.className("_1QZ6fC"));
		Act.moveToElement(objELEC).perform();
	//webelement for mobile
		WebElement objMOB=Driver.findElement(By.linkText("Mobiles"));
		Act.moveToElement(objMOB).perform();
	//click on samsung	
		Driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[2]/a/span")).click();
	//click on view all
		WebElement objVIEW=Driver.findElement(By.xpath("html/body/div/div/div[1]/div/div/div[3]/div/div/div[1]/div[1]/div/div/a"));
		if(objVIEW.isDisplayed())
		{
			System.out.println("pass");
			objVIEW.click();
		}
		else{System.out.println("fail");}
	//click on price high to low
		Driver.findElement(By.xpath(".//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/section/ul/li[3]")).click();
		
	}

}
