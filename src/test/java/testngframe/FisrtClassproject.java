package testngframe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FisrtClassproject {

	@Test
	public void Google() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
		driver.findElement(By.name("q")).sendKeys("Youtube", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.quit();
	}

	@Test
	public void Facebook() throws Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Youtube", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.quit();

	}
}
