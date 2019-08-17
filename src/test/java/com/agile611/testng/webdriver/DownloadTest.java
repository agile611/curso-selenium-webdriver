package com.agile611.testng.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class DownloadTest extends BaseTest {
    File folder;

    @BeforeMethod
    public void setUp() {
        folder = new File("src" + File.separator + "main" + File.separator + "resources" + File.separator + UUID.randomUUID().toString());
        //Chrome
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src" + File.separator + "main" + File.separator + "resources" + File.separator + "chromedriver-macos");
        String downloadFilepath = folder.getAbsolutePath();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);

        //Firefox
        /*DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver-macos");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream;application/csv;text/csv;application/vnd.ms-excel;");
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.manager.showWhenStarting", false);
        profile.setPreference("browser.download.folderList", 2);
        profile.setPreference("browser.download.dir", folder.getAbsolutePath());
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        driver = new FirefoxDriver(capabilities);*/
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void download() throws Exception {
        folder.mkdir();
        driver.get("http://the-internet.herokuapp.com/download");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/a[1]"));
        actions.dragAndDrop(link, link).build().perform();
        // Wait 2 seconds to download file
        Thread.sleep(2000);
        File[] listOfFiles = folder.listFiles();
        // Make sure the directory is not empty
        assertThat(listOfFiles.length, is(not(0)));
        for (File file : listOfFiles) {
            // Make sure the downloaded file(s) is(are) not empty
            assertThat(file.length(), is(not((long) 0)));
        }
        String[] entries = folder.list();
        for (String s : entries) {
            File currentFile = new File(folder.getPath(), s);
            currentFile.delete();
        }
        folder.delete();
    }
}