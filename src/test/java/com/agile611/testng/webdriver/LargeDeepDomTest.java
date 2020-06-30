package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LargeDeepDomTest extends BaseTest {
    /**
     * @param element  element on the page that will be highlighted
     * @param duration the time in second how much the element will be highlighted
     */

    private void highlightElement(WebElement element, int duration) throws InterruptedException {
        // Store original style so it can be reset later
        String original_style = element.getAttribute("style");

        // Style element with a red border
        jse.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                element,
                "style",
                "border: 2px solid red; border-style: dashed;");

        // Keep element highlighted for a spell and then revert
        if (duration > 0) {
            Thread.sleep(duration * 1000);
            jse.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    element,
                    "style",
                    original_style);
        }
    }

    @Test
    public void highlightElementTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/large");
        WebElement element = driver.findElement(By.id("sibling-2.3"));
        highlightElement(element, 3);
    }
}