package com.agile611.testng.webdriver;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BrokenImages {
    WebDriver driver;
    BrowserMobProxy proxy;

    @BeforeMethod
    public void setUp() throws Exception {
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
        System.setProperty("webdriver.gecko.driver",
                "src" + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "geckodriver-macos");
        driver = new FirefoxDriver(capabilities);
        proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
    }

    @AfterMethod
    public void tearDown() {
        proxy.stop();
        driver.quit();
    }

    @Test
    public void allImagesLoaded() {
        proxy.newHar();
        driver.navigate().to("http://the-internet.herokuapp.com/broken_images");
        List<WebElement> images = driver.findElements(By.tagName("img"));
        List brokenImages = new ArrayList();
        List<HarEntry> harEntries = proxy.getHar().getLog().getEntries();
        for (int entry = 0; entry < harEntries.size(); entry++) {
            for (int image = 0; image < images.size(); image++) {
                if (harEntries.get(entry).getRequest().getUrl().equals(
                        images.get(image).getAttribute("src"))
                        & harEntries.get(entry).getResponse().getStatus() == 404)
                    brokenImages.add(images.get(image).getAttribute("src"));
            }
        }
        List emptyCollection = new ArrayList();
        assertThat(brokenImages, is(emptyCollection));
    }
}
