package test.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class Screenshots {
    private final String delimiter = System.getProperty("os.name").toLowerCase().contains("windows") ? "\\" : "/";
    private WebDriver driver;

    public Screenshots(WebDriver driver) {
        this.driver = driver;
    }

    public void makeScreenshot(ITestResult testResult) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        Path currentPath = Paths.get(""); //C:/Users/Vova/project6 + screenshots
        try {
            FileUtils.copyFile(src, new File(
                    currentPath.toAbsolutePath().toString()
                            + delimiter + "screenshot"
                            + delimiter + testResult.getTestClass().getName().replace(".", delimiter)
                            + delimiter + testResult.getMethod().getConstructorOrMethod().getName()
                            + "-" + new Date().getTime() + ".png"
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
