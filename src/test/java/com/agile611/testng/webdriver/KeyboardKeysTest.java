package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class KeyboardKeysTest extends BaseTest {
    @Test
    public void KeyboardKeysExample() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/key_presses");
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.SPACE).build().perform();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.id("result")).getText().equalsIgnoreCase("You entered: SPACE"));
        builder.sendKeys(Keys.LEFT).build().perform();
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.id("result")).getText().equalsIgnoreCase("You entered: LEFT"));
    }
}