package com.agile611.testng.webdriver;

import org.testng.annotations.Test;

public class BasicAuth extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);

    }
}
