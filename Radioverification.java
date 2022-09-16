package week2.classautomate;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Radioverification {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']/preceding-sibling::div")).click();
		
		driver.findElement(By.xpath("//label[@for='j_idt87:city2:0']/preceding-sibling::div")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//label[@for='j_idt87:city2:0']/preceding-sibling::div")).click();
		Thread.sleep(500);
		
		
		System.out.println("Default selected element is "+ driver.findElement(By.xpath("//table[@id='j_idt87:console2']/tbody/tr/td/div/div/input[@checked='checked']/following::label")).getText());
		
		boolean choose = driver.findElement(By.xpath("//h5[text()='Select the age group (only if not selected)']/following::span")).isSelected();
		if(!choose)
		{
			driver.findElement(By.xpath("//h5[text()='Select the age group (only if not selected)']/following::span")).click();
		}
		driver.close();
	}

}
