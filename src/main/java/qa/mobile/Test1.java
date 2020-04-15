package qa.mobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test1 {
	
	AppiumDriver driver;
	
  @Test
  public void register() {
	 MobileElement register =  (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/register"));
	 register.click();
	 MobileElement firstName = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/name"));
	 MobileElement LastName = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/last_name"));
	 firstName.sendKeys("buni");
	 LastName.sendKeys("Amgai");
	 MobileElement click = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.CheckBox[1]"));
	 click.click();
	 MobileElement dob = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/dob"));
	 dob.click();
	 MobileElement dateClick = (MobileElement) driver.findElement(By.id("android:id/button1"));
	 dateClick.click();
	 MobileElement onoff = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/toggleOnOff"));
	 onoff.click();
	 MobileElement country = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/country"));
	 country.click();
	 MobileElement countryClick = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/country_list"));
	 countryClick.click();
	 MobileElement usa = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, \"US\")]"));
	 usa.click();
	 MobileElement email = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/email"));
	 email.sendKeys("gurkhalies@hotmail.com");
	 MobileElement mobile = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/mobile"));
	 mobile.sendKeys("7075574583");
	 MobileElement checkBox = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, \"Send useful Technical Content\")]"));
	 checkBox.click();
	 MobileElement female = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, \"Female\")]"));
	 female.click();
	 MobileElement submit = (MobileElement) driver.findElement(By.id("com.example.work.thetestingworld:id/submit"));
	 submit.click();
	 
	 MobileElement LandingPage = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, \"Thanks for submiting\")]"));
	 String actual = LandingPage.getAttribute("text");
	 System.out.println(actual);
	 String expected = "Thanks for submiting";
	 Assert.assertEquals(actual, expected);
	 
  }
  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("deviceName", "Pixel 3a XL");
	  desiredCapabilities.setCapability("udid", "96DAX0GYK7");
	  desiredCapabilities.setCapability("platformName", "Android");
	  desiredCapabilities.setCapability("platformVersion", "10");
	  desiredCapabilities.setCapability("appPackage", "com.example.work.thetestingworld");
	  desiredCapabilities.setCapability("appActivity", "com.example.work.thetestingworld.Splash");
	 // desiredCapabilities.setCapability("app", "C:\\Users\\bkoiral1\\Downloads\\TheTestingWorld.apk");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
	
		driver = new AndroidDriver(url, desiredCapabilities);
		String sessionId = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		System.out.println(sessionId+"Application started...");
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
