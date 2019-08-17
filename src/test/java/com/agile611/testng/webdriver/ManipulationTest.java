package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ManipulationTest extends BaseSaucelabsTest {
    @Test //Opciones de Navegación
    public void testNavigation() throws Exception {
        driver.get("https://www.duckduckgo.com/"); //Navegar hasta duckduckgo
        driver.findElement(By.id("search_form_input_homepage")).clear(); //Limpiar el text box
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("pizza hawaiana"); //Escribir en el text box
        driver.findElement(By.id("search_form_homepage")).submit(); //Submit, darle al enter.
        Thread.sleep(2000); //Espera forzada

        driver.get("https://www.duckduckgo.com/"); //Navegar hasta duckduckgo
        driver.findElement(By.id("search_form_input_homepage")).clear(); //Limpiar el text box
        driver.findElement(By.id("search_form_input_homepage")).sendKeys("tortellini al pesto"); //Escribir en el text box
        driver.findElement(By.id("search_button_homepage")).click(); //click a la lupa.
        Thread.sleep(2000); //Espera forzada
    }
}


