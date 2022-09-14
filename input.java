package week2.classautomate;

//import java.awt.Window;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class input {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/input.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("Pradeepa");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).sendKeys("Tamilnadu");
		if (driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']")).isEnabled())
		{
			System.out.println("Text box is enabled");
		}
		else
		{
			System.out.println("Text box is disabled");
		}
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).clear();
		if (driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).getText()=="")
		{
			System.out.println("Text got cleared from the Textbox");
		}
		else
		{
			System.out.println("Text didnot get cleared from the Textbox");
		}
		Thread.sleep(500);
		System.out.println("Retrieved Text fom Textbox is -  "+ driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).getAttribute("value"));
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("pradeepa@yahoo.in");
		driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys(Keys.TAB);
		String textarea1= driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']")).getAttribute("name");
		if (textarea1.contentEquals("j_idt88:j_idt101"))
		{
			System.out.println("My aspire to work smart");
			driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("texting in text editor");
			driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']")).sendKeys(Keys.ENTER);
			System.out.println("Error Message thrown is  "+ driver.findElement(By.xpath("//span[@class='ui-message-error-detail']")).getText());
			Point beforeclicks = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation();
			driver.findElement(By.xpath("//input[@id='j_idt106:float-input']")).click();
			Point afterclicks = driver.findElement(By.xpath("//label[@id='j_idt106:j_idt113']")).getLocation();
			if (beforeclicks != afterclicks)
			{
				System.out.println("USername Text position got changed");
			}
			else
			{
				System.out.println("USername Text position is not changed");
			}
			
			//Thread.sleep(100);
			//driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys("pradeepa");
			Thread.sleep(100);
			driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys(Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys("10/10/2000");
			driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys(Keys.TAB);	
			
			driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']")).sendKeys("11");
			driver.findElement(By.xpath("//span[@id='j_idt106:j_idt118']/a")).click();
			if (driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']")).getAttribute("aria-valuenow")=="12")
			{
				System.out.println("Spin up works as expected and value got incremented by 1");
			}
			Point beforeslide = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]")).getLocation();
			driver.findElement(By.xpath("//input[@id='j_idt106:slider']")).sendKeys("20");
			Point afterslide = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui-state-default')]")).getLocation();
		    if (beforeslide!= afterslide)
		    {
		    	System.out.println("Position of slide changed as per the input");
		    }
		    
		    driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).click();
		    if (driver.findElement(By.xpath("//div[contains(@class,'ui-widget ui-widget-content')]")).isEnabled())
		    {
		    	System.out.println("keyboard displayed");
		    	Thread.sleep(1000);
		    	driver.findElement(By.xpath("//button[contains(@class,'keypad-special keypad-close')]")).click();
		    	driver.findElement(By.xpath("//div[@class='ql-editor ql-blank' and @data-placeholder='Enter your content']")).sendKeys("control input verification");
		    }
		}
		
				
		driver.close();
	}

}
