package testngframe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider_Concepts {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//div//a[@rel='async']")).click();
	}

	@DataProvider
	public Iterator<Object[]> getData() {
		ArrayList<Object[]> testdata = Xls_Data.getDataExcel();
		return testdata.iterator();
	}

	@Test(dataProvider = "getData")
	public void FacebookData(String FirstName, String Surname, String Email, String NewPassword, String dobdate,
			String dobMonth, String dobyear, String Gender) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='firstname']")).clear();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);

		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(Surname);

//		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).clear();
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys(Email);

//		driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']")).clear();
		driver.findElement(By.xpath("//input[@aria-label='Re-enter email address']")).sendKeys(Email);

		//driver.findElement(By.xpath("//input[@id='password_step_input']")).clear();
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys(NewPassword);
		WebElement web= driver.findElement(By.xpath("//select[@title='Month']"));
		Select dobDate = new Select(web);
		List<WebElement> list= dobDate.getOptions();
		for (WebElement webElement : list) {
			System.out.println(webElement);
		}
		dobDate.selectByValue(dobdate);

		Select dobMonthe = new Select(driver.findElement(By.xpath("//select[@title='Month']")));
		dobMonthe.selectByValue(dobMonth);

		WebElement yearXpath = driver.findElement(By.xpath("//select[@title='Year']"));
		Select dobYear = new Select(yearXpath);
		dobYear.selectByValue(dobyear);
		if (Gender.equals("Female")) {
			driver.findElement(By.xpath("//label[text()='Female']")).click();
		} else
			driver.findElement(By.xpath("//label[text()='Male']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		Thread.sleep(3000);
//

//
//		driver.findElement(By.xpath("")).sendKeys("");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
