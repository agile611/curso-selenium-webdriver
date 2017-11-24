package com.itnove.trainings.testng.startUsingWebDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Challengin Dom from the Internet Heroku App
 */
public class ChallengingDomTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/challenging_dom");
        List<WebElement> botons =
                driver.findElements(
                        By.xpath(".//div[@class='example']/div/div/div[1]/a"));
        for (int i = 0; i < botons.size(); i++) {
            WebElement botonDeTurno =
                    driver.findElement(
                            By.xpath(".//div[@class='example']/div/div/div[1]/a[" + (i + 1) + "]"));
            botonDeTurno.click();
        }
    }
}
