package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


/**
 * Unit test for simple App.
 */
public class SearchTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        String cerca = "apple";
        //1
        driver.get("http://opencart.votarem.lu");
        //2
        WebElement searchInput = driver.findElement(By.xpath(".//*[@id='search']/input"));
        searchInput.click();
        searchInput.sendKeys(cerca);
        //searchInput.submit();
        WebElement lupa = driver
                .findElement(By.xpath(".//*[@id='search']/span/button"));
        //hover.moveToElement(lupa).build().perform();
        lupa.click();
        String breadCrumbCerca = ".//*[@id='product-search']/ul";
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath(breadCrumbCerca)));
        WebElement searchCriteria =
                driver.findElement(By.xpath(".//*[@id='content']/h1"));
        String keyword = searchCriteria.getText();
        assertTrue(keyword.contains(cerca));
        WebElement inputSearch = driver.findElement(By.id("input-search"));
        assertTrue(inputSearch.getAttribute("value").contains(cerca));


        List<WebElement> resultats =
                driver.findElements(By.xpath(".//*[@id='content']/div[3]/div"));

        for (int i = 0; i < resultats.size(); i++) {
            WebElement titol = driver
                    .findElement(By
                            .xpath(".//*[@id='content']/div[3]/div[" + (i + 1) + "]/div/div[2]/div[1]/h4/a"));
            assertTrue(titol.getText().toLowerCase().contains(cerca));
        }

    }
}
