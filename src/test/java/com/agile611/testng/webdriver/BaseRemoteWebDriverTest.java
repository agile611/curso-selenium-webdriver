package com.agile611.testng.webdriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseRemoteWebDriverTest {
    public RemoteWebDriver driver;
    @BeforeClass(alwaysRun = true) //Inicialización del navegador
    public void setUp() throws Exception {
        DesiredCapabilities capabilities;
        String browser = System.getProperty("browser");
        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        } else {
            capabilities = DesiredCapabilities.firefox();
        }
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true) //El cierre del navegador
    public void tearDown() throws Exception {
        driver.quit();
    }
}
