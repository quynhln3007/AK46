package TheInternet;

import TheInternet.pages.DropDownPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.Browser;

import java.time.Duration;

public class DropDownTest {
    /*Open browser

Navigate to https://the-internet.herokuapp.com/dropdown

Select "option 1"

Validate "option 1" is selected
*/

    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }
    @Test
    void ableToSelectDropDown() {
        DropDownPage dropDownPage=new DropDownPage();
        dropDownPage.open();
        dropDownPage.selectOption("Option 1");
        Assert.assertTrue(dropDownPage.isSelected("Option 1"));
    }

  /*  @Test
    void ableToSelectMultipleOptions() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        Assert.assertTrue(select.isMultiple());
        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
        //Select banana and apple
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("option[value='apple']")).isSelected());
        // Deselect banana
        select.deselectByVisibleText("Banana");
        // verify able select banana and apple
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        // deselect all
        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='grape']")).isSelected());
    }

    /*
    Open Browser
    Navigate to https://www.vietnamairlines.com/vn/en/home
    Agree Cookies
    Select To City
    Select One Way
    Select Depart date [X]

    */
    @Test
    void selectADate() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.vietnamairlines.com/vn/en/home");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();

        // select depart date
        wait.until(ExpectedConditions.elementToBeClickable(By.id("roundtrip-date-depart"))).click();

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0) // get current month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("31"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(1) // get next month
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("5"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Done')]"))).click();
    }
}
