package test.java.lesson6;

import main.java.lesson3.objects.Cat;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CatTests {

    @Parameters({"ageToSet", "expectedAge"})
    @Test
    public void setAgePositive(@Optional("10") String ageToSet, @Optional("10") String expectedAge) {
        //Arange
//        int ageToSet = 10;
//        int expectedAge = 10;
        Cat cat = new Cat("Vova");
        //Act
        cat.setAge(Integer.parseInt(ageToSet));
        int actualAge = cat.getAge();
        //Assert
        assertEquals(actualAge, Integer.parseInt(expectedAge), String.format("Expected age to be %d, but actual was %d", Integer.parseInt(expectedAge), actualAge));
//        assertTrue(actualAge == 1000,
//                String.format("Expected age to be %d, but actual was %d", 1000, actualAge));
    }

    @Test
    public void checkEqualsIfTrue() {
        Cat cat1 = new Cat("Vova");
        Cat cat2 = new Cat("Vova");
        boolean isEquals = cat1.equals(cat2);
        assertTrue(isEquals, "Expected cats to be equals");
    }

    @Test
    public void checkEqualsIfFalse() {
        Cat cat1 = new Cat("Vova");
        Cat cat2 = new Cat("Max");
        boolean isEquals = cat1.equals(cat2);
        assertFalse(isEquals, "Expected cats to be equals");
    }
}
