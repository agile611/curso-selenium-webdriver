package com.itnove.trainings.testng.startUsingWebDriver;

import org.testng.annotations.Test;


/**
 * Basic Auth from the Internet
 */
public class BasicAuth extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);

    }
}
