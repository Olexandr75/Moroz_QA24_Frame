package pages;

import functions.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class PageTwo extends BasePage{
    public PageTwo(WebDriver driver) {
        super(driver);
    }



    public static class Labels {
        public static final String pisniiStil = "ПІСНИЙ СТІЛ";
        public static final String straviNaVelikDen = "СТРАВИ НА ВЕЛИКДЕНЬ";
        public static final String ukrainkaKuchnia = "УКРАЇНСЬКА КУХНЯ";
        public static final String recepty = "РЕЦЕПТИ";
        public static final String porady = "ПОРАДИ";
        public static final String noviny = "НОВИНИ";
        public static final String shef = "ШЕФ";
        public static final String magazin = "МАГАЗИН";
        public static final String title = "НОВІ РЕЦЕПТИ";
        public static final String pageTitle = "Євген Клопотенко - Кулінарні рецепти від Євгена Клопотенка";
        public final static String url = "https://klopotenko.com/";
    }

   public static class Locators {
        public final static By cookies = By.xpath("//a[@aria-label= 'dismiss cookie message']");
       public  final static By uaLocalisation = By.xpath("//span[text()='UA']");
       public  final static By enLocalisation = By.xpath("//span[text()='EN']");
       public  final static By ruLocalisation = By.xpath("//span[text()='RU']");
       public  final static By novRecept = By.xpath("//h2[@class='rtin-title'][1]");
       public  final static By listOfElements2 = By.xpath("//ul[@id='menu-main_menu_our-ua-1']");
       public final static By location = By.xpath("//a[@class ='button user-confirm-location-button']");


    }

    public void openPage(){
        driver.get(Labels.url);
          }
    public void HeaderTitle(){
        ArrayList<WebElement> headerTitles = waiters.waitForPresentElementsLocatedAndReturnArrayList(
        Locators.listOfElements2);
        System.out.println(headerTitles.size());
        ArrayList<String> labels = new ArrayList<>(Arrays.asList(
                Labels.pisniiStil,
                Labels.straviNaVelikDen,
                Labels.ukrainkaKuchnia,
                Labels.recepty,
                Labels.porady,
                Labels.noviny,
                Labels.shef,
                Labels.magazin
        ));
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        for (int i = 0; i < headerTitles.size(); i++) {
            assertEquals(headerTitles.get(i).getText(), labels.get(i));
        }
    }

    }