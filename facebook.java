package week2.classautomate;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//input first name
		driver.findElement(By.xpath("(//a[@role='button']) [2]")).click();
		WebElement FN = driver.findElement(By.xpath("//input[@name='firstname']"));
		driver.executeScript("arguments[0].click()", FN);
		FN.sendKeys("Test");
		
		//input second name
		WebElement LN = driver.findElement(By.xpath("//input[@name='lastname']"));
		driver.executeScript("arguments[0].click()", LN);
		LN.sendKeys("Leaf");
		
		//input email address
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]"));
		driver.executeScript("arguments[0].click()", email);
		email.sendKeys("pradeepa_muthukumar@yahoo.in");
		
		//input confirm email address
		WebElement CFemail = driver.findElement(By.xpath("//input[contains(@name,'reg_email_confirmation__')]"));
		driver.executeScript("arguments[0].click()", CFemail);
		CFemail.sendKeys("pradeepa_muthukumar@yahoo.in");
		
		//input password
		WebElement pwd = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		driver.executeScript("arguments[0].click()", pwd);
		pwd.sendKeys("1234TestLeaf$");
		
		//choose birth day
		WebElement day = driver.findElement(By.xpath("//select[@id='day']/option[1]"));
		driver.executeScript("arguments[0].click()", day);
		day.click();
		
		//choose birth month
		WebElement mon = driver.findElement(By.xpath("//select[@id='month']/option[2]"));
		driver.executeScript("arguments[0].click()", mon);
		mon.click();
		
		//choose birth year
		WebElement year = driver.findElement(By.xpath("//select[@id='year']/option[13]"));
		driver.executeScript("arguments[0].click()", year);
		year.click();
		
		//choose gender
		WebElement gen = driver.findElement(By.xpath("//label[text()='Female']"));
		driver.executeScript("arguments[0].click()", gen);
		gen.click();
		
		//click submit button
		WebElement sub = driver.findElement(By.xpath("//button[@name='websubmit']"));
		driver.executeScript("arguments[0].click()", sub);
		sub.click();
		
		if (driver.getCurrentUrl().equals("https://en-gb.facebook.com/"))
		{
			System.out.println("Success");
		}
		else
		{
			System.out.println("Failure");
		}
		driver.close();
	}

}
