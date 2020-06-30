package com.agile611.testng.webdriver;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class StatusCodesTest {
    WebDriver driver;
    BrowserMobProxy proxy;

    @BeforeMethod
    public void setUp() {
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
    public void ResourceNotFound404() {
        proxy.newHar();
        driver.navigate().to("http://the-internet.herokuapp.com/status_codes/404");
        Har har = proxy.getHar();
        assertThat(har.getLog().getEntries().get(0).getResponse().getStatus(), is(404));
    }

    @Test
    public void ResourceFound200() {
        proxy.newHar();
        driver.navigate().to("http://the-internet.herokuapp.com/status_codes/200");
        Har har = proxy.getHar();
        assertThat(har.getLog().getEntries().get(0).getResponse().getStatus(), is(200));
    }

    @Test
    public void ResourceRedirect301() {
        proxy.newHar();
        driver.navigate().to("http://the-internet.herokuapp.com/status_codes/301");
        Har har = proxy.getHar();
        assertThat(har.getLog().getEntries().get(0).getResponse().getStatus(), is(301));
    }

    @Test
    public void ResourceError500() {
        proxy.newHar();
        driver.navigate().to("http://the-internet.herokuapp.com/status_codes/500");
        Har har = proxy.getHar();
        assertThat(har.getLog().getEntries().get(0).getResponse().getStatus(), is(500));
    }
}