package core.example.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

	
	public static WebDriver driver;
	DesiredCapabilities caps = null;

	@BeforeTest
	@Parameters({"platform", "browsername", "remoteurl"})
	public void OpenBrower(String platform, String browsername, String remoteurl) throws MalformedURLException, InterruptedException {

		if (browsername.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_server_jar\\chromedriver.exe");
		caps = DesiredCapabilities.chrome();
	    caps.setBrowserName("chrome");
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_server_jar\\geckodriver.exe");
			caps = DesiredCapabilities.firefox();
//			caps.setBrowserName("firefox");
//			caps.setVersion("67.0.3");
//			caps.setPlatform(Platform.LINUX);
//			caps.setCapability("marionette", false);
//			caps.setAcceptInsecureCerts(true);
		}
      //  caps.setPlatform(Platform.WIN10);

        driver = new RemoteWebDriver(new URL(remoteurl), caps);
        Thread.sleep(2000);
        driver.get("http://admin-stg.travelpass.com");
        Thread.sleep(2000);
	}
	
	@Test
	public void EnterEmailPassword() throws MalformedURLException, InterruptedException {
		driver.findElement(By.id("user_email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("user_email")).sendKeys("sandra.john@cuelogic.co.in");
		Thread.sleep(2000);
		driver.findElement(By.id("user_password")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("user_password")).sendKeys("Pass@1234");
		Thread.sleep(2000);

	}
	
	
	@Test
	public void clickLogin() {
		driver.findElement(By.xpath("//input[@type='submit']")).submit();
		
		
	}
	
}
