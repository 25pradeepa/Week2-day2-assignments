package week2.classautomate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hyperlink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
			
		//code to click the goto dashboard link
		driver.findElement(By.xpath("//a[@class='ui-link ui-widget']")).click();
		driver.navigate().back();
		
		//code for find my destination
		System.out.println(driver.findElement(By.xpath("(//a[@class='ui-link ui-widget'])[2]")).getDomAttribute("href"));
		
		//code for amm ibroken link
		driver.findElement(By.xpath("//a[contains(text(),'Broken?')]")).click();
		if (driver.getTitle().contains("Error 404"))
		{
		System.out.println("Link is broken");
		driver.navigate().back();
		}
		
		//code for count of links in the page
		int str= driver.findElements(By.xpath("//div[@class='grid formgrid']")).size();
		System.out.println("Number of links in this page is  "+ str);
		
		//code to find the duplicate links
		for (int i=1;i<=str;i++)
				{
			for (int j=i+1;j<=str;j++)
			{
			if (driver.findElement(By.xpath("(//div[@class='grid formgrid'][1]/div/a)["+ i +"]")).getText().equals(driver.findElement(By.xpath("(//div[@class='grid formgrid'][1]/div/a)["+ j +"]")).getText()))
			{
				System.out.println("Link  - "+ driver.findElement(By.xpath("(//div[@class='grid formgrid'][1]/div/a)["+ i +"]")).getText() +"  - is duplicated");
			}
				}
				
							
		
		//code for count of links in the page layout
		driver.findElement(By.xpath("//a[@href='list.xhtml']")).click();
		System.out.println("Number of links in this page is  "+ driver.findElements(By.tagName("a")).size());
		driver.close();
		
	}
	}
}
