package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertTrue;

public class HoversTest extends BaseTest {

    @Test
    public void hoversTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Thread.sleep(3000);
        // Find and hover over desired element
        WebElement avatar = driver.findElement(By.className("figure"));
        Actions builder = new Actions(driver);
        builder.moveToElement(avatar).build().perform();
        Thread.sleep(3000);
        // Wait until the hover appears
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("figcaption")));
        Thread.sleep(3000);
        // Assert that the hover displayed
        assertTrue(driver.findElement(By.className("figcaption")).isDisplayed());
        Thread.sleep(3000);

    }
}
