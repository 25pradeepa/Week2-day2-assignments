package week2.classautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@name='phoneAreaCode']")).sendKeys("310");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("322-5111");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(1000);
		String leadid = driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a")).getText();
		driver.findElement(By.xpath("//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first ']/div/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadid);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(500);
		if (driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText().equals("No records to display"))
		{
			System.out.println("Lead got deleted successfully");
		}
		else
		{
			System.out.println("Lead deletion unsuccessful.Check for errors");
		}
		driver.close();
		
	}

}
