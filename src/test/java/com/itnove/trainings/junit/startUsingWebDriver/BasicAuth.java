package com.itnove.trainings.junit.startUsingWebDriver;

import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.ResultsPage;
import com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage.SearchPage;
import org.junit.Assert;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class BasicAuth extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(5000);

    }
}
