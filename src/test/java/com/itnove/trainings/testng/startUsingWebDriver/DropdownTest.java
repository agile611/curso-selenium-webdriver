package com.itnove.trainings.testng.startUsingWebDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Drop Down from the Internet Heroku App
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
