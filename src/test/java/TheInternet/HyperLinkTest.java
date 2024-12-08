package TheInternet;

import TheInternet.pages.HyperLinkPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import support.Browser;

public class HyperLinkTest {
    @BeforeMethod
    void setUp() {
        Browser.openBrowser("chrome");
    }

    @Test
    void tc04() {
        HyperLinkPage hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();
        hyperLinkPage.clickHyperLink("200");
        Assert.assertTrue(hyperLinkPage.isPageURLContain("200"));
        hyperLinkPage.clickHyperLink("here");
        hyperLinkPage.clickHyperLink("301");
        Assert.assertTrue(hyperLinkPage.isPageURLContain("301"));
        hyperLinkPage.clickHyperLink("here");
        hyperLinkPage.clickHyperLink("404");
        Assert.assertTrue(hyperLinkPage.isPageURLContain("404"));
        hyperLinkPage.clickHyperLink("here");
        hyperLinkPage.clickHyperLink("500");
        Assert.assertTrue(hyperLinkPage.isPageURLContain("500"));
    }
        @AfterMethod
        void tearDown(){

            Browser.quit();
        }
    }

