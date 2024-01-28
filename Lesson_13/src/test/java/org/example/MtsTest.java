package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testMts() {
        driver.get("https://mts.by");

        WebElement nameBlock = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн пополнение ')]"));
        assertTrue(nameBlock.isDisplayed());

        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']//img[@alt='Visa' or @alt='Verified By Visa' or @alt='MasterCard' or @alt='MasterCard Secure Code' or @alt='Белкарт' or @alt='МИР']"));
        assertEquals(6, logos.size());

        WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(@class,'cookie__cancel')][text()='Отклонить']"));
        cookiesButton.click();
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        WebElement sumInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='connection-email']"));
        WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button[contains(text(),'Продолжить')]"));
        WebElement link = driver.findElement(By.xpath("//a[@href='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']"));
        phoneNumber.sendKeys("297777777");
        sumInput.sendKeys("10");
        emailInput.sendKeys("get@yandex.ru");
        button.click();
        driver.get(link.getAttribute("href"));
    }
}