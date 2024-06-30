package Challange8.stepdef;


import Challange8.page.HomePage;
import Challange8.page.LoginPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class SortirItemStepDef {
    AndroidDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    public SortirItemStepDef(AndroidDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
    }

    @Then("user is on home page")
    public void userIsOnHomePage() {

        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");

        List<WebElement> items = homePage.getItems();
        Assert.assertFalse(items.isEmpty(), "Item tidak ditemukan");
    }

    @Given("user login with valid username and password")
    public void userLoginWithValidUsernameAndPassword() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "12.0");
        capabilities.setCapability("deviceName", "ukgyeyt8xkzpfmf6");
        capabilities.setCapability("app", "C:/Users/Adhitya Andriansyah/Downloads/[Exercise CH 8] Android.SauceLabs.Mobile.Sample.app.2.7.1 .apk");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(capabilities);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUser("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");

    }


    @And("user click on filter button")
    public void userClickOnFilterButton() {
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\\\"test-Modal Selector Button\\\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView\")")).click();
    }

    @When("user click on low to high button")
    public void userClickOnLowToHighButton() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Price (low to high)']")).click();

    }

    //@Then("items are lined up in order of low price to high price")
    //public <MobileElement> void itemsAreLinedUpInOrderOfLowPriceToHighPrice() {
       // List<MobileElement> priceElements = (List<MobileElement>) (List<MobileElement>) driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));

        //boolean sorted = true;
       // for (int i = 0; i < priceElements.size() - 1; i++) {
           // Class<?> price1 = priceElements.get(i).getClass();
           // String price2 = String.valueOf(priceElements.get(i + 1).getClass());
            // Assuming prices are in a format that allows direct comparison as strings
           // if (Double.parseDouble(String.valueOf(price1)) > Double.parseDouble(price2)) {
            //    sorted = false;
            //    break;
           // }
        //}
   // }


    @When("user click on high to low button")
    public void userClickOnHighToLowButton() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Price (high to low)']")).click();
    }

    @When("user click on name A to Z button")
    public void userClickOnNameAToZButton() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Price (A to Z)']")).click();
    }

    @When("user click on name Z to A button")
    public void userClickOnNameZToAButton() {
        driver.findElement(By.xpath("//android.widget.TextView[@text='Price (Z to A)']")).click();
    }
}

    //@Then("items are lined up in order of name A to Z")
   // public void itemsAreLinedUpInOrderOfNameAToZ() {
//List<MobileElement> nameElements = driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]"));

//boolean sorted = true;
       // for (int i = 0; i < nameElements.size() - 1; i++) {
          //  String name1 = nameElements.get(i).getText();
           // String name2 = nameElements.get(i + 1).getText();
            // Compare names ignoring case to verify alphabetical order
           // if (name1.compareToIgnoreCase(name2) > 0) {
           //     sorted = false;
              //  break;
           // }
       // }

        // Assert or verify sorted flag
       // Assert.assertTrue(sorted, "Items are not sorted in order of name A to Z");
  //  }

    //@Then("items are lined up in order of high price to low price")
   // public void itemsAreLinedUpInOrderOfHighPriceToLowPrice() {
        //List<MobileElement> priceElements = driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]"));

        //boolean sorted = true;
       // for (int i = 0; i < priceElements.size() - 1; i++) {
        //    String price1 = priceElements.get(i).getText();
        //    String price2 = priceElements.get(i + 1).getText();
            // Assuming prices are in a format that allows direct comparison as strings
           // if (Double.parseDouble(price1) < Double.parseDouble(price2)) {
           //     sorted = false;
           //     break;
         //   }
       // }
   // }

   // @Then("items are lined up in order of name Z to A")
   // public <MobileElement> void itemsAreLinedUpInOrderOfNameZToA() {
     //   List<MobileElement> nameElements = driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"test-Item title\"]"));

      //  boolean sorted = true;
      ///  for (int i = 0; i < nameElements.size() - 1; i++) {
       //     String name1 = nameElements.get(i).getText();
      //      String name2 = nameElements.get(i + 1).getText();
            // Compare names ignoring case to verify reverse alphabetical order
       //     if (name1.compareToIgnoreCase(name2) < 0) {
          //      sorted = false;
          //      break;
        //    }
       // }

       // Assert.assertTrue(sorted, "Items are not sorted in order of name Z to A");
   // }


