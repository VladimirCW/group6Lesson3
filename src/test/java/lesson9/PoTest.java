package test.java.lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.GiftPage;
import test.java.pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class PoTest extends TestBaseSetup {
    HomePage homePage;
    GiftPage giftPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        giftPage = new GiftPage(driver);
    }

    @Test
    public void test1() {
        homePage
                .open()
                .clickSellBtn()
                .clickRegistryBtn()
                .clickSellBtn()
                .clickGiftCardsBtn();
        List<WebElement> cartsList =
                giftPage
                        .clickPrice("$200 & Above")
                        .getCartsList();

        for (WebElement cart: cartsList) {
            int actualMaximumPrice = giftPage.getMaximumCartPrice(cart);
            assertTrue(
                    actualMaximumPrice >= 200,
                    String.format("Expected price %d to be more than 200", actualMaximumPrice)
            );
        }
    }
}
