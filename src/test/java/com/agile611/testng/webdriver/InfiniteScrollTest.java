package com.agile611.testng.webdriver;

import org.testng.annotations.Test;

public class InfiniteScrollTest extends BaseTest {
    @Test
    public void infiniteScrollTest() throws InterruptedException {
        driver.navigate().to("http://the-internet.herokuapp.com/infinite_scroll");
        for (int i = 0; i < 5; i++) {
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(2500);
        }
    }
}