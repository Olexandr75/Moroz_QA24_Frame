package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageThree extends BasePage{
    public PageThree (WebDriver driver) {
        super(driver);}

        public static class Locators {

            public final static By loginField = By.xpath("//input[@id='username-5035946']");
            public final static By passwordField = By.xpath("//input[@id='user_password-5035946']");
            public final static By checkBoxDisabled = By.xpath("//i[@class='um-icon-android-checkbox-outline-blank']");
            public final static By checkBoxEnabled = By.xpath("//i[@class='um-icon-android-checkbox-outline']");

            public final static By logInButton = By.xpath("//input[@type='submit']");
            public final static By registrationButton = By.xpath("//a[@class='um-button um-alt']");
            public final static By forgotPassButton = By.xpath("//a[@class='um-link-alt']");
            public final static By alertName = By.xpath("//p[@class='um-notice err um-error-code-invalid_username']");
            public final static By alertPassword = By.xpath("//div[@class='um-field-error']");
            public final static By popUpcross = By.xpath("//a[@id='catfish-close']");
            public final static By facebookButton = By.xpath("//i[@class='um-faicon-facebook-square']");
            public final static By searchButton = By.xpath("//span[text()='Пошук']");
            public final static By inputSearch = By.xpath("//input[@placeholder='Пошук...'][1]");
            public final static By submitButton = By.xpath("//button[@type='submit'][1]");
            public final static By titleSearchText = By.xpath("//div[@class='sec-title-holder']/h2");
            public final static By noResultButton = By.xpath("//div[@class='gs-snippet']");
            public final static By location = By.xpath("//a[@class ='button user-confirm-location-button']");


        }
    public void closePopUp(){
            waiters.waitForPresentElementLocated(Locators.popUpcross);
            driver.findElement(Locators.popUpcross).click();
        }

        public static class Labels {
            public static final String pisniiStil = "ПІСНИЙ СТІЛ";
            public static final String straviNaVelikDen = "СТРАВИ НА ВЕЛИКДЕНЬ";
            public static final String ukrainkaKuchnia = "УКРАЇНСЬКА КУХНЯ";
            public static final String recepty = "РЕЦЕПТИ";
            public static final String forFalseAsserts = "Просто слова";
            public static final String errorNameMessage = "Error: The username %s is not registered " +
                    "on this site. If you are unsure of your username, try your email address instead.";
            public static final String errorPassMessage = "Пароль невірний. Спробуйте ще раз";
            public static final String searchMessage = "ЗНАЙДЕНО ЗА ЗАПИТОМ: %s";
            public final static String url = "https://klopotenko.com/login/";

        }

        public void openPage(){
            driver.get(Labels.url);



    }}


