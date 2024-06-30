package Challange8.Testing;

import Challange8.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFailedTesting {
    protected static AndroidDriver driver;

    @BeforeTest
    public static void setupDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "C:/Users/Adhitya Andriansyah/Downloads/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 .apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
    }
    @Test
    public void loginFailedTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("adhitya");
        loginPage.inputPassword("12345678");
        loginPage.clickLoginButton();

        Assert.assertEquals(loginPage.getTextError(), "Username and password do not match any user in this service.");
    }

    @AfterTest
    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
