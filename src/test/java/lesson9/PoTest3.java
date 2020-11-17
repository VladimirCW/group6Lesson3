package test.java.lesson9;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.GiftPage;
import test.java.pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

@Epic("Epic 1")
@Feature("Feature third")
public class PoTest3 extends TestBaseSetup {
    HomePage homePage;
    GiftPage giftPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        giftPage = new GiftPage(driver);
    }

    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Stories({
            @Story("AAA-6"),
            @Story("AAA-7")
    })
    @Links({
            @Link("https://google.com"),
            @Link("https://google.com")
    })
    @TmsLinks({
            @TmsLink("BBB-1"),
            @TmsLink("BBB-2")
    })
    @Issues({
            @Issue("JIRA-1"),
            @Issue("JIRA-2")
    })
    @Description("Some detailed description")
    @Severity(SeverityLevel.CRITICAL)
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
