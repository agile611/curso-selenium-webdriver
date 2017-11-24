package com.itnove.trainings.junit.startUsingWebDriver;

import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.ResultsPage;
import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.SearchPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Unit test for simple App.
 */
public class DropdownTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver
                .navigate().to("https://the-internet.herokuapp.com/dropdown");
        List<WebElement> options =
                driver.findElements(By.xpath(".//*[@id='dropdown']/option"));
        for (int i = 1; i < options.size(); i++) {
            WebElement option =
                    driver.findElement(
                            By.xpath(".//*[@id='dropdown']/option[" + (i + 1) + "]"));
            option.click();
        }
    }
}
