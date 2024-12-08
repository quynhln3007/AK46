package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import support.Browser;

public class DropDownPage {
    WebDriver driver;
    By dropDown=By.id("dropdown");

    public DropDownPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOption(String option) {
        Select select = new Select(driver.findElement(dropDown));
        select.selectByVisibleText(option);
    }

    public boolean isSelected(String option) {
        return driver.findElement(By.xpath(String.format("//*[@id='dropdown']/option[.='%s']",option))).isSelected();
    }
}
