package chromeProject;
import org.openqa.selenium.chrome.*;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait ;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

public class project {
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
	//create web element for PIM
	WebElement objPIM=Driver.findElement(By.id("pim"));
	//mouse over on PIM
	Act.moveToElement(objPIM).perform();
	//click on add emp
	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Add Employee"))).click();
	//verify the frame i.e pim:add emp page
	//wait for frame and switch to it
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("rightMenu"));
	//verify pim:add emp
	if(Driver.findElement(By.xpath(".//*[@id='frmEmp']/div/div[1]/div[2]/div[1]/h2")).getText().equals("PIM : Add Employee"))
	{
		System.out.println("pim add emp is displayed");
	}
	//get emp id
	String sEmpId=Driver.findElement(By.id("txtEmployeeId")).getAttribute("value");
	//store first name and last name
	String FN="ishaan";
	String LN="mishra";
	//create webelement for save
	WebElement objSave=Driver.findElement(By.id("btnEdit"));
	//verify save
	if(objSave.isDisplayed())
	{
		System.out.println("save bitton is displayed");
	}
	//click on save button
	objSave.click();
	//wait for alert
	Alert AA=wait.until(ExpectedConditions.alertIsPresent());
	//verify the alert msg
	if(AA.getText().equals("Last Name Empty!"))
	{
		System.out.println("Last Name Empty! alert is present");
		AA.accept();
	}
	
	//enter last name
	Driver.findElement(By.id("txtEmpLastName")).sendKeys(LN);
	//click on save
	objSave.click();
	//wait for text to be present
	Alert AA1=wait.until(ExpectedConditions.alertIsPresent());
	//verify the alert msg
	if(AA1.getText().equals("First Name Empty!"))
	{
		System.out.println("First Name Empty! alert is present");
	
	AA1.accept();
	}
	//enter first name
		Driver.findElement(By.name("txtEmpFirstName")).sendKeys(FN);
	//click on save
	objSave.click();
	//wait for personal details page is displayed
	boolean prsnldetlsRes=wait.until(ExpectedConditions.textToBePresentInElement(By.className("mainHeading"), "Personal Details"));
		if(prsnldetlsRes)
		{
			System.out.println(" personal details page is displayed");
		}
		//switch to top frame
		Driver.switchTo().parentFrame();
		//mouse on pim
		Act.moveToElement(objPIM).perform();
		//click on employee list
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Employee List"))).click();
		//wait for frame and switch to it
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
		//verify employee info
		if(Driver.findElement(By.xpath(".//*[@id='standardView']/div[1]/h2")).getText().equals("Employee Information"))
		{
			System.out.println("employee info is displayed");
		}
		//get row count
		
	int rc=Driver.findElements(By.xpath(".//*[@id='standardView']/table/tbody/tr")).size();
	//verify emp data is present in tablle and get the data
	for(int i=1;i<=rc;i++)
	{
		//get column 2nd data
		String EmpID=Driver.findElement(By.xpath(".//*[@id='standardView']/table/tbody/tr["+i+"]/td[2]")).getText();
		//get 3rd column data
		 String EmpName=Driver.findElement(By.xpath(".//*[@id='standardView']/table/tbody/tr["+i+"]/td[3]/a")).getText();
		//
		if(EmpID.equals(sEmpId) && EmpName.equals(FN+" "+LN))
		{
			System.out.println(EmpID+" ,"+EmpName+" displayed at :"+i);
			break;
		}
		Driver.findElement(By.linkText(EmpName));
	}
	//---------------------------TC3--------------------------------
			//click on the emp naame u wnt to edit
	 	/*
	 	//navigate to new frame
	 	//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("rightMenu")));
	Driver.findElement(By.linkText(EmpName));
			//create webelement for edit button
			WebElement  objEdit=Driver.findElement(By.name("EditMain"));
			//click on edit
			objEdit.click();
			//wait
			Thread.sleep(3000);
			//web element for code,first name,last name
			WebElement objCode=Driver.findElement(By.id("txtEmployeeId"));
			WebElement objNFN=Driver.findElement(By.id("txtEmpFirstName"));
			WebElement objNLN=Driver.findElement(By.id("txtEmpLastName"));
			//new employee id and name
			String sCode="0142";
			String sNFN="qaa";
			String sNLN="planet";
			//now perform edit
			objCode.clear();
			objCode.sendKeys(sCode);
			//wait
			Thread.sleep(3000);
			objNFN.clear();
			objNFN.sendKeys(sNFN);
			//wait
			Thread.sleep(3000);
			objNLN.clear();
			objNLN.sendKeys(sNLN);
			//wait
			Thread.sleep(3000);
			//element of save button
			WebElement sSavee=Driver.findElement(By.id("btnEditPers"));
			//click on save
			sSavee.click();*/
	//===========================================================================================
			//get to top frame
	Driver.switchTo().defaultContent();
	//wait
	Thread.sleep(3000);
	//click on logout
	objLOGOUT.click();
	//verify the home page
	if(wait.until(ExpectedConditions.titleIs("OrangeHRM - New Level of HR Management")))
	{
		System.out.println("logged out successfully");
	}
	else
	{
		System.out.println("log out failed");
	}
	
}

}
