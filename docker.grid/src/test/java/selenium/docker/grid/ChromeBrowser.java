package selenium.docker.grid;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeBrowser {

	public static WebDriver dr = null;

	@Test
	public static void LaunchChromeBrowser() {
		
		System.out.println("Chrome Browser");
		System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();

		dr.get("http://automationpractice.com/index.php");
		System.out.println("Title of the page is: " + dr.getTitle());
		dr.quit();
	}
}
