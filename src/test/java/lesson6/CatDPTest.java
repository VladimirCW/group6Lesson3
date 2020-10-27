package test.java.lesson6;

import main.java.lesson3.objects.Cat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @Ignore
    @Test(dataProvider = "test")
    //@Test(dataProviderClass = CatTest2.class, dataProvider = "dadas")
    public void testTest(int int1, int int2, String str1, String str2, Cat cat1, Cat cat2) {
        int a = int1;
        int b = int2;
        assertEquals(str1, str2);
        assertTrue(cat1.equals(cat2));
    }

    @DataProvider(name = "test")
    public Object[][] dataProviderForTest() {
        return new Object[][] {
                {10, 20, "AAA", "BBB", new Cat("Vova"), new Cat("Max")},
                {1000, 2000, "AA---A", "BBB", new Cat("Vova1"), new Cat("Max1")}
        };
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
