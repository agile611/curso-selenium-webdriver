package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class NestedFramesTest extends BaseTest {

    public void listIframesFromPage(WebDriver driver) {
        final List<WebElement> iframes = driver.findElements(By.tagName("frame"));
        for (WebElement iframe : iframes) {
            System.out.println(iframe.getAttribute("id"));
            System.out.println(iframe.getAttribute("name"));
        }
    }

    @Test
    public void testApp() {
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        listIframesFromPage(driver);
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        listIframesFromPage(driver);
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("html/body")).getText());
    }
}