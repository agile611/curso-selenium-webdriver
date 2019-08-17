package com.agile611.testng.webdriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSaucelabsTest {
    public RemoteWebDriver driver;
    @BeforeClass(alwaysRun = true) //Inicialización del navegador
    public void setUp() throws Exception {
        DesiredCapabilities capabilities;
        String browser = System.getProperty("browser");
        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
        }
        else if(browser != null && browser.equalsIgnoreCase("safari")) {
            capabilities = DesiredCapabilities.safari();
        }
        else if(browser != null && browser.equalsIgnoreCase("ie")) {
            capabilities = DesiredCapabilities.internetExplorer();
        }
        else if(browser != null && browser.equalsIgnoreCase("edge")) {
            capabilities = DesiredCapabilities.edge();
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("version", "15.15063");
        }
        else {
            capabilities = DesiredCapabilities.firefox();
        }
        driver = new RemoteWebDriver(new URL("http://selgp:ee557a77-606f-451d-9c8b-a4bb3ef03c90@ondemand.saucelabs.com:80/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass(alwaysRun = true) //El cierre del navegador
    public void tearDown() throws Exception {
        driver.quit();
    }
}
