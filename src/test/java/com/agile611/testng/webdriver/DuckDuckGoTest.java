package com.agile611.testng.webdriver;

import com.agile611.testng.webdriver.pages.ResultsPage;
import com.agile611.testng.webdriver.pages.SearchPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class DuckDuckGoTest extends BaseSaucelabsTest {
    @Test //El propio test que hemos exportado de Katalon IDE
    public void testUntitledTestCase() throws Exception {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchKeyword("pizza hawaiana");
        ResultsPage resultsPage = new ResultsPage(driver);
        assertTrue(resultsPage.isResultsPagePresent());
    }
}


