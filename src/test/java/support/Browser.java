package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Browser {
    private static WebDriver driver;
    public static WebDriverWait wait;
    public static Actions actions;

    public static void openBrowser(String browserName){

        switch (browserName.toLowerCase()){
            case "chrome":{
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            default:
                throw new IllegalArgumentException("Un Support Browser: " + browserName.toLowerCase());
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    public static void visit(String url){
        driver.get(url);
    }
    public static void quit(){
        if (driver!=null){
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static void check(By locator){
        if(!isSelected(locator)){
            driver.findElement(locator).click();
        }
    }
    public static void unCheck(By locator){
        if(isSelected(locator)){
            driver.findElement(locator).click();
        }
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }
    public static void click(By locator){
        driver.findElement(locator).click();

    }
    public static List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }
}
