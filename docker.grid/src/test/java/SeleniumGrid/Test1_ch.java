package SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test1_ch {
	
	@Test
	public static void TestOne() throws MalformedURLException
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver dr=new RemoteWebDriver(url, dc);
		
		dr.get("http://automationpractice.com/index.php");
		System.out.println("Title of the page is: " + dr.getTitle());
		dr.quit();
	}
}