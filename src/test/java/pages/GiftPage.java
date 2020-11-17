package test.java.pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.List;

public class GiftPage extends BasePage{
    private Logger logger = LogManager.getLogger(GiftPage.class);
    WebDriver driver;
    WebDriverWait wait;
    //By selectedPriceResultBy = By.xpath("//span[contains(text(), 'results for')]/following-sibling::span[@class='a-color-state a-text-bold']");
    By giftsBy = By.xpath("//div[@data-component-type='s-search-result']");

    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    private List<WebElement> cardsList;

    public GiftPage(WebDriver driver) {
        logger.trace("GIFT PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver, this);
    }

    @Step("Gift page open")
    public GiftPage open() {
        logger.info("Open Gift page");
        driver.get(PropertyLoader.loadProperty("url") + "gift-cards/b/?ie=UTF8&node=2238192011&ref_=nav_cs_gc");
        wait.until(d -> d.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6);
        /*wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply( WebDriver driver) {
                return driver.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6;
            }
        });*/
        return this;
    }

    @Step("Click price {price}")
    public GiftPage clickPrice(String price) {
        logger.info("Click price '" + price + "'");
        By priceBy = By.xpath("(//span[text() = '" + price + "'])[1]");
        driver.findElement(priceBy).click();
        wait.until(ExpectedConditions.and(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(selectedPriceResultBy),
//                d -> d.findElement(selectedPriceResultBy).getText().equals(price),
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[contains(text(), '" + price + "')]")),
                d -> d.findElements(giftsBy).size() > 1
        ));
        return this;
    }

    @Step("Get cards list")
    public List<WebElement> getCartsList() {
        logger.info("Get list of carts");
        return cardsList;
    }


    public int getMaximumCartPrice(WebElement cart) {
        logger.debug("Get 'XXXX' cart maximum price");
        List<WebElement> pricesList = cart.findElements(By.className("a-price-whole"));
        String actualMaximumPriceAsString = pricesList.get(pricesList.size() - 1).getText().replace(",", "");
        return this.parsePriceAsAString(actualMaximumPriceAsString);
    }

    @Step("Get maximum card price {actualMaximumPriceAsString}")
    private int parsePriceAsAString(String actualMaximumPriceAsString) {
        return Integer.parseInt(actualMaximumPriceAsString);
    }
}
