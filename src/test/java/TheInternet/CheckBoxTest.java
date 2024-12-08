package TheInternet;

import TheInternet.pages.CheckBoxPage;
import TheInternet.pages.Checkbox;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import support.Browser;

public class CheckBoxTest {

    @BeforeClass
    void setUp(){
        Browser.openBrowser("chrome");
    }


    @Test
    void ableToSelectCheckBox() {
        CheckBoxPage checkBoxPage=new CheckBoxPage();
        checkBoxPage.open();
        checkBoxPage.selectCheckBox(Checkbox.CHECKBOX_1);
      //  WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
      /*  if (!checkbox1.isSelected()) {
            checkbox1.click();
        }*/
        Assert.assertTrue(checkBoxPage.isChecked(Checkbox.CHECKBOX_1));
       /* WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }*/
        checkBoxPage.selectCheckBox(Checkbox.CHECKBOX_2);

        Assert.assertTrue(checkBoxPage.isChecked(Checkbox.CHECKBOX_2));
    }

}
