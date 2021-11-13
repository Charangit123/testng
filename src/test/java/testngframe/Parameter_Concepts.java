package testngframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Parameter_Concepts {

	@Test
	@Parameters({"url","email","password"})
	public void parameter(String url,String email,String password) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//div//a[@rel='async']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		driver.findElement(By.name("firstname")).sendKeys(email);
		driver.findElement(By.id("password_step_input")).sendKeys(password);
		Thread.sleep(2000);
		driver.quit();
	}
}
