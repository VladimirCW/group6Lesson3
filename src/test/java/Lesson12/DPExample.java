package test.java.Lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;
import test.java.pages.GiftPage;
import test.java.pages.HomePage;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DPExample extends TestBaseSetup {
    HomePage homePage;
    GiftPage giftPage;

    @BeforeMethod
    public void pageInitialize() {
        homePage = new HomePage(driver);
        giftPage = new GiftPage(driver);
    }

    //@Test(retryAnalyzer = RetryAnalyzer.class)
    @Test(dataProvider = "dp")
    public void test1(String producer) {
        //sdfsdfdsfsfs
        WebElement el = driver.findElement(By.xpath("//li[@class='a-spacing-micro' and @aria-label='" + producer + "']"));
        el.click();
        List<WebElement> list = driver.findElements(By.xpath(""));
        for (WebElement i: list) {
            i.getText().contains(producer);
        }
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][] {
                {"HP"},
                {"Dell"}
        };
    }
}
