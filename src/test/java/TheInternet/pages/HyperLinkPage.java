package TheInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.Browser;

public class HyperLinkPage {
    WebDriver driver;

    public HyperLinkPage() {
        this.driver = Browser.getDriver();
    }

    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void clickHyperLink(String hyperlink) {
        Browser.click(By.linkText(hyperlink));
    }

    public boolean isPageURLContain(String hyperlink) {
        return Browser.getCurrentUrl().contains(String.format("https://the-internet.herokuapp.com/status_codes/%s", hyperlink));
    }
}
