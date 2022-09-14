package week2.classautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		//driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoCSR");
		
		//driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		
		//driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		
		//driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
	
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		
		driver.findElement(By.xpath("(//input[contains(@class,' x-form-text x-form-field') and @name='firstName'])[3]")).sendKeys("karthik");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//td[@class='x-btn-center']/em/button[text()='Find Leads']")).click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]/a")).click();
		
		if (driver.getTitle().equals("View Lead | opentaps CRM"))
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@class='subMenuButton'][3]")).click();
			
			driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
			driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("HCL");
			driver.findElement(By.xpath("//input[@value='Update']")).click();
			Thread.sleep(5000);
			if (driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().contains("HCL"))
			{
				System.out.println("Company Name got updated");
			}
			else
			{
				System.out.println("Company name not updated");
			}
		}
		driver.close();
	}

}
