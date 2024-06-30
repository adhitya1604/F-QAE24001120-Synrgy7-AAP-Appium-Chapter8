package Challange8.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    AndroidDriver driver;
    WebDriverWait wait;

    By checkoutButton = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-CHECKOUT\"]");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCheckoutButton() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"CHECKOUT\"))"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton)).click();
    }
}
