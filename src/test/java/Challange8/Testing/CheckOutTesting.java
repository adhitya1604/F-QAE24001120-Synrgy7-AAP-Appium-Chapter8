package Challange8.Testing;

import Challange8.page.CartPage;
import Challange8.page.CheckOutPage;
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

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertNotNull;

public class CheckOutTesting {
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
    public void checkoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");

        homePage.addFirstTwoItemsToCart();
        homePage.clickCartIcon();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterCheckoutInformation("Adhitya", "Andriansyah", "40124");
        checkOutPage.clickContinueButton();
        checkOutPage.clickFinishButton();

        Assert.assertEquals(checkOutPage.getSuccessMessage(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkOutPage.getSuccessMessage2(), "THANK YOU FOR YOU ORDER");
        Assert.assertEquals(checkOutPage.getSuccessMessage3(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");

        WebElement gambar = checkOutPage.getGambar();
        assertNotNull(String.valueOf(gambar), "Gambar tidak ditemukan");

        Assert.assertEquals(checkOutPage.getButtonText(), "BACK HOME");

        checkOutPage.clickBackButton();

        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");

        List<WebElement> items = homePage.getItems();
        assertFalse("Item tidak ditemukan", items.isEmpty());


    }
    @AfterTest
    public static void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}


