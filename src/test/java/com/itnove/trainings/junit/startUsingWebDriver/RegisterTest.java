package com.itnove.trainings.junit.startUsingWebDriver;

import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.ResultsPage;
import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static junit.framework.TestCase.assertTrue;


/**
 * Unit test for simple App.
 */
public class RegisterTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        //1
        driver.get("http://opencart.votarem.lu");
        //2
        Actions hover = new Actions(driver);
        WebElement ninot = driver.findElement(By.xpath(".//*[@id='top-links']/ul/li[2]/a"));
        hover.moveToElement(ninot).build().perform();
        //3
        ninot.click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath(".//*[@id='top-links']/ul/li[2]/ul")));
         //4
        WebElement register = driver.findElement(By.xpath(".//*[@id='top-links']/ul/li[2]/ul/li[1]/a"));
        hover.moveToElement(register).build().perform();
        //5
        register.click();
        //6
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("content")));
        WebElement registerAccount = driver.findElement(By.id("account-register"));
        assertTrue(registerAccount.isDisplayed());



    }
}
