package test.java.lesson6;

import main.java.lesson3.objects.Cat;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class CatTest2 {
    Cat cat;

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("- BEFORE CLASS");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("-- BEFORE METHOD");
        cat = new Cat("Vova");
    }

    @AfterClass
    public void afterClassMethod() {
        System.out.println("- AFTER CLASS");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("-- AFTER METHOD");
        cat = new Cat("Vova");
    }

    /*@BeforeGroups("FIRST")
    public void beforeFirst() {
        System.out.println(" --- BEFORE FIRST GROUP");
    }*/

    @Test(groups = "FIRST", dependsOnGroups = "SECOND")
    public void setAgePositive() {
        //Arange
        int ageToSet = 10;
        int expectedAge = 10;
        //Act
        cat.setAge(ageToSet);
        int actualAge = cat.getAge();
        //Assert
        assertEquals(actualAge, expectedAge, String.format("Expected age to be %d, but actual was %d", expectedAge, actualAge));
    }

    @Test(groups = "SECOND", dependsOnMethods = "setAgePositive3")
    public void setAgePositive2() {
        //Arange
        int ageToSet = 1;
        int expectedAge = 1;
        //Act
        cat.setAge(ageToSet);
        int actualAge = cat.getAge();
        //Assert
        assertEquals(actualAge, expectedAge, String.format("Expected age to be %d, but actual was %d", expectedAge, actualAge));
    }

    @Test(groups = "SECOND")
    public void setAgePositive3() {
        //Arange
        int ageToSet = 0;
        int expectedAge = 20;
        //Act
        cat.setAge(ageToSet);
        int actualAge = cat.getAge();
        //Assert
        assertEquals(actualAge, expectedAge, String.format("Expected age to be %d, but actual was %d", expectedAge, actualAge));
    }
}
