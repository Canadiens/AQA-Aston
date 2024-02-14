package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;


public class HomePage {
    public static WebDriver driver;
    public static By productLocatorOne = By.xpath("//article[@data-card-index='0']");
    public static By productLocatorTwo = By.xpath("//article[@data-card-index='1']");
    public static By addBasket = By.xpath("//a[@class='product-card__add-basket j-add-to-basket btn-main']");
    public By productNameOne = By.xpath("//article[@data-card-index='0']//span[@class='product-card__name']");
    public By productNameTwo = By.xpath("//article[@data-card-index='1']//span[@class='product-card__name']");
    public By basketClick = By.xpath("//span[@class='navbar-pc__icon navbar-pc__icon--basket']");
    public By getProductNameSecond = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][1]" + "//span[@class='good-info__good-name']");
    public By getProductNameFirst = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][2]" + "//span[@class='good-info__good-name']");
    public By getQuantity = By.xpath("//div[@class='b-top__count line']");
    public By sellFirst = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][1]" + "//div[@class='list-item__price-new']");
    public By sellSecond = By.xpath("//div[@class='accordion__list-item list-item j-b-basket-item'][2]" + "//div[@class='list-item__price-new']");
    public By priseTotalBasket = By.xpath("//div[@class='basket-order__b-top b-top']//span//span");

    @BeforeEach
    public void setUp() {
        EdgeOptions options = new EdgeOptions().addArguments("--start-maximized");
        driver = new EdgeDriver(options);
        driver.get("https://www.wildberries.ru/");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));
    }

    public static void addToBasket() {

        WebElement product1 = driver.findElement(productLocatorOne);
        new Actions(driver).moveToElement(product1).perform();
        driver.findElement(addBasket).click();
        WebElement product2 = driver.findElement(productLocatorTwo);
        new Actions(driver).moveToElement(product2).perform();
        driver.findElement(addBasket).click();

    }

    public void BasketBtn() {
        driver.findElement(basketClick).click();
    }

    @AfterEach
  public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}