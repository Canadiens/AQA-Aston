package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PixelTest {

    AndroidDriver<AndroidElement> driver = null;

    @BeforeEach
    public void setUp() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkSum() {
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("11", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    void checkDeduction() {
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/op_sub").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("3", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    void checkMultiplying() {
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/op_mul").click();
        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("81", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @Test
    void checkDividing() {
        driver.findElementById("com.google.android.calculator:id/digit_1").click();
        driver.findElementById("com.google.android.calculator:id/digit_6").click();
        driver.findElementById("com.google.android.calculator:id/op_div").click();
        driver.findElementById("com.google.android.calculator:id/digit_2").click();
        driver.findElementById("com.google.android.calculator:id/eq").click();
        assertEquals("8", driver.findElementById("com.google.android.calculator:id/result_final").getText());
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
}
