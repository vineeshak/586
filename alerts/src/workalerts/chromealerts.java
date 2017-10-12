package workalerts;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class chromealerts {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//maximize
		Driver.manage().window().maximize();
		//explicit wait obj
		WebDriverWait wait=new WebDriverWait(Driver,60);
		//open app
		Driver.get("http://classroom:90/webapp/AgeProb.html");
		//wait and verify home page
		if(wait.until(ExpectedConditions.titleIs("Age Problem")))
		{
			System.out.println("age prblm is displayed");
		}
		//enter age
		Driver.findElement(By.id("idAge")).sendKeys("10");
		//click on submit
		Driver.findElement(By.id("idSubGo")).click();
		//wait
		Thread.sleep(10000);
		//wait for alert
		wait.until(ExpectedConditions.alertIsPresent());
		//switch to alert
		Alert A=Driver.switchTo().alert();
		//verify kid alert msg
		if(A.getText().equals("kid"))
		{
			System.out.println("kid alert is displayed");
		}
		//click ok on alert
		A.accept();
		Driver.close();
		
	}
	

}
