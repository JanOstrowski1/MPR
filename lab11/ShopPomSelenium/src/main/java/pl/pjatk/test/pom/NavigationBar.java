package pl.pjatk.test.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
    @FindBy(className = "login")
    private WebElement loginButton;

    @FindBy(className = "account")
    private WebElement userButton;

    private WebDriver driver;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage openLoginPage() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public String getUserName(){
        return userButton.getText();
    }
}
