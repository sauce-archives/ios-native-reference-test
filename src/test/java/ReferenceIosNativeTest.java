import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

public class ReferenceIosNativeTest {

	@iOSFindBy(accessibility = "2")
	private MobileElement button2;

	@iOSFindBy(accessibility = "3")
	private MobileElement button3;

	@iOSFindBy(accessibility = "=")
	private MobileElement buttonEquals;

	@iOSFindBy(accessibility = "×")
	private MobileElement buttonMultiply;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	private MobileElement resultField;

	private AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("testobject_app_id", "1");
		capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY")); // API key through env variable
		capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE_ID")); // device id through env variable
		capabilities.setCapability("testobject_appium_version", "1.5.2");

		driver = new IOSDriver(new URL("https://app.testobject.com:443/api/appium/wd/hub"), capabilities);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Test
	public void calculationFirst() {
		button3.click();
		buttonMultiply.click();
		button3.click();
		buttonMultiply.click();
		button2.click();
		button3.click();
		buttonEquals.click();
		Assert.assertEquals("checking result is " + "69.0", "69.0", resultField.getText());
	}
	@Test
	public void calculationSecond() {
		button3.click();
		buttonMultiply.click();
		button3.click();
		buttonMultiply.click();
		button2.click();
		button3.click();
		buttonEquals.click();
		Assert.assertEquals("checking result is " + "69.0", "69.0", resultField.getText());
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
