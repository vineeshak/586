package chromeProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC4 {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lab\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver Driver=new ChromeDriver();
		//maximize
		Driver.manage().window().maximize();
		//open apps
		Driver.get("http://classroom:90/qahrm/login.php");
		//create web class object
		WebDriverWait wait=new WebDriverWait(Driver, 60);
		//create action class object
		Actions Act=new Actions(Driver);

		////wait & verify home page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
		{
			System.out.println("home page is displayed");
		}
		else
		{
			System.out.println("failed to open home page");
		}
		//create web elements
		WebElement objUN=Driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input"));
		WebElement objPWD=Driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input"));
		WebElement objLOGIN=Driver.findElement(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input"));
		//verify and wait user name
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[2]/input"))) != null)
		{
			System.out.println("user name is displayed");
		
		}
		//verify and wait password
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td[2]/input"))) != null)
		{
			System.out.println("password is displayed");
		}
		//verify and wait login
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("html/body/form/table[1]/tbody/tr/td[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]/input"))) != null)
		{
			System.out.println("login displayed");
		}
		
		String sUN="qaplanet1";
		String sPWD="user1";
		
	//login qa hrm
		objUN.clear();
		objUN.sendKeys(sUN);
		objPWD.clear();
		objPWD.sendKeys(sPWD);
		objLOGIN.click();
		
		
		//verify and wait admin page
		if(wait.until(ExpectedConditions.titleIs("OrangeHRM")))
		{
			System.out.println("admin page displayed");
		}
		else
		{
			System.out.println("failed to login");
		return;
		}
		//get welcome text
		String A=Driver.findElement(By.xpath("html/body/div[3]/ul/li[1]")).getText();
	
	//verify welcome text
	boolean welcmRES=wait.until(ExpectedConditions.textToBePresentInElement(By.xpath(".//*[@id='option-menu']/li[1]"), "Welcome "+sUN));
	//verify welcome text
	if(welcmRES)
	{
		System.out.println("welcome text is displayed");
	}
	//way 2 to find only user name
	//get text
	String sWlcmtxt=Driver.findElement(By.xpath(".//*[@id='option-menu']/li[1]")).getText();
	String[] Arr=sWlcmtxt.split(" ");
	//verify it
	if(Arr[1].equals(sUN))
	{
		System.out.println("user name is displayed");
	}
	//create webelements for change pwd and logout
	WebElement objCP=Driver.findElement(By.xpath("html/body/div[3]/ul/li[2]/a"));
	WebElement objLOGOUT=Driver.findElement(By.xpath("html/body/div[3]/ul/li[3]/a"));
	//verify change pwd and logout
	if(objCP.isDisplayed() && objLOGOUT.isDisplayed())
	{
		System.out.println("change password and logout button is displayed");
	}
	//wait for the frame and switch to it
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
	//create webelement for delete button
	WebElement objDLT=Driver.findElement(By.xpath(".//*[@id='standardView']/div[3]/div[1]/input[2]"));
	//verify the delete button
	if(objDLT.isDisplayed())
	{
		System.out.println("delete is displayed");
	}
	//click on the desired checkbox
	Driver.findElement(By.xpath(".//*[@id='standardView']/table/tbody/tr[1]/td[1]/input")).click();
	Thread.sleep(3000);
	//click on delete button
	objDLT.click();
	Thread.sleep(3000);
	//verify if successfully delete is displayed or not
	if(Driver.findElement(By.className("messagebar")).getText().equals("Successfully Deleted"))
	{
		System.out.println("Successfully Deleted is displayed");
	}
	Driver.switchTo().defaultContent();
	//wait
	Thread.sleep(3000);
	//click on logout
	objLOGOUT.click();
	}
	
}
