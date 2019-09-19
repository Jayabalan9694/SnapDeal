package org.cts;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDeal {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ELCOT\\jayabalan\\SnapDeal\\Driver\\chromedriver.exe" );
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.snapdeal.com/?utm_source=earth_brand_new&utm_campaign=brand_search&utm_medium=brand%20term,1t1&utm_content=homepage&utm_term=b,%2Bsnapdeal");
	    WebElement in = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
	in.sendKeys("redmi note 6 pro mobile");
	driver.findElement(By.xpath("//button[@class='searchformButton col-xs-4 rippleGrey']")).click();
	driver.findElement(By.xpath("//p[text()='Redmi Note 7 Pro ( 64GB , 4 GB ) Black']")).click();
	//driver.manage().window().maximize();
	Thread.sleep(2000);
	String pWin = driver.getWindowHandle();
	Set<String> allWin = driver.getWindowHandles();
	for (String x : allWin) {
		if(!pWin.equals(x)) {
			driver.switchTo().window(x);
		}
	}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='buy now']")).click();
	
	Thread.sleep(2000);
	/*WebElement dropd = driver.findElement(By.xpath("//span[text()='add to cart']"));
	JavascriptExecutor jk=(JavascriptExecutor)driver;
	jk.executeScript("window.scrollBy(0,500)");
	jk.executeScript("arguments[0].click()",driver.findElement(By.id("add-cart-button-id")));
	driver.quit();
	*/
	TakesScreenshot tk=(TakesScreenshot)driver;
	File screen = tk.getScreenshotAs(OutputType.FILE);
	File dest=new File("C:\\Users\\ELCOT\\Desktop\\jayabalan training\\guna\\snapdeal.png");
	FileUtils.copyFile(screen, dest);
	driver.quit();
	
	}


}
