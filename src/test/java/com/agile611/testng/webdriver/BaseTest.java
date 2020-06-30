package com.agile611.testng.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class BaseTest {
    public WebDriver driver;
    public static JavascriptExecutor jse;

    @BeforeClass(alwaysRun = true) //Inicialización del navegador
    public void setUp() throws Exception {
        DesiredCapabilities capabilities;
        String browser = System.getProperty("browser");
        if (browser != null && browser.equalsIgnoreCase("firefox")) {
            capabilities = DesiredCapabilities.firefox();
            System.setProperty("webdriver.gecko.driver",
                    "src" + File.separator + "main"
                            + File.separator + "resources"
                            + File.separator + "geckodriver-macos");
            driver = new FirefoxDriver(capabilities);
        } else {
            capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver-macos");
            driver = new ChromeDriver(capabilities);
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        jse = (JavascriptExecutor) driver;
    }

    @AfterClass(alwaysRun = true) //El cierre del navegador
    public void tearDown() throws Exception {
        driver.quit();
    }
}
