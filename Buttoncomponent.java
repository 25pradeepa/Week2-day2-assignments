package week2.classautomate;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttoncomponent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/button.xhtml");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Code for click button and get title
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		System.out.println("Title of new page is "+ driver.getTitle());
		
		if (driver.getTitle().equals("Dashboard"))
		{
			//code to navigate back to the main screen
			driver.navigate().back();
		}
		
		//code to find the button is disabled
		if (!driver.findElement(By.xpath("//button[@id='j_idt88:j_idt92']")).isEnabled())
		{
			System.out.println("Disabled Button is disabled");
		}
		
		//code to get the position of submit
		System.out.println("Position of submit button is in  "+driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).getLocation());
		
		//code to find the color of save button
		System.out.println("Color of the save button is "+ driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).getCssValue("color"));
		
		//code to find the height and width of submit button
		System.out.println("Height and width of the submit button is " + driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).getSize());
		
		//code to find the color after the mouse hover of button
		Actions actions = new Actions(driver);			
		WebElement ele1 = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']/span[@class='ui-button-text ui-c']"));
		System.out.println("Background color of button before mouse move "+ ele1.getCssValue("background-color"));
		actions.moveToElement(ele1);
		actions.build().perform();
		System.out.println("Background color of button after mouse move " + ele1.getCssValue("background-color"));
		
		//code to find the rounded buttons
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']")).click();
		driver.findElement(By.xpath("//img[@id='j_idt88:j_idt102:j_idt104']")).click();
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt102:imageBtn']")).click();
		WebElement element = driver.findElement(By.xpath("//h5[contains(text(), 'How many rounded')]"));
		List<WebElement> followingSiblings = element.findElements(By.xpath("following-sibling::*"));
		System.out.println("There are  "+ followingSiblings.size()+ " rounded buttons");
		driver.close();
		
	}

}
