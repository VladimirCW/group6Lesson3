package test.java.lesson9;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.GiftPage;
import test.java.pages.HomePage;
import test.java.utils.RetryAnalyzer;

import java.util.List;

import static org.testng.Assert.assertTrue;

@Epic("Epic 2")
@Feature("Feature second")
public class PoTest2 extends TestBaseSetup {
    HomePage homePage;
    GiftPage giftPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        giftPage = new GiftPage(driver);
    }

    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Stories({
            @Story("AAA-4"),
            @Story("AAA-5")
    })
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
                        .clickPrice("Under $25")
                        .getCartsList();

        for (WebElement cart: cartsList) {
            int actualMaximumPrice = giftPage.getMaximumCartPrice(cart);
            assertTrue(
                    actualMaximumPrice <= 25,
                    String.format("Expected price %d to be more than 200", actualMaximumPrice)
            );
        }
    }
}
