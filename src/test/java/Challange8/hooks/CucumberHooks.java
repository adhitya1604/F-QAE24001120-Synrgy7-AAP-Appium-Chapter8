package Challange8.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CucumberHooks {
    protected static AndroidDriver driver;
    @BeforeAll
    public static void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "C:/Users/Adhitya Andriansyah/Downloads/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 .apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        AndroidDriver driver = new AndroidDriver(capabilities);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
