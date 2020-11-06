package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.java.utils.Screenshots;

import java.util.concurrent.TimeUnit;

public class TestBaseSetup {
    public WebDriver driver;

    @BeforeMethod
    public void initializeBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finalizeBrowser(ITestResult testResult) {
        Screenshots screenshots = new Screenshots(driver);
        screenshots.makeScreenshot(testResult);
        driver.quit();
    }
}
