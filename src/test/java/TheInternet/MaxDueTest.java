package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class MaxDueTest {
    WebDriver driver;
    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }



    @Test
    public void testMaxDuePerson() {
        // Locate the "Due" values in the table and extract them as a list of doubles
        List<WebElement> dueElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
        double[] dueValues = dueElements.stream()
                .mapToDouble(element -> Double.parseDouble(element.getText().replace("$", "")))
                .toArray();

        // Find the maximum "Due" value
        double maxDueValue = dueElements.stream()
                .mapToDouble(element -> Double.parseDouble(element.getText().replace("$", "")))
                .max()
                .orElseThrow(() -> new RuntimeException("Unable to find max due value"));

        // Identify the index (row) of the maximum "Due" value
        int indexOfMaxDue = 0;
        for (int i = 0; i < dueValues.length; i++) {
            if (dueValues[i] == maxDueValue) {
                indexOfMaxDue = i + 1; // +1 to match XPath index
                break;
            }
        }

        // Locate the first name and last name based on the row with the max "Due" value
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firstName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 2))).getText();
        String lastName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 1))).getText();

        // Assert that the name is as expected ("Jason Doe" for this example)
        String actualFullName = String.format("%s %s", firstName, lastName);
        String expectedFullName = "Jason Doe"; // Change this to the expected name if it differs
        Assert.assertEquals(actualFullName, expectedFullName, "The person with the max due amount is not as expected.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

