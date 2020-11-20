package test.java.lesson9;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
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

@Epic("Epic 1")
@Feature("First feature")
public class PoTest extends TestBaseSetup {
    HomePage homePage;
    GiftPage giftPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        giftPage = new GiftPage(driver);
    }

    //@Story("AAA-1")
    @Stories({
            @Story("AAA-1"),
            @Story("AAA-2")
    })
    @Test
    public void test1() {
        //((JavascriptExecutor) driver).executeScript("document.getElementById('twotabsearchtextbox').value = 'GOOD BY'")
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

    @Stories({
            @Story("AAA-3"),
            @Story("AAA-2")
    })
    @Test
    public void test2() {
        //((JavascriptExecutor) driver).executeScript("document.getElementById('twotabsearchtextbox').value = 'GOOD BY'")
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

    @Test
    public void parametrizedTest(String name) {
        System.out.println("TEST PARAMETRIZED WITH: " + name);
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
