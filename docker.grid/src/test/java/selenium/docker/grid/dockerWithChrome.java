package selenium.docker.grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class dockerWithChrome {
	
	@Test
	public static void Docker_Chrome_Test() throws MalformedURLException
	{
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver dr=new RemoteWebDriver(url, dc);
		
		dr.get("http://automationpractice.com/index.php");
		System.out.println("Title of the page is: " + dr.getTitle());
		dr.quit();
	}
}
