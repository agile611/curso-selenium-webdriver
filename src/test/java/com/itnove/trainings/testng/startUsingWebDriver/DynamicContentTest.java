package com.itnove.trainings.testng.startUsingWebDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertFalse;


/**
 * Dynamic Content from The Internet Heroku App
 */
public class DynamicContentTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_content");
        WebElement imatge1 =
                driver.findElement(
                        By.xpath(".//*[@id='content']/div[3]/div[1]/img"));
        WebElement text1 =
                driver.findElement(
                        By.xpath(".//*[@id='content']/div[3]/div[2]"));
        String urlImatge1 = imatge1.getAttribute("src");
        String texttotal1 = text1.getText();
        driver.navigate().refresh();
        imatge1 =
                driver.findElement(
                        By.xpath(".//*[@id='content']/div[3]/div[1]/img"));
        text1 =
                driver.findElement(
                        By.xpath(".//*[@id='content']/div[3]/div[2]"));
        String urlImatge2 = imatge1.getAttribute("src");
        String texttotal2 = text1.getText();
        assertFalse(urlImatge1.equals(urlImatge2));
        assertFalse(texttotal1.equals(texttotal2));
    }
}
