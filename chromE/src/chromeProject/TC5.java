package chromeProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC5 {
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
	//create webelement for admin
	WebElement objADMIN=Driver.findElement(By.id("admin"));
	//mouse over admin
	Act.moveToElement(objADMIN).perform();
	//wait for company info
	boolean blnCMPY=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Company Info"),"Company Info"));
	//verify company info
	if(blnCMPY)
	{
		System.out.println("company info is displayed");
	}
	//wait for JOB
		boolean blnJOB=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Job"),"Job"));
		//verify JOB
		if(blnJOB)
		{
			System.out.println("JOB is displayed");
		}
		//wait for qualification
				boolean blnQF=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Qualification"),"Qualification"));
				//verify Qualification
				if(blnQF)
				{
					System.out.println("Qualification is displayed");
				}
				//wait for Skills
				boolean blnSkills=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Skills"),"Skills"));
				//verify JOB
				if(blnSkills)
				{
					System.out.println("Skills is displayed");
				}
				//wait for Memberships
				boolean blnMemberships=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Memberships"),"Memberships"));
				//verify Memberships
				if(blnMemberships)
				{
					System.out.println("Memberships is displayed");
				}
				//wait for Nationality & Race
				boolean blnNR=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Nationality & Race"),"Nationality & Race"));
				//verify JOB
				if(blnNR)
				{
					System.out.println("Nationality & Race is displayed");
				}
		//create web element for company info
				WebElement objCMPY=Driver.findElement(By.linkText("Company Info"));
			//mouse over company info
				Act.moveToElement(objCMPY).perform();
		//wait for General
				boolean blnGNL=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("General"),"General"));
				//verify General
				if(blnGNL)
				{
					System.out.println("General is displayed");
				}
				//wait for location
				boolean blnLCTN=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Locations"),"Locations"));
				//verify location
				if(blnLCTN)
				{
					System.out.println("Locations is displayed");
				}
				//wait for Company Structure
				boolean blnCS=wait.until(ExpectedConditions.textToBePresentInElement(By.linkText("Company Structure"),"Company Structure"));
				//verify Company Structure
				if(blnCS)
				{
					System.out.println("Company Structure is displayed");
				}
		//click on add
				Driver.findElement(By.linkText("Locations")).click();
		//wait for frame and switch to it
				Driver.switchTo().frame("rightMenu");
		//verify company location page
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[1]/h2")).getText().equals("Company Info : Locations"))
				{
					System.out.println("Company Info : Locations is present");
				}
			//verify search by
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/label[1]")).getText().equals("Search By:"))
				{
					System.out.println("search by is present");
				}
				//verify search for
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/label[2]")).getText().equals("Search For:"))
				{
					System.out.println("search for is present");
				}
				//verify search
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/input[2]")).getText().equals("Search"))
				{
					System.out.println("search button is present");
				}
				//verify reset
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[2]/input[3]")).getText().equals("Reset"))
				{
					System.out.println("Reset button is present");
				}
				//verify add
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[3]/div[1]/input[1]")).getText().equals("Add"))
				{
					System.out.println("add button is present");
				}
				//click on add
				Driver.findElement(By.xpath("html/body/div/div[2]/form/div[3]/div[1]/input[1]")).click();
			Thread.sleep(2000);
			//verify company info location is present
			if(Driver.findElement(By.xpath("html/body/div/div[3]/div[2]/div/h2")).getText().equals("Company Info : Locations"))
			{
				System.out.println("Company Info : Locations is displayed");
			}
		//create webelement for save button
			WebElement objSAve=Driver.findElement(By.xpath(".//*[@id='editBtn']"));
		//click on save
			objSAve.click();
		//wait for alert
			Alert AA=wait.until(ExpectedConditions.alertIsPresent());
			/*
		//verify the alert msg
		if(AA.getText().equals(""))
		{
			System.out.println("");
		}*/AA.accept();
		Thread.sleep(2000);
	//create web elenemts for name
		WebElement objNAMe=Driver.findElement(By.id("txtLocDescription"));
		WebElement objAddr=Driver.findElement(By.id("txtAddress"));
		WebElement objZIP=Driver.findElement(By.id("txtZIP"));
		WebElement objCOUNTRY=Driver.findElement(By.id("cmbCountry"));
	//strings
		String sNAMe="jack";
		String scountry="india";
		String sAddr="hyderabad";
		String sZIP="500008";
	//enter the name
		objNAMe.sendKeys(sNAMe);
	//click on save
		objSAve.click();
	//wait for alert
		Alert AA1=wait.until(ExpectedConditions.alertIsPresent());
		AA1.accept();
		Thread.sleep(2000);
	//click on country
		objCOUNTRY.click();
		Thread.sleep(2000);
	//enter country
		objCOUNTRY.sendKeys(scountry);
		//click on save
				objSAve.click();
			//wait for alert
				Alert AA2=wait.until(ExpectedConditions.alertIsPresent());
				AA2.accept();
				
		//enter address
				objAddr.sendKeys(sAddr);	
				//click on save
				objSAve.click();
				
			//wait for alert
				Alert AA3=wait.until(ExpectedConditions.alertIsPresent());
				AA3.accept();
				Thread.sleep(2000);
			//enter zip
				objZIP.sendKeys(sZIP);
				//click on save
				objSAve.click();
				//verify company location page
				if(Driver.findElement(By.xpath("html/body/div/div[2]/form/div[1]/h2")).getText().equals("Company Info : Locations"))
				{
					System.out.println("Company Info : Locations is present");
				}	
			Driver.switchTo().defaultContent();
		
	}

}
