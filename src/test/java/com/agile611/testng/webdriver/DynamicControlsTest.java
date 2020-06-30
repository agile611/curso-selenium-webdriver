package com.agile611.testng.webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void titleTest() {
        driver.navigate().to("http://the-internet.herokuapp.com/dynamic_controls");
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        assertTrue(checkbox.isDisplayed());
        checkbox.click();
        WebElement removeBtn = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
        removeBtn.click();
        List<WebElement> loading = driver.findElements(By.xpath("//*[@id='loading']/img"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(By.id("loading")),
                ExpectedConditions.presenceOfElementLocated(By.id("message"))));
    }
}