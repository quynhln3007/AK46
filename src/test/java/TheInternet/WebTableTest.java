package TheInternet;

import TheInternet.pages.WebTablePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.Browser;

import java.util.Comparator;
import java.util.List;

public class WebTableTest {
    WebDriver driver;
    List<Person> tablePerson;

    @BeforeClass
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void tc05() {
        WebTablePage webTablePage=new WebTablePage();
        webTablePage.open();
        Assert.assertEquals(webTablePage.getMaxDuePersonTable1(), "Jason Doe");
    }

    @Test
    void verifyMaxDuePerson() {
        Person maxDuePerson = tablePerson
                .stream()
                .max(Comparator.comparing(Person::getDue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");

    }

    @Test
    void verifyMinDuePerson() {
        Person minDuePerson = tablePerson
                .stream().min(Comparator.comparing(Person::getDue)).get();
        List<String> minDuePersonFullname = tablePerson
                .stream()
                .filter(person -> person.getDue() == minDuePerson.getDue())
                .map(Person::getFullName)
                .toList();
        Assert.assertEquals(minDuePersonFullname, List.of("John Smith", "Tim Conway"));
    }
    @AfterClass
    void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
