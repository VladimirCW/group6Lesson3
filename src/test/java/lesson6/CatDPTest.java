package test.java.lesson6;

import main.java.lesson3.objects.Cat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CatDPTest {
    Cat cat;

    @BeforeMethod
    public void setUp() {
        cat = new Cat("Vova");
    }

    @Test(dataProvider = "dp")
    public void setAgeTest(int ageToSet, int expectedAge) {
        //Act
        cat.setAge(ageToSet);
        int actualAge = cat.getAge();
        //Assert
        assertEquals(actualAge, expectedAge, String.format("Expected age to be %d, but actual was %d", expectedAge, actualAge));
    }

    @DataProvider(name = "dp")
    public Object[][] dataProvider() {
        return new Object[][] {
                {0, 20},
                {-1, 20},
                {1, 1},
                {20, 20},
                {8, 8},
                {21, 20},
                {2000, 20}
        };
    }
}
