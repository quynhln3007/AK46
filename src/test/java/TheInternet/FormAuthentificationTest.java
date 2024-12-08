package TheInternet;


import TheInternet.pages.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.*;
import support.Browser;

public class FormAuthentificationTest {
    @BeforeMethod
    void setUp(){
        Browser.openBrowser("chrome");
    }
    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!","https://the-internet.herokuapp.com/secure","success", "You logged into a secure area!"},
                {"quynhle", "SuperSecretPassword!","https://the-internet.herokuapp.com/login","error", "Your username is invalid!"},
                {"tomsmith", "SuperSecretPassword","https://the-internet.herokuapp.com/login","error", "Your password is invalid!"},

        };
    }
    @Test(dataProvider = "testData")
    void verifyLoginFunction(String username, String password,String expectedURL,String expectedMessageType,String expectedMessageContent) {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open();
        formAuthenticationPage.login(username, password);
        //verify current url
        Assert.assertEquals(Browser.getCurrentUrl(), expectedURL);
        //verify message
        Assert.assertTrue(formAuthenticationPage.verifyMessageContent(expectedMessageType,expectedMessageContent));
    }
    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}




