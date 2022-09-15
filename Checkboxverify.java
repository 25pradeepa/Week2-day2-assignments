package week2.classautomate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxverify {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89\']/div[2]")).click();
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt91']/div[2]")).click();
		
		driver.findElement(By.xpath("//label[text()='Java']/preceding-sibling::div")).click();
		System.out.println("Favorite Language is  "+ driver.findElement(By.xpath("//label[@for='j_idt87:basic:0']")).getText());
		
		for(int i=0;i<=2;i++)
		{
			driver.findElement(By.xpath("//div[@id='j_idt87:ajaxTriState']")).click();
			driver.findElement(By.xpath("//div[@id='j_idt87:msg_container']")).getText();
			System.out.println(driver.findElement(By.xpath("//div[@id='j_idt87:id_container']")).getText());
			Thread.sleep(500);
			
		}
		
		for (int j=0;j<2;j++)
		{
			System.out.print("Toggle button is  ");
		driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
		Thread.sleep(500);
		System.out.println(driver.findElement(By.xpath("//span[@class='ui-growl-title']")).getText());
		
		}
		
		if (driver.findElement(By.xpath("//div[contains(@class,'ui-state-disabled ui-state-disabled')]")).isEnabled())
		{
			System.out.println("checkbox is disabled");
		}
		//select multiple cities
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s']")).click();
		driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list')]/li[1]/div")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list')]/li[3]/div")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//ul[contains(@class,'ui-selectcheckboxmenu-items ui-selectcheckboxmenu-list')]/li[5]/div")).click();
		Thread.sleep(500);
		System.out.println("Multiple items selected are ");
		System.out.println(driver.findElement(By.xpath("//ul[@data-label='Cities']")).getText());
		driver.close();
	}

}
