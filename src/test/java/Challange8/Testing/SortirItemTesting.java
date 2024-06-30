package Challange8.Testing;

import Challange8.page.HomePage;
import Challange8.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SortirItemTesting {

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
    public void testSortItemsLowToHigh() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");

        homePage.sortItemsLowToHigh();

        List<WebElement> prices = homePage.getItemPrices();
        Assert.assertTrue(prices.size() > 1, "Kurang dari dua item ditemukan.");

        double firstPrice = homePage.getPriceFromText(prices.get(0).getText());
        double secondPrice = homePage.getPriceFromText(prices.get(1).getText());
        Assert.assertTrue(firstPrice <= secondPrice, "Harga item pertama tidak lebih kecil atau sama dengan harga item kedua.");


    }

    @AfterTest
    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
