package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("http://compendiumdev.co.uk/selenium/testpages/gui_user_interactions.html");
        WebElement draggable1 = driver.findElement(By.xpath(".//*[@class='draganddrops']/div/div[1]"));
        WebElement draggable2 = driver.findElement(By.id("draggable2"));
        WebElement droppable1 = driver.findElement(By.id("droppable1"));
        WebElement droppable2 = driver.findElement(By.id("droppable2"));

        Actions dragAndDrop = new Actions(driver);
        dragAndDrop.dragAndDrop(draggable1, droppable1).perform();
        Thread.sleep(4000);
        dragAndDrop.dragAndDrop(draggable2, droppable2).perform();
        Thread.sleep(4000);


        /*
        dragAndDrop
                .clickAndHold(draggable2)
                .moveToElement(droppable1)
                .release().build().perform();
        Thread.sleep(4000);
        dragAndDrop
                .clickAndHold(draggable2)
                .moveToElement(droppable2)
                .release().build().perform();
        Thread.sleep(4000);
        */
    }
}