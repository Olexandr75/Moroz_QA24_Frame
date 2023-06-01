import functions.Waiters;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.PageOne;
import pages.PageThree;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageOneTest extends BaseTest{


    @Test
    public void notRedirect() {
        onePage.openPage();
        WebElement element = waiters.waitPresenceOfElementReturn(PageOne.Locators.chiefSearch);
        element.click();
        waiters.waitPresenceOfElement(PageOne.Locators.chiefText);
        assertEquals(driver.getCurrentUrl(), "https://klopotenko.com/pro-nas/", "Невірний перехід на сторінку");
        driver.quit();
    }


    @Test
    public void countResIngredients() {
        driver.get(PageOne.Label.receptCarR);
        (new Waiters(driver)).waitForVisabilityOfElement(PageOne.Locators.ingred);
        List<WebElement> elements = driver.findElements(PageOne.Locators.ingred);
        assertTrue(elements.size() == 5, "Кількість складових не дорівнює 5, їх є  "
                + elements.size());
    }
    @Test
    public void SearchResultsPositiv() {
        String searchWord = "soup";
        onePage.openPage();
        action.clickOnElement(PageOne.Locators.searchButton);
        action.enterTextAndSubmit(searchWord,PageOne.Locators.inputSearch);
        String resultText = String.format(PageOne.Label.searchMessage,searchWord).toUpperCase();
        assertions.elementHaveText(PageThree.Locators.titleSearchText,resultText);
    }
    @Test
    public void SearchResultNegative() {
        String searcWord = "fdghyt";
        onePage.openPage();
        action.clickOnElement(PageOne.Locators.searchField);
        waiters.waitForPresentElementLocated(PageOne.Locators.searchField);
        action.enterTextAndSubmit(searcWord,PageOne.Locators.inputSearch);
        String resultText = String.format(PageOne.Label.searchMessage,searcWord).toUpperCase();
        assertions.elementHaveText(PageOne.Locators.titleSearchText,resultText);
        assertions.elementIsDisplayed(PageOne.Locators.noResultButton);
        assertions.elementHaveText(PageOne.Locators.noResultButton,"Результатів немає");
    }
    @Test
    public void Localisation() {
        onePage.openPage();
        action.clickOnElement(PageOne.Locators.uaLocalisation);
        assertions.elementIsDisplayed(PageOne.Locators.uaLocalisation);
        action.clickOnElement(PageOne.Locators.enLocalisation);
        assertions.elementIsDisplayed(PageOne.Locators.enLocalisation);
        action.clickOnElement(PageOne.Locators.ruLocalisation);
        assertions.elementIsDisplayed(PageOne.Locators.ruLocalisation);
    }
}


