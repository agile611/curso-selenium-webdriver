package com.itnove.trainings.testng.startUsingWebDriver;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


/**
 * Created by guillem on 29/02/16.
 */
public class BaseTest {
    public RemoteWebDriver driver;
    public Actions hover;
    public static long timeOut = 120;
    public static LocalRemoteWebDriverWait wait;
    public static JavascriptExecutor jse;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        String browser = System.getProperty("browser");
        String hub = System.getProperty("hub");
        DesiredCapabilities capabilities;
        if (browser != null && browser.equalsIgnoreCase("chrome")) {
            capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver-macos");
            //driver = new ChromeDriver(capabilities);
        } else {
            capabilities = DesiredCapabilities.firefox();
            System.setProperty("webdriver.gecko.driver",
                    "src" + File.separator + "main"
                            + File.separator + "resources"
                            + File.separator + "geckodriver-macos");
            //driver = new FirefoxDriver(capabilities);
        }
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"), capabilities);
        //driver = new RemoteWebDriver(new URL(hub), capabilities);
        wait = new LocalRemoteWebDriverWait(driver, timeOut);
        hover = new Actions(driver);
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(timeOut, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
