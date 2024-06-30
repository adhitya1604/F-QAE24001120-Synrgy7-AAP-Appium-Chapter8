package Challange8.stepdef;

import Challange8.page.CartPage;
import Challange8.page.CheckOutPage;
import Challange8.page.HomePage;
import Challange8.page.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.List;
public class CheckOutStepDef {

        AndroidDriver driver;
        LoginPage loginPage;
        HomePage homePage;
        CartPage cartPage;
        CheckOutPage checkOutPage;
         WebElement gambar;

        public CheckOutStepDef(AndroidDriver driver){
            this.driver = driver;
            this.loginPage = new LoginPage(driver);
            this.loginPage = new LoginPage(driver);
        }
    @When("user adds the first two items to the cart")
    public void userAddsFirstTwoItemsToCart() {
        homePage = new HomePage(driver);
        homePage.addFirstTwoItemsToCart();
    }

    @And("user proceeds to checkout")
    public void userProceedsToCheckout() {
        homePage.clickCartIcon();
        cartPage = new CartPage(driver);
        cartPage.clickCheckoutButton();
    }

    @And("user enters checkout information")
    public void userEntersCheckoutInformation() {
        checkOutPage = new CheckOutPage(driver);
        checkOutPage.enterCheckoutInformation("Adhitya", "Andriansyah", "40124");
    }

    @And("user clicks continue")
    public void userClicksContinue() {
        checkOutPage.clickContinueButton();
    }

    @And("user clicks finish")
    public void userClicksFinish() {
        checkOutPage.clickFinishButton();
    }

    @Then("checkout is complete with success messages")
    public void checkoutIsCompleteWithSuccessMessages() {
        Assert.assertEquals(checkOutPage.getSuccessMessage(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkOutPage.getSuccessMessage2(), "THANK YOU FOR YOU ORDER");
        Assert.assertEquals(checkOutPage.getSuccessMessage3(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @And("user verifies the order confirmation details")
    public void userVerifiesOrderConfirmationDetails() {
        WebElement gambar = checkOutPage.getGambar();
        Assert.assertNotNull("Gambar tidak ditemukan", gambar);
        Assert.assertEquals(checkOutPage.getButtonText(), "BACK HOME");
    }

    @And("user returns to home page")
    public void userReturnsToHomePage() {
        checkOutPage.clickBackButton();
        Assert.assertEquals(homePage.getTextDashboard(), "PRODUCTS");
    }

    @And("user verifies products are still displayed")
    public void userVerifiesProductsAreStillDisplayed() {
        List<WebElement> items = homePage.getItems();
        Assert.assertFalse("Item tidak ditemukan", items.isEmpty());
    }
}
