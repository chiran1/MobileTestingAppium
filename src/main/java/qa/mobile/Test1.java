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
	
  @Test(enabled=false)
  public void createAccount() {
	  
		 MobileElement Notifications = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/confirm_button"));
		 
		 MobileElement location = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button"));
		 
		 MobileElement signIn = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/tv_signin"));
		
		 MobileElement createAccount = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/btn_join_free"));
		 
		 MobileElement firstName = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/et_firstName"));
		 
		 MobileElement lastName = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/et_lastName"));
		 
		 MobileElement email = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/et_email"));
		
		 MobileElement password = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/edit_password"));
		 
		 MobileElement dob = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/et_dob"));
		 
		 MobileElement one = (MobileElement) driver.findElement(By.xpath("//android.view.View[@content-desc=\"01 April 2020\"]"));
		 
		 MobileElement ok = (MobileElement) driver.findElement(By.xpath("//*[contains(@text, \"OK\")]"));
		
		 MobileElement createAccountClick = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/btn_join_free"));
		 
		 
		 
		 Notifications.click();
		 location.click();
		 signIn.click();
		 createAccount.click();
		 firstName.sendKeys("ramey");
		 lastName.sendKeys("jpt");
		 email.sendKeys("harkey@hotmail.com");
		 password.sendKeys("Simple@123"); 
		 dob.click();
		 one.click();
		 ok.click();
		 createAccountClick.click();

			
  }
  
@Test(enabled=true)		 
public void invalidSignIn() {
		MobileElement Notifications = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/confirm_button"));
		
		MobileElement location = (MobileElement) driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_always_button"));
		
		MobileElement SignIn = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView\n" + 
				""));
		
		MobileElement email = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/edit_email"));
		
		MobileElement password = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/edit_password"));
		
		MobileElement btnSignIn = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/btn_sign_in"));
		
		String actual = driver.findElement(By.id("com.spirit.customerapp:id/tv_error_msg")).getText();
		String expected = "Sorry, this email address could not be found.";
		
		
		Notifications.click();
		location.click();
		SignIn.click();
		email.sendKeys("lurkey@hotmail.com");
		password.sendKeys("Simple@123");
		btnSignIn.click();
		Assert.assertEquals(actual, expected);
	
}

@Test(enabled=true)
public void validSignIn() {

	MobileElement email = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/edit_email"));
	
	MobileElement password = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/edit_password"));
	
	MobileElement btnSignIn = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/btn_sign_in"));
	
	MobileElement TouchIdAllow = (MobileElement) driver.findElement(By.id("com.spirit.customerapp:id/confirm_button"));
	
	 Boolean actual = driver.findElement(By.id("com.spirit.customerapp:id/iv_user_image")).isDisplayed();
	 Boolean expected = true;
	
	
	email.clear();
	email.sendKeys("gurkhalies@hotmail.com");
	password.sendKeys("Simple@123");
	btnSignIn.click();
	TouchIdAllow.click();
	Assert.assertEquals(actual,expected );
	
}

  @BeforeClass
  public void beforeClass() throws MalformedURLException {
	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	  desiredCapabilities.setCapability("deviceName", "Pixel 3a XL");
	  desiredCapabilities.setCapability("udid", "96DAX0GYK7");
	  desiredCapabilities.setCapability("platformName", "Android");
	  desiredCapabilities.setCapability("platformVersion", "10");
	  desiredCapabilities.setCapability("appPackage", "com.spirit.customerapp");
	  desiredCapabilities.setCapability("appActivity", "com.spirit.enterprise.guestmobileapp.UI.Main.SplashActivity");
	 // desiredCapabilities.setCapability("app", "C:\\Users\\bkoiral1\\Downloads\\TheTestingWorld.apk");
		
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
	
		driver = new AndroidDriver(url, desiredCapabilities);
		String sessionId = driver.getSessionId().toString();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		System.out.println(sessionId+"Application started...");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("application now closed...");
	 driver.quit();
  }

}
