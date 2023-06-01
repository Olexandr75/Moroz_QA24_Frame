package pages;

import functions.ActionClass;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static WebDriver driver;
    static Waiters waiters;
    static ActionClass action;
    static Assertions assertions;
    static Elements elements;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        waiters = new Waiters(driver);
        assertions = new Assertions(driver);
        action = new ActionClass(driver);
        elements = new Elements(driver);
    }
}
