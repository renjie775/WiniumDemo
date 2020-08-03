package testcase;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Testcaseone {
	
	@Test
	public void CheckCalculatorResults() throws MalformedURLException, InterruptedException {
		
		DesktopOptions option=new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"), option);
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("Open Navigation")).click();
		driver.findElement(By.name("Standard Calculator")).click();
		driver.findElement(By.name("Seven")).click();
		driver.findElement(By.id("num7Button")).click();
		driver.findElement(By.name("Minus")).click();
		driver.findElement(By.name("Seven")).click();
		driver.findElement(By.name("Equals")).click();
		Thread.sleep(2000);
		
		String results=driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		driver.findElement(By.name("Close Calculator")).click();
		assertEquals("Display is 70", results);
	}

	@Test
	public void CheckForCorrectWindowPASS() throws MalformedURLException, InterruptedException {
		
		DesktopOptions option=new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"), option);
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("Open Navigation")).click();
		driver.findElement(By.name("Standard Calculator")).click();
		driver.findElement(By.name("Open Navigation")).click();
		driver.findElement(By.name("Scientific Calculator")).click();
		
		Thread.sleep(2000);
		
		String results=driver.findElement(By.id("Header")).getAttribute("Name");
		driver.findElement(By.name("Close Calculator")).click();
		assertEquals("Scientific Calculator mode", results);
	}
	
	@Test
	public void CheckForCorrectWindowFAIL() throws MalformedURLException, InterruptedException {
		
		DesktopOptions option=new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"), option);
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("Open Navigation")).click();
		driver.findElement(By.name("Standard Calculator")).click();
		driver.findElement(By.name("Open Navigation")).click();
		driver.findElement(By.name("Scientific Calculator")).click();
		
		Thread.sleep(2000);
		
		String results=driver.findElement(By.id("Header")).getAttribute("Name");
		driver.findElement(By.name("Close Calculator")).click();
		assertEquals("Programmer Calculator mode", results);
	}
	
	@Test
	public void SaveNewTextFilePASS() throws MalformedURLException, InterruptedException {
		
		DesktopOptions option=new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\notepad.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(2000);
		
		driver.findElement(By.name("Text Editor")).sendKeys("This is a Test");
		Thread.sleep(1000);
		
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Save As...")).click();
		driver.findElement(By.name("Desktop")).click();
		driver.findElement(By.name("File name:")).sendKeys("DEMO");
		driver.findElement(By.name("Save")).click();
		driver.findElement(By.name("Close")).click();
	}
	
	@Test
	public void NoSuchOptionError() throws MalformedURLException, InterruptedException {
		
		DesktopOptions option=new DesktopOptions();
		
		option.setApplicationPath("C:\\Windows\\notepad.exe");
		
		WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(2000);
		
		driver.findElement(By.name("Text Editor")).sendKeys("This is a Test");
		Thread.sleep(1000);
		
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Save As...")).click();
		driver.findElement(By.name("Help")).click();
		driver.findElement(By.name("File name:")).sendKeys("EXISTING");
		driver.findElement(By.name("Save")).click();
		driver.findElement(By.name("Close")).click();
	}
	
}
