package test.java.utils;

import org.openqa.selenium.WebDriver;
import org.testng.*;

public class Listener implements ISuiteListener, ITestListener, IInvokedMethodListener {
    WebDriver driver;

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        //System.out.println("-BEFORE INVOCATION");
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        //System.out.println("AFTER INVOCATION");
    }

    @Override
    public void onStart(ISuite iSuite) {
        //System.out.println("--SUITE STARTED");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        //System.out.println("--SUITE FINISHED");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //System.out.println("TEST STARTED");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //System.out.println("TEST WAS SUCCEEDED");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        /*System.out.println("TEST WAS FAILED");
        driver = (WebDriver) (iTestResult.getTestContext().getAttribute("driver"));
        Screenshots screenshots = new Screenshots(driver);
        screenshots.makeScreenshot(iTestResult);*/
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        //driver = (WebDriver) iTestContext.getAttribute("driver");
        //System.out.println("TEST STARTED");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //System.out.println("TEST FINISHED");
    }
}
