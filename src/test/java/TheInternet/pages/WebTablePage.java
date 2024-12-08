package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import support.Browser;

import java.util.List;

public class WebTablePage {
    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/tables");
    }

    public List<WebElement> getTable1() {
        return Browser.getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
    }

    public String getMaxDuePersonTable1() {
        double[] dueValue = Browser
                .getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .toArray();

        double maxDueValue = Browser
                .getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for (int i = 0; i < dueValue.length; i++) {
            if (dueValue[i] == maxDueValue) {
                indexOfMaxDue = i + 1;
            }
        }
        System.out.println(indexOfMaxDue);
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firsName = Browser.getText(By.xpath(String.format(cellLocator, indexOfMaxDue, 2))); // 2 -> cot firstName
        String lastName = Browser.getText(By.xpath(String.format(cellLocator, indexOfMaxDue, 1))); // 1 -> cot lastName
        Assert.assertEquals(String.format("%s %s", firsName, lastName), "Jason Doe");
        return String.format("%s","%s",firsName,lastName);

    }
}
