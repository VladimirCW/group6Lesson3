package test.java.utils;

import org.testng.annotations.DataProvider;

public class DPSource {

    @DataProvider
    public Object[][] smoke() {
        return new Object[][] {
                {"AAA"}
        };
    };

    @DataProvider
    public Object[][] regression() {
        return new Object[][] {
                {"AAA"},
                {"BBB"},
                {"CCC"}
        };
    }
}
