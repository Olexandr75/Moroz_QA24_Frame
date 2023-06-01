package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageOne extends BasePage {
    public PageOne(WebDriver driver) {
        super(driver);
    }

    public static class Locators{
        public final static By h1Element = By.tagName("h1");
        public final static By labelElement = By.xpath("//div[@class='search-page__box-title']/label");
        public final static By noResultButton = By.xpath("//div[@class='gs-snippet']");
        public final static By titleSearchText = By.xpath("//div[@class='sec-title-holder']/h2");
        public final static By uaLocalisation = By.xpath("//span[text()='UA']");
        public final static By enLocalisation = By.xpath("//span[text()='EN']");
        public final static By ruLocalisation = By.xpath("//span[text()='RU']");
        public final static By searchField = By.xpath("//div[@id='open-search']");
        public final static By searchButton = By.xpath("//span[text()='Пошук']");
        public final static By inputSearch = By.xpath("//input[@placeholder='Пошук...'][1]");
        public final static By chiefSearch =By.xpath("//ul[@class='menu']//li[@id='menu-item-5028573']//a[text()='Шеф']");
        public final static By chiefText = By.xpath("//a[text()='Шеф']");

        public final static By ingred = By.xpath ("//div[@class='col-12 col-md-6']/div/div");

        //public final static By searchButton = By.xpath("//input[@class='header-search__button evinent-search-button']");
        public final static By location = By.xpath("//a[@class ='button user-confirm-location-button']");
    }

    public static class Label{
        public final static String url = "https://klopotenko.com/";
        public final static String receptCarR = "https://klopotenko.com/solodko-yaskravo-aromatno-zapechena-morkva-z-rozmarynom-i-mandarynovym-sokom-vid-yevgena-klopotenka/";
        public  final static String searchMessage = "ЗНАЙДЕНО ЗА ЗАПИТОМ: %s";
    }

    public void searchByText(String text){

        elements.sendKeysToElementBy(Locators.searchField,text);
        elements.clickOnElementBy(Locators.searchButton);


    }
    public void openPage(){
        driver.get(Label.url);

    }
    public void waitForH1Loaded(){
        waiters.waitForVisabilityOfElement(PageOne.Locators.h1Element);
    }
}
