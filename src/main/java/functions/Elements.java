package functions;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Elements {
    static final Logger logger = LoggerFactory.getLogger(Elements.class);
    private final WebDriver driver;
    private final Waiters waiters;

    public Elements(WebDriver driver){
        this.driver=driver;
        waiters = new Waiters(driver);
    }

    public WebElement findSingleElement(By by){
        try {
            waiters.waitVisabilityOfWebElent(by);
            logger.info("trying to find element by locator "+by.toString());
            return driver.findElement(by);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }

    public WebElement findElementByXpath(String xpath){
        try {
            waiters.waitVisabilityOfWebElent(By.xpath(xpath));
            return driver.findElement(By.xpath(xpath));
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean isElementDisplayed(By by) {
        logger.info("Returning boolean of element to be displayed "+isElementDisplayed((By) findElement(by))+".");
        return isElementDisplayed((By) findElement(by));
    }
    public String getTextFromElementXpath(String xpath){
        return  findElementByXpath(xpath).getText();
    }
    public String getTextFromElementBy(By locator){
        logger.info("getting text from element "+locator.toString());
        return  findSingleElement(locator).getText();
    }
    public void clickOnElementByXpath(String xpath){
        findElementByXpath(xpath).click();
    }
    public void clickOnElementBy(By locators){
        logger.info("clicking on Element "+locators.toString());
        findSingleElement(locators).click();
    }
    public void sendKeysToElementWithXpath(String xpath,String text){
        findElementByXpath(xpath).sendKeys(text);
    }
    public void sendKeysToElementBy(By locator,String text){
        findSingleElement(locator).sendKeys(text);
    }
    public boolean isElementSelected(By by) {
        return isElementSelected((by));
    }
    public String getElementText(By by){
        logger.info("Getting text from element with locator "+by.toString()+".");
        return findElement(by).getText();
    }
    public WebElement findElement(By by){
        WebElement element=null;
        try {
            logger.info("Trying to find element with locator "+by.toString()+".");
            waiters.waitForPresentElementLocated(by);
            element=driver.findElement(by);
            return element;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            element=null;
            return element;
        }finally {
            if(element==null){
                logger.error("Can't find element with locator "+by.toString()+".");
            }
        }
    }
    public List<WebElement> findElements(By by){
        List<WebElement> elements=null;
        try {
            logger.info("Trying to find elements with locator "+by.toString()+".");
            waiters.waitForPresentElementLocated(by);
            elements=driver.findElements(by);
            return elements;
        }catch (NoSuchElementException e){
            elements=null;
            return elements;
        }finally {
            if (elements==null){
                logger.error("Can't find element with locator "+by.toString()+".");
            }
        }

    }
}