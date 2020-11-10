package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private final int RETRY_MAX = 2;
    private int count = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < RETRY_MAX) {
            count++;
            return true;
        }
        return false;
    }
}
