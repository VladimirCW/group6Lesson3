package test.java.pages;

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

public class HomePage extends BasePage {
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//a[text() ='Sell']")
    private WebElement sellBtn;
    @FindBy(xpath = "//a[text() ='Registry']")
    private WebElement registryBtn;
    @FindBy(xpath = "//a[text() ='Gift Cards']")
    private WebElement giftCardsBtn;

    public HomePage(WebDriver driver) {
        logger.trace("HOME PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        logger.info("Open home page");
        logger.warn("WARNING !!!!!");
        try{
            System.out.println(1/0);
        } catch (ArithmeticException error) {
            logger.error("ARIPHMETIC ERROR !!!!!");
        } catch (ArrayIndexOutOfBoundsException aiobe) {
            logger.error("ARRAY ERROR !!!!!");
        } catch (Exception e) {
            logger.info("UNKNOWN ERROR");
        }

        logger.fatal("ERROR !!!!!");
        driver.get(PropertyLoader.loadProperty("url"));
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
        logger.info("Click 'Sell' button");
        sellBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//*[contains(text(), 'Sell on Amazon')])[1]")));
        return this;
    }

    public HomePage clickRegistryBtn() {
        logger.info("Click 'Registry' button");
        registryBtn.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@alt='Register with Amazon']")));
        return this;
    }

    public HomePage clickGiftCardsBtn() {
        logger.info("Click 'Gift cards' button");
        giftCardsBtn.click();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//h1[text() = 'Gift Cards']")),
                d -> d.findElements(By.xpath("//div[@class='bxc-grid__image   bxc-grid__image--light']")).size() >= 3
        ));
        return this;
    }
}
