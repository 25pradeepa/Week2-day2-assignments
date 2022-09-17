package week2.classautomate;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectcomponents {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//select[@class='ui-selectonemenu']/option[3]")).click();
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s ui-c'][1]")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:country_3']")).click();
		System.out.println("selected country is  "+ driver.findElement(By.xpath("//li[@id='j_idt87:country_3']")).getText());
		Thread.sleep(500);
		
				
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		WebElement city1= driver.findElement(By.xpath("//li[@id='j_idt87:city_1']"));
		String text1 = city1.getText();
		city1.click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-triangle-1-s ui-c'][1]")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:country_2']")).click();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		WebElement city2= driver.findElement(By.xpath("//li[@id='j_idt87:city_1']"));
		String text2 = city2.getText();
		city2.click();
		Thread.sleep(500);
		
		if (text1!=text2)
		{
			System.out.println("City are listed based on the country selection");
		}
		
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(500);		
		driver.findElement(By.xpath("//li[text()='Appium']")).click();
		Thread.sleep(500);
		
		
		driver.findElement(By.xpath("//label[text()='Select Language']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:lang_3']")).click();
		Thread.sleep(500);
		
		
		
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:value_2']")).click();
		driver.close();
	}

}
