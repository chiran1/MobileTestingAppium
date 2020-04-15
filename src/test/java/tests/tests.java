package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class tests extends BaseClass {
	
	
	public void testOne() {
	d.get("https://google.com");
	d.findElement(By.name("q")).sendKeys("mobile automation");
	d.findElement(By.name("q")).sendKeys(Keys.ENTER);
	System.out.println("Completed test one...");
	}

}
