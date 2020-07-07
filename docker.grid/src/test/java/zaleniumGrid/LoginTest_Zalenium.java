package zaleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest_Zalenium {
	
	RemoteWebDriver  dr;
	DesiredCapabilities dc;

	@BeforeTest
	@Parameters("browser")
	public void Setup(String br) throws MalformedURLException
	{
		dc = new DesiredCapabilities();
		
		if(br.equals("chrome"))
		{
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		}
		else if(br.contentEquals("firefox"))
		{
			dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
		}	
			
		
		URL url=new URL("http://localhost:4444/wd/hub");
		dr = new RemoteWebDriver(url,dc);
		
		dr.get("http://demo.nopcommerce.com/");
		
	}
	
	@Test
	public void Login() throws InterruptedException
	{
		dr.findElement(By.xpath("//a[@class='ico-login']")).click();
		dr.findElement(By.id("Email")).sendKeys("rajakishore.selenium@gmail.com");
		dr.findElement(By.id("Password")).sendKeys("Test@12345");
		dr.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		Thread.sleep(5000);
		System.out.println("The title of the page is : " + dr.getTitle());
		Assert.assertEquals(dr.getTitle(), "nopCommerce demo store");
	}
	
	@AfterTest
	public void TearDown()
	{
		dr.quit();
	}

}
