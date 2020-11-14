package test.java.utils;

import org.testng.annotations.DataProvider;

public class DPClass {

    @DataProvider
    public Object[][] firstMethod() {
        return new Object[][] {
                {"Hello"},
                {"Goodby"}
        };
    }

    @DataProvider
    public Object[][] secondMethod() {
        return new Object[][] {
                {"YO-YO-YO"}
        };
    }
}
