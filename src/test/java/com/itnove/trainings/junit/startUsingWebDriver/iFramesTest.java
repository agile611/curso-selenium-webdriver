package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


/**
 * Unit test for simple App.
 */
public class iFramesTest extends BaseTest {

    public void listIframesFromPage(WebDriver driver) {
        final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("id"));
            System.out.println(iframe.getAttribute("name"));
        }
    }

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        listIframesFromPage(driver);
        driver.switchTo().frame("mce_0_ifr");
        WebElement editor = driver.findElement(By.xpath(".//*[@id='tinymce']"));
        hover.moveToElement(editor).click().build().perform();
        editor.clear();
        editor.sendKeys("Podem agafar menjar els de la de Media?");
        Thread.sleep(3000);
    }
}
