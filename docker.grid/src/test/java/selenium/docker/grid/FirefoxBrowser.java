package selenium.docker.grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxBrowser {
	
	public static WebDriver dr = null;
	
	@Test
	public static void LaunchFirefoxBrowser() {

		System.out.println("Firefox Browser");
		System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
		dr = new FirefoxDriver();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();

		dr.get("http://automationpractice.com/index.php");
		System.out.println("Title of the page is: " + dr.getTitle());
		dr.quit();
	}
}
