package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePickerTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='cookie-agree']"))).click();
    }

    @Test
    void ableToSelectDate() {
//select depart date
        wait.until(ExpectedConditions.elementToBeClickable(By.id("roundtrip-date-depart"))).click();

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0) // get current month
                .findElements(By.tagName("a"))
                .stream()
                .filter(cell -> cell.getText().contains("29"))
                .findFirst()
                .ifPresent(WebElement::click);


         //Open and select the return date
       // wait.until(ExpectedConditions.elementToBeClickable(By.id("roundtrip-date-return"))).click();

        wait
                .until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By
                                                .cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(1)
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("15"))
                .findFirst()
                .ifPresent(WebElement::click);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Done')]"))).click();
    }
}
      /*  String departDate=driver.findElement(By.id("roundtrip-date-depart")).getAttribute("value");
        System.out.println(departDate);
        String returnDate=driver.findElement(By.id("roundtrip-date-return")).getAttribute("value");
        System.out.println(returnDate);
    }
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Get the day of the month
        int dayOfMonth = today.getDayOfMonth();

        // next 7 days
//        today.plusDays(7).getDayOfMonth();

        // Print the current day of the month
        System.out.println("Current Day of the Month: " + dayOfMonth);
        System.out.println("Next Day of the Month: " + today.plusDays(7).getDayOfMonth());
*/
