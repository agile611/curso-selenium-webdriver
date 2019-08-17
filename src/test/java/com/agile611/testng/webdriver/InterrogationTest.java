package com.agile611.testng.webdriver;

import org.testng.annotations.Test;

public class InterrogationTest extends BaseSaucelabsTest {
    @Test //Opciones de Navegación
    public void testNavigation() throws Exception {
        driver.get("https://www.duckduckgo.com/"); //Navegar hasta duckduckgo
        System.out.println("---------------------");
        System.out.println(driver.getPageSource());
        System.out.println("---------------------");
        System.out.println(driver.getTitle());
        System.out.println("---------------------");
        System.out.println(driver.getCurrentUrl());
        System.out.println("---------------------");

    }
}


