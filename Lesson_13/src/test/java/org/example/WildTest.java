package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildTest extends HomePage {
    private String nameOneFirstPage;
    private String nameTwoFirstPage;
    private String nameOneBasket;
    private String nameTwoBasket;
    private int firstPrice;
    private int secondPrice;
    private int priseTotal;

    @Test
    public void test() {

        addToBasket();
        nameOneFirstPage = driver.findElement(productNameOne).getText().substring(2).trim();
        nameTwoFirstPage = driver.findElement(productNameTwo).getText().substring(2).trim();
        driver.findElement(basketClick).click();
        nameOneBasket = driver.findElement(getProductNameFirst).getAttribute("innerText").trim();
        nameTwoBasket = driver.findElement(getProductNameSecond).getAttribute("innerText").trim();

        assertEquals(nameOneFirstPage, nameOneBasket);
        assertEquals(nameTwoFirstPage, nameTwoBasket);

    }

    @Test
    void checkQuantity() {
        addToBasket();
        BasketBtn();
        assertEquals("2", driver.findElement(getQuantity).getAttribute("childElementCount"));

    }
    @Test
    void checkPrice() throws InterruptedException {
        addToBasket();
        BasketBtn();
        Thread.sleep(2000);
        firstPrice = Integer.parseInt(driver.findElement(sellFirst)
                .getText().replaceAll("[^0-9]", ""));
        secondPrice = Integer.parseInt(driver.findElement(sellSecond)
                .getText().replaceAll("[^0-9]", ""));
        priseTotal = Integer.parseInt(driver.findElement(priseTotalBasket)
                .getText().replaceAll("[^0-9]", ""));
        assertEquals((firstPrice + secondPrice), priseTotal);
    }
}