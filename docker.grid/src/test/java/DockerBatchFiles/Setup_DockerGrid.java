package DockerBatchFiles;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Setup_DockerGrid {
	
	@BeforeTest
	public void startgrid() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start start_dockergrid.bat");
		Thread.sleep(15000);
		Runtime.getRuntime().exec("cmd /c start Scaleup_Chrome_Firefox.bat");
		Thread.sleep(25000);
	}
	
//	@Test(priority=2)
//	public void Scaleupgrid() throws IOException, InterruptedException
//	{
//		Runtime.getRuntime().exec("cmd /c start Scaleup_Chrome_Firefox.bat");
//		Thread.sleep(25000);
//	}

//	@Test(priority=3)
//	public void stopgrid() throws IOException, InterruptedException
//	{
//		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
//		Thread.sleep(15000);
//
//	}
	
	@AfterTest
	public void CloseCommandPrompts() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("cmd /c start stop_dockergrid.bat");
		Thread.sleep(15000);
		Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
		Thread.sleep(5000);
	}
}
