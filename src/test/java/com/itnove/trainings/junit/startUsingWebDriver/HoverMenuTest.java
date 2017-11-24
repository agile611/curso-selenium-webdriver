package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


/**
 * Unit test for simple App.
 */
public class HoverMenuTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        //1
        driver.get("http://opencart.votarem.lu");
        //2
        Actions hover = new Actions(driver);
        List<WebElement> llistaCategories = driver.findElements(By.xpath(".//*[@id='menu']/div[2]/ul/li"));
        System.out.println(llistaCategories.size());
        for (int i = 0; i < llistaCategories.size()-1; i++) {
            WebElement categoriaAIterar = driver.findElement(By.xpath(".//*[@id='menu']/div[2]/ul/li[" + (i + 1) + "]"));
            hover.moveToElement(categoriaAIterar).build().perform();
            ///////
            List<WebElement> llistaElements = driver.findElements(By.xpath(".//*[@id='menu']/div[2]/ul/li[" + (i + 1) + "]/div/div/ul/li"));
            String categoria = null;
            for (int j = 0; j < llistaElements.size(); j++) {
                WebElement elementAIterar = driver.findElement(By.xpath(".//*[@id='menu']/div[2]/ul/li[" + (i + 1) + "]/div/div/ul/li[" + (j + 1) + "]"));
                hover.moveToElement(elementAIterar).build().perform();
                categoria = driver.findElement(By.xpath(".//*[@id='menu']/div[2]/ul/li[" + (i + 1) + "]/a")).getText();
            }
            if (llistaElements.size() > 0) {
                WebElement showAll = driver.findElement(By.xpath(".//*[@id='menu']/div[2]/ul/li[" + (i + 1) + "]/div/a"));
                hover.moveToElement(showAll).build().perform();
                showAll.click();
                WebElement breadcrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='product-category']/ul")));
                assertTrue(driver.findElement(By.xpath(".//*[@id='content']/h2")).getText().equals(categoria));
            }
        }

    }
}
