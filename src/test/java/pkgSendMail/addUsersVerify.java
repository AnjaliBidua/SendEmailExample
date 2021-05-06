package pkgSendMail;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class addUsersVerify {
	ChromeDriver driver;

	@Test
	public void Login() throws InterruptedException{
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(1000);
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String expUrl ="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String expTitle ="OrangeHRM";
		String actUrl = driver.getCurrentUrl();
		String actTitle = driver.getTitle();
		Assert.assertEquals(expUrl, actUrl);
		Assert.assertEquals(expTitle, actTitle);
		
	}
  @BeforeTest
	public void LaunchBrowser(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

  @AfterTest
	public void CloseBrowser(){
		driver.quit();
	}

}
