package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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
        WebElement cookiesButton = driver.findElement(By.xpath("//button[contains(@class,'cookie__cancel')][text()='Отклонить']"));
        cookiesButton.click();
        WebElement phoneNumber = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        WebElement sumInput = driver.findElement(By.xpath("//*[@id='connection-sum']"));
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='connection-email']"));
        WebElement button = driver.findElement(By.xpath("//*[@id='pay-connection']/button[contains(text(),'Продолжить')]"));
        phoneNumber.sendKeys("297777777");
        sumInput.sendKeys("10");
        emailInput.sendKeys("get@yandex.ru");
        button.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class, 'bepaid-iframe')]")));

        WebElement payment = driver.findElement((By.xpath("//p[@class='header__payment-amount']")));
        String actualPaymentAmount = payment.getAttribute("textContent").trim();
        String expectedPaymentAmount = "10.00 BYN";
        Assertions.assertEquals(expectedPaymentAmount, actualPaymentAmount);

        WebElement button2 = driver.findElement(By.xpath("//button[contains(@class, 'colored')]"));
        String buttonText = button2.getAttribute("textContent").trim();
        Assertions.assertEquals("Оплатить  10.00 BYN", buttonText);

        WebElement paymentInfoElement = driver.findElement(By.cssSelector("p.header__payment-info"));
        String paymentInfoText = paymentInfoElement.getAttribute("textContent").trim();
        String phone = "375297777777";
        assertTrue(paymentInfoText.contains(phone));

        checkTextPay("Имя держателя (как на карте)");
        checkTextPay("Номер карты");
        checkTextPay("Срок действия");
        checkTextPay("CVC");

        List<WebElement> iconElements = driver.findElements(By.cssSelector(".cards-brands img"));
        assertEquals(5, iconElements.size());

        driver.switchTo().parentFrame();

        List<String> connection = Arrays.asList("Номер телефона", "Сумма", "E-mail для отправки чека");
        List<String> internet = Arrays.asList("Номер абонента", "Сумма", "E-mail для отправки чека");
        List<String> instalment = Arrays.asList("Номер счета на 44", "Сумма", "E-mail для отправки чека");
        List<String> arrears = Arrays.asList("Номер счета на 2073", "Сумма", "E-mail для отправки чека");

        checkText("pay-connection",connection);
        checkText("pay-internet",internet);
        checkText("pay-instalment",instalment);
        checkText("pay-arrears",arrears);
    }

    private void checkTextPay(String label) {
        WebElement labelElement = driver.findElement(By.xpath("//label[contains(text(),'" + label + "')]"));
        String labelText = labelElement.getAttribute("textContent").trim();
        Assertions.assertEquals(label, labelText);
    }

    private void checkText(String formId,List<String> textPlaceholders) {
        WebElement form = driver.findElement(By.id(formId));
        List<WebElement> textFields = form.findElements(By.tagName("input"));
        for (WebElement inputField : textFields) {
            String placeholder = inputField.getAttribute("placeholder");
            if (!placeholder.isEmpty()) {
                assertTrue(textPlaceholders.contains(placeholder));
            }
        }
    }
}
