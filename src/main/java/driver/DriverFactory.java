package driver;

import functions.ActionClass;
import functions.Assertions;
import functions.Elements;
import functions.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private static final long IMPLICITY_WAIT= 20l;
    static Waiters waiters;
    static ActionClass action;
    static Assertions assertions;
    static Elements elements;
    private static WebDriver driver;

    private static WebDriver setUpDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);

        waiters = new Waiters(driver);
        elements = new Elements(driver);
        action = new ActionClass(driver);
        assertions = new Assertions(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITY_WAIT, TimeUnit.SECONDS);
        return driver;
    }

    private static WebDriver getInstance(){
        if (driver == null) {
            try{
                driver= setUpDriver();
            }catch (Exception e){
                e.printStackTrace();
            }
        }return driver;
    }

    public static WebDriver startChromeDriver(){
        logger.info("Trying to start driver");
        driver = getInstance();
        return driver;
    }

}
