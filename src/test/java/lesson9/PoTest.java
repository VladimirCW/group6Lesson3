package test.java.lesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.java.TestBaseSetup;

public class PoTest extends TestBaseSetup {
    WebDriverWait wait;
    By sellBtnBy = By.xpath("(//div[@id='nav-xshop']/a)[5]");
    By registryBtnBy = By.xpath("(//div[@id='nav-xshop']/a)[5]");
    By giftCardsBtnBy = By.xpath("(//div[@id='nav-xshop']/a)[5]");
    By price200AndAboveBy = By.xpath("//span[text() = '$200 & Above']");
    By selectedPriceResultBy = By.xpath("//span[contains(text(), 'results for')]/following-sibling::span[@class='a-color-state a-text-bold']");
    By giftsBy = By.xpath("//div[@data-component-type='s-search-result']");

    @Test
    public void test1() {
        wait = new WebDriverWait(driver, 10, 500);
        driver.get("https://www.amazon.com/");
        wait.until(d -> d.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6);
        /*wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply( WebDriver driver) {
                return driver.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6;
            }
        });*/
        driver.findElement(sellBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[contains(text(), 'Sell on Amazon')])[1]")));
        driver.findElement(registryBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@alt='Register with Amazon']")));
        driver.findElement(giftCardsBtnBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text() = 'Gift Cards']")),
                d -> d.findElements(By.xpath("//div[@class='bxc-grid__image   bxc-grid__image--light']")).size() >= 3
        ));
        driver.findElement(price200AndAboveBy).click();
        wait.until(ExpectedConditions.and(
                d -> d.findElement(selectedPriceResultBy).getText().equals("$200 & Above'"),
                d -> d.findElements(giftsBy).size() > 1
        ));
    }
}
