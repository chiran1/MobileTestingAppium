package tests;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	AppiumDriver<MobileElement> d;
	URL url;
	@BeforeClass
	public void setup() {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability("deviceName", "Pixel 3a XL");
		ds.setCapability("udid", "96DAX0GYK7");
		ds.setCapability("platformName", "Android");
		
		ds.setCapability("platformVersion", "10");
		//ds.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		ds.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		
		
		try {
			url = new URL("http://0.0.0.0:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("casuse is: " + e.getMessage());
			System.out.println("cause is : "+ e.getCause());
		}
		

		d = new AppiumDriver<MobileElement>(url,ds);
		System.out.println("Application started...");
		
		
	}
	
	
	
	@AfterClass
	public void tearDown() {
		d.quit();
	}

}
