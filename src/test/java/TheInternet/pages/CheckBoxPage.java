package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Browser;

public class CheckBoxPage {
    WebDriver driver;

    public CheckBoxPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public void selectCheckBox(Checkbox checkBox) {
        Browser.check(By.cssSelector(checkBox.getSelector()));
    }

    public void unSelectCheckBox(Checkbox checkBox) {
        Browser.check(By.cssSelector(checkBox.getSelector()));

    }

    public boolean isChecked(Checkbox checkBox) {
        return Browser.isSelected(By.cssSelector(checkBox.getSelector()));
    }

}
