package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Browser;

public class FormAuthenticationPage {
    WebDriver driver;
    By usernameTextBox = By.id("username");
    By passwordTextBox = By.id("password");
    By loginButton = By.cssSelector("button[type=submit]");


    public FormAuthenticationPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        driver.findElement(usernameTextBox).sendKeys(username);
        driver.findElement(passwordTextBox).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public boolean verifyMessageContent(String type, String message) {
        return driver.findElement(By.className(type)).getText().contains(message);

    }
}


