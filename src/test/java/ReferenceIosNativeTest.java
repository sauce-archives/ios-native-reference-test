import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testobject.integrations.LogentriesResultReporter;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ReferenceIosNativeTest {

	@ClassRule
	public static LogentriesResultReporter logentriesResultReporter = new LogentriesResultReporter();

	@iOSFindBy(accessibility = "2")
	private MobileElement button2;

	@iOSFindBy(accessibility = "3")
	private MobileElement button3;

	@iOSFindBy(accessibility = "=")
	private MobileElement buttonEquals;

	@iOSFindBy(accessibility = "×")
	private MobileElement buttonMultiply;

	@iOSFindBy(xpath="//XCUIElementTypeStaticText|//UIAApplication[1]/UIAWindow[1]/UIAStaticText[1]")
	private MobileElement resultField;

	private AppiumDriver driver;

	@Before
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("testobject_app_id", System.getenv("TESTOBJECT_APP_ID"));
		capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY")); // API key through env variable
		capabilities.setCapability("testobject_device", System.getenv("TESTOBJECT_DEVICE_ID")); // device id through env variable
		capabilities.setCapability("testobject_appium_version", System.getenv("TESTOBJECT_APPIUM_VERSION"));
		capabilities.setCapability("testobject_cache_device", System.getenv("TESTOBJECT_CACHE_DEVICE"));

		String automationName = System.getenv("AUTOMATION_NAME");
		if (automationName != null && automationName.length() != 0) {
			capabilities.setCapability("automationName", automationName);
		}

		driver = new IOSDriver(new URL(System.getenv("APPIUM_SERVER")), capabilities);

		System.out.println(driver.getCapabilities().getCapability("testobject_test_report_url"));
		System.out.println(driver.getCapabilities().getCapability("testobject_test_live_view_url"));
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
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
