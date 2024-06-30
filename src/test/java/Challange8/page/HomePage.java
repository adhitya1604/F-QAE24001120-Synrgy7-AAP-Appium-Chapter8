package Challange8.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    AndroidDriver driver;
    WebDriverWait wait;


    By dashboardText = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");
    By items = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])/android.view.ViewGroup");
    By sortDropdown = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView");
    By itemPrices = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
    By addToCartButtons = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]//android.widget.TextView[@text='ADD TO CART']");
    By cartIcon = AppiumBy.accessibilityId("test-Cart");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public String getTextDashboard() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText)).getText();
    }
    public List<WebElement> getItems() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(items));
    }
    public void sortItemsLowToHigh() {
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(sortDropdown));
        dropdown.click();
        WebElement priceLowToHighOption = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Price (low to high)']")));
        priceLowToHighOption.click();
    }

    public List<WebElement> getItemPrices() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemPrices));
    }

    public List<WebElement> getAllItems() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(items));
    }

    public double getPriceFromText(String priceText) {
        return Double.parseDouble(priceText.replace("$", ""));
    }

    public void addFirstTwoItemsToCart() {
        List<WebElement> buttons = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons));
        if (buttons.size() >= 2) {
            buttons.get(0).click();
            buttons.get(1).click();
        }
    }

    public void clickCartIcon() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon)).click();
    }
}

