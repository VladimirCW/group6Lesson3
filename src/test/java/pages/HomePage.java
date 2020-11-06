package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;
    By sellBtnBy = By.xpath("//a[text() ='Sell']");
    By registryBtnBy = By.xpath("//a[text() ='Registry']");
    By giftCardsBtnBy = By.xpath("//a[text() ='Gift Cards']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public HomePage open() {
        driver.get("https://www.amazon.com/");
        wait.until(d -> d.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6);
        /*wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply( WebDriver driver) {
                return driver.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6;
            }
        });*/
        return this;
    }

    public HomePage clickSellBtn() {
        driver.findElement(sellBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[contains(text(), 'Sell on Amazon')])[1]")));
        return this;
    }

    public HomePage clickRegistryBtn() {
        driver.findElement(registryBtnBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@alt='Register with Amazon']")));
        return this;
    }

    public HomePage clickGiftCardsBtn() {
        driver.findElement(giftCardsBtnBy).click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text() = 'Gift Cards']")),
                d -> d.findElements(By.xpath("//div[@class='bxc-grid__image   bxc-grid__image--light']")).size() >= 3
        ));
        return this;
    }
}
