package testngframe;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Orange_website {
	WebDriver driver;

	public void AppLanch() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void Login() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
	}

	@Test
	public void Navigatetomyinfo() {
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	}
	public void MyinfoVerify() {
		System.out.println(driver.findElement(By.id("employee-details")).isDisplayed());
		driver.quit();
	}

	@Test
	public void Welcome() {
		System.out.println(driver.findElement(By.id("welcome")).getText());
		driver.quit();
	}
}