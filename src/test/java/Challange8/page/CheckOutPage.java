package Challange8.page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage {
    AndroidDriver driver;
    WebDriverWait wait;

    private By firstNameField = AppiumBy.accessibilityId("test-First Name");
    private By lastNameField = AppiumBy.accessibilityId("test-Last Name");
    private By postalCodeField = AppiumBy.accessibilityId("test-Zip/Postal Code");
    private By continueButton = AppiumBy.xpath("//android.widget.TextView[@text='CONTINUE']");
    private By finishButton = AppiumBy.accessibilityId("test-FINISH");
    private By successMessage = AppiumBy.xpath("//android.widget.TextView[@text=\"CHECKOUT: COMPLETE!\"]");
    private By successMessage2 = AppiumBy.xpath("//android.widget.TextView[@text=\"THANK YOU FOR YOU ORDER\"]");
    private By successMessage3 = AppiumBy.xpath("//android.widget.TextView[@text=\"Your order has been dispatched, and will arrive just as fast as the pony can get there!\"]");
    private By Gambar = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.ImageView");
    private By ButtonText = AppiumBy.xpath("//android.widget.TextView[@text=\"BACK HOME\"]");
    private By backButton = AppiumBy.accessibilityId("test-BACK HOME");

    public CheckOutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void enterCheckoutInformation(String firstName, String lastName, String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField)).sendKeys(postalCode);
    }

    public void clickContinueButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton)).click();
    }

    public void clickFinishButton() {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().text(\"FINISH\"))"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton)).click();
    }

    public String getSuccessMessage() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
    }

    public String getSuccessMessage2() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage2)).getText();
    }

    public String getSuccessMessage3() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage3)).getText();
    }

    public WebElement getGambar() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(Gambar));
    }

    public String getButtonText() {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(ButtonText)).getText();
    }

    public void clickBackButton() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(backButton)).click();
    }
}

