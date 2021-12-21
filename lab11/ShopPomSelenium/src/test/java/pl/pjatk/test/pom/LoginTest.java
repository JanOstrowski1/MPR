package pl.pjatk.test.pom;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static final String UNSUCCESFUL_LOGIN_ERROR_MESSAGE = "There is 1 error\nAuthentication failed.";
    private WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void successfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        LoginPage loginPage = navigationBar.openLoginPage();
        loginPage.successfulLogin("testujemypjatk@gmail.com", "1234Testujemy@2");
        Assert.assertEquals("Jan Kowalski", navigationBar.getUserName());
    }

    @Test
    public void unSuccessfulLoginTest(){
        NavigationBar navigationBar = new NavigationBar(driver);
        LoginPage loginPage = navigationBar.openLoginPage();
        loginPage.unsuccesfulLogin("ttttt@wp.pl", "pudlo1!");
        Assert.assertEquals(UNSUCCESFUL_LOGIN_ERROR_MESSAGE, loginPage.getErrorMessage());
    }

    @After
    public void tearDown(){
        driver.quit();
    }


}
