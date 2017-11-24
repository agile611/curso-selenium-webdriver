package com.itnove.trainings.testng.startUsingWebDriver;

import com.itnove.trainings.testng.startUsingWebDriver.pages.searchPage.ResultsPage;
import com.itnove.trainings.testng.startUsingWebDriver.pages.searchPage.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Initial example appTest
 */
public class AppTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("http://www.duckduckgo.com");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchKeyword("Hawaiian pizza");
        Thread.sleep(2000);
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsListPresent());
        resultsPage.clickOnFirstResult();
        Thread.sleep(2000);
        Assert.assertTrue(!driver.getCurrentUrl().contains("duckduckgo"));
    }
}
