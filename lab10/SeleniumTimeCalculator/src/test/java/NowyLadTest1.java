import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NowyLadTest1 {
    private static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.podatki.gov.pl/polski-lad/kwota-wolna-polski-lad/kalkulator-wynagrodzen-polski-lad/");
    }

    private void submitValues(int salary, boolean workplace, boolean isPPK) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn.btn-primary.cc-btn.cc-dismiss")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#salary")).sendKeys(String.valueOf(salary));

        if(workplace){
            driver.findElement(By.cssSelector("#workplace1")).click();
        }else {
            driver.findElement(By.id("#workplace0")).click();
        }

        if(isPPK){
            driver.findElement(By.cssSelector("#isppk1")).click();
        }else {
            driver.findElement(By.cssSelector("#isppk0")).click();
        }
    }

    @Test
    public void testNowyLad1() throws InterruptedException {

        submitValues(12000, true, true);

        String result = driver.findElement(By.id("cell_c30_n")).getText();
        String expected = "7817,12 zł";
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testNowyLad2() throws InterruptedException {

        submitValues(10000, false, false);

        String result = driver.findElement(By.id("cell_c30_n")).getText();
        String expected = "6953,92 zł";
        Assert.assertEquals(expected, result);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
