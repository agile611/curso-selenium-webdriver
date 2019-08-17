package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        //1 Navegar hasta la página
        driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
        //2 Mirar que el checkbox2 está marcado
        WebElement checkbox2 =
                driver.findElement(By.xpath(".//*[@id='checkboxes']/input[2]"));
        assertTrue(checkbox2.getAttribute("checked").equals("true"));
        //2.1 Mirar el checkbox1 que NO está marcado
        WebElement checkbox1 =
                driver.findElement(By.xpath(".//*[@id='checkboxes']/input[1]"));
        assertNull(checkbox1.getAttribute("checked"));
        //3 Marcar checkbox1
        checkbox1.click();
        //4 Mirar que ha quedado marcado
        assertTrue(checkbox1.getAttribute("checked").equals("true"));
    }
}