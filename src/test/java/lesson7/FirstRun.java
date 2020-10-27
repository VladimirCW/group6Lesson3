package test.java.lesson7;

import main.java.lesson3.objects.Animal;
import main.java.lesson3.objects.Cat;
import main.java.lesson3.objects.Dog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstRun {
    public static void main(String[] args) throws InterruptedException {
//        int a = 123;
//        long b = a;
//        int c = (int)b;
//
//        Cat cat = new Cat("SSSS");
//        Animal animal = cat;
//        Cat cat2 = (Cat) animal;
//        Dog dog = (Dog)animal;

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("window-size=300,300");
        //chromeOptions.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");

        Thread.sleep(5000);

        /*By byBestSeller = By.id("someId");
        By byBestSeller = By.cssSelector("div[id='someId']");
        By byBestSeller = By.xpath("//div[@id='someId']");*/
        By byDeals = By.xpath("//a[@href='/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl']");
        //By byBestSeller = By.cssSelector("a[href='/gp/bestsellers/?ref_=nav_cs_bestsellers']");

        WebElement dealsBtn = driver.findElement(byDeals);
        dealsBtn.click();

        Thread.sleep(5000);

        WebElement dealTitle = driver.findElement(By.xpath("//div[@id='fst-hybrid-dynamic-h1']//b"));
        String titleString = dealTitle.getText();

        System.out.println("TITLE IS: " + titleString);

        driver.close();
        //driver.quit();
    }
}
