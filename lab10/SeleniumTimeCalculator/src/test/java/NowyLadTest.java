import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NowyLadTest {
    private static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.calculator.net/fuel-cost-calculator.html");
    }

    private void submitValues(int distance, double efficiency, double price) {
        driver.findElement(By.name("tripdistance")).clear();
        driver.findElement(By.name("tripdistance")).sendKeys(String.valueOf(distance));

        driver.findElement(By.name("fuelefficiency")).clear();
        driver.findElement(By.name("fuelefficiency")).sendKeys(String.valueOf(efficiency));

        driver.findElement(By.name("gasprice")).clear();
        driver.findElement(By.name("gasprice")).sendKeys(String.valueOf(price));

        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Test
    public void testNowyLad1() {

        submitValues(414, 5.5, 1.8);

        String result = driver.findElement(By.cssSelector(".verybigtext")).getText();
        String expected = "This trip will require 22.8 liters of fuel, which amounts to a fuel cost of $40.99.";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNowyLad2() {

        submitValues(100, 9d, 6d);

        int liters_of_fuel = Integer.parseInt(driver.findElement(By.cssSelector("font:nth-child(1) > b")).getText());
        String cost = driver.findElement(By.cssSelector("font:nth-child(2) > b")).getText();

        Assert.assertEquals(9, liters_of_fuel);
        Assert.assertEquals("$54", cost);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
