import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PageTwo;

import static org.testng.Assert.assertEquals;

public class PageTwoTests extends BaseTest {
    @BeforeClass
    public void acceptCookies() {
        twoPage.openPage();
        waiters.waitForPresentElementLocated(By.xpath("//a[@aria-label= 'dismiss cookie message']"));
        driver.findElement(By.xpath("//a[@aria-label= 'dismiss cookie message']")).click();
    }
    @Test
    public void checkHeader() {
        twoPage.openPage();
        twoPage.HeaderTitle();

    }

    @Test
    public void TitleOfNewRecept() {
        twoPage.openPage();

        assertions.elementHaveText(PageTwo.Locators.novRecept,PageTwo.Labels.title);

    }

    @Test
    public void checkPageTitle() {
        twoPage.openPage();
        assertions.asserPageTitle(PageTwo.Labels.pageTitle);
    }



    @Test
    public void countHeadElements() {
        twoPage.openPage();
        assertions.listSizeIsEqual(elements.findElements(PageTwo.Locators.listOfElements2),8);
    }
}

