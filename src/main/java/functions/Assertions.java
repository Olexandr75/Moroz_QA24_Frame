package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.testng.Assert.*;


public class Assertions {
    private final Elements elements;
    private final ActionClass actions;
    private final WebDriver driver;
    private final Waiters waiters;

    public Assertions(WebDriver driver) {
        this.driver = driver;
        elements = new Elements(driver);
        actions = new ActionClass(driver);
        waiters = new Waiters(driver);
    }

    public void elementIsDisplayed(By by) {
        assertTrue(elements.isElementDisplayed(by), "Элемент не отображается, хотя должен был");
    }

    public void equalsOfElementAndLabelText(String xpathOfElement, String expectedString) {
        assertEquals(elements.getTextFromElementXpath(xpathOfElement), expectedString,
                "Я ожидал получить " + expectedString + ". А получил " + elements.getTextFromElementXpath(xpathOfElement));
    }

    public void equalsOfStrings(String actualString, String expectedString) {
        assertEquals(actualString, expectedString,
                "Я ожидал получить " + expectedString + ". А получил " + actualString);
    }

    public void elementHaveText(By by, String text){
        elementIsDisplayed(by);
        equals(elements.getElementText(by),text);

    }
    public void equals(String actualValue, String expectedValue){
        assertEquals(actualValue,expectedValue,"Expected value "+expectedValue
                +" doesn't match actual value "+actualValue);}
    public void listSizeIsEqual(List<?> elements, int expectedSize){
        assertEquals(elements.size(),expectedSize,"Size of list doesn't equal to "+expectedSize);
    }
    public void asserPageTitle(String pageTitle){
        assertEquals(driver.getTitle(),pageTitle, "Page Title doesn't match expected");
    }
    public  void elementIsNotSelected(By by){
        assertFalse(elements.isElementSelected(by));
    }

    public  void checkCssValue(By by, String cssName, String cssExpectedValue){
        assertEquals(elements.findElement(by).getCssValue(cssName),cssExpectedValue);
    }



}
