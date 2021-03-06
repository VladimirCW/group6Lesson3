package test.java;

import io.qameta.allure.Attachment;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import test.java.utils.Screenshots;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBaseSetup {
    public WebDriver driver;

    @BeforeMethod
    public void initializeBrowser(ITestContext iTestContext) {
        /*System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);*/

        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions ffOption = new FirefoxOptions();
        try {
            //driver = new RemoteWebDriver(new URL("http://ec2-18-223-162-200.us-east-2.compute.amazonaws.com:4444/wd/hub"), chromeOptions);
            MutableCapabilities options = System.getProperty("browser").equals("chrome")
                    ? chromeOptions
                    : ffOption;
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void finalizeBrowser() {
        attachText();
        attachScreen();
        driver.quit();
    }

    @Attachment
    private String attachText() {
        return "Text attachment";
    }

    @Attachment
    private byte[] attachScreen() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
