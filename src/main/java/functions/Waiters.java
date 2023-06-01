package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.function.Function;

public class Waiters {
    private final WebDriver driver;
    static final Logger logger = LoggerFactory.getLogger(Waiters.class);
    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    private static final long EXPLICITY_WAIT = 25L;

    private FluentWait<WebDriver> fluentWait(Long duration) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(duration))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    private void waitForFunction(Function function, Long timeout) {
        FluentWait<WebDriver> wait = fluentWait(timeout);
        wait.until(function);
    }

    public void waitForVisabilityOfElement(By by) {
        waitForFunction(ExpectedConditions.visibilityOfElementLocated(by), EXPLICITY_WAIT);
    }

    public WebElement waitForVisabilityOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForFrameAndSwitchToIt(By by) {
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
        waitForFunction(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by), EXPLICITY_WAIT);
    }

    public Alert waitForAlertAndSwitchToIt() {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.alertIsPresent());
    }

    public void waitElementToBeClickable(By by) {
        waitForFunction(ExpectedConditions.elementToBeClickable(by), EXPLICITY_WAIT);
    }

    public void waitElementToBeClickable(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeClickable(element), EXPLICITY_WAIT);
    }
    public WebElement waitElementToBeClickableReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitElementToBeClickableReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementToBeSelected(By by) {
        waitForFunction(ExpectedConditions.elementToBeSelected(by), EXPLICITY_WAIT);
    }

    public void waitElementToBeSelected(WebElement element) {
        waitForFunction(ExpectedConditions.elementToBeSelected(element), EXPLICITY_WAIT);
    }

    public void waitElementStateToBe(WebElement element, boolean boo) {
        waitForFunction(ExpectedConditions.elementSelectionStateToBe(element, boo), EXPLICITY_WAIT);
    }

    public void waitVisabilityOfWebElent(WebElement element) {
        waitForFunction(ExpectedConditions.visibilityOf(element), EXPLICITY_WAIT);
    }

    public void waitVisabilityOfWebElent(By by) {
        waitForFunction(ExpectedConditions.visibilityOf(driver.findElement(by)), EXPLICITY_WAIT);
    }

    public WebElement waitVisabilityOfWebElentReturn(WebElement element) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitVisabilityOfWebElentReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    public WebElement waitPresenceOfElementReturn(By by) {
        return fluentWait(EXPLICITY_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitPresenceOfElement(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by), EXPLICITY_WAIT);
    }

    public void waitTitleContainsText(String text) {
        waitForFunction(ExpectedConditions.titleContains(text), EXPLICITY_WAIT);
    }
    public ArrayList<WebElement> waitForPresentElementsLocatedAndReturnArrayList(By by) {
        waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITY_WAIT);
        return new ArrayList<>(driver.findElements(by));}
    public void waitCurrentSeconds(int seconds){
        logger.info("Waiting for "+seconds+" seconds");
        int miliseconds = seconds*1000;
        try {
            Thread.sleep(miliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

        public void waitForPresentElementLocated(By by) {
            waitForFunction(ExpectedConditions.presenceOfElementLocated(by),EXPLICITY_WAIT);
        }
    public WebElement waitForPresenceOfElementLocated(By by){
        return fluentWait(EXPLICITY_WAIT)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
