import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageThree;

import static org.testng.Assert.assertFalse;

public class PageThreeTests extends BaseTest {
    @BeforeClass
    public void acceptCookies() {
        threePage.openPage();
        waiters.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
    }



    @Test
    public void checkBoxWorkActual(){
        threePage.openPage();
        assertions.elementIsNotSelected(PageThree.Locators.checkBoxDisabled);
        waiters.waitCurrentSeconds(2);
        threePage.closePopUp();
        action.clickOnElement(PageThree.Locators.checkBoxDisabled);
        assertions.elementIsDisplayed(PageThree.Locators.checkBoxEnabled);
        assertions.elementIsNotSelected(PageThree.Locators.checkBoxEnabled);
        action.clickOnElement(PageThree.Locators.checkBoxEnabled);
        assertions.elementIsNotSelected(PageThree.Locators.checkBoxDisabled);
    }

    @Test
    public void colorOfLoginButton(){
        threePage.openPage();
        String backgroundButton ="rgba(17, 107, 75, 1)";
        assertions.checkCssValue(PageThree.Locators.logInButton,"background-color",backgroundButton);
    }
    @Test
    public void facebookIsDisplayed(){
        threePage.openPage();
        assertions.elementIsDisplayed(PageThree.Locators.logInButton);
    }
    @Test
    public void CheckBoxofCheck() {
        threePage.openPage();
        WebElement checkbox = (new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']")));

        assertFalse(checkbox.isSelected(), "Чекбокс нажат");
        checkbox.click();
        WebElement newCheckBox = (new Waiters(driver).waitForPresenceOfElementLocated(By.xpath("//i[@class='um-icon-android-checkbox-outline']")));
        (new Waiters(driver)).waitForVisabilityOfElement(By.xpath("//i[@class='um-icon-android-checkbox-outline']"));
        assertFalse(newCheckBox.isSelected(), "Чекбокс нажат");
        newCheckBox.click();
        assertFalse(checkbox.isSelected(), "Чекбокс нажат");
    }
}
