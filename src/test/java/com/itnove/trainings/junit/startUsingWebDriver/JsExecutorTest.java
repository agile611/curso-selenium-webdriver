package com.itnove.trainings.junit.startUsingWebDriver;

import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;


/**
 * Created by guillemhernandezsola on 09/05/2017.
 */
public class JsExecutorTest extends BaseTest {


    @Test
    public void testVideoAvanzado() throws Exception {
        driver.get("http://www.ccma.cat/tv3/directe-avancat/324/");
        acceptarCookies(driver);
        skipPublicitat(driver);
        JWPlayer jw = new JWPlayer(driver);
        assertTrue(jw.assertStatePlay());
        assertTrue(jw.assertStatePlaying());
        assertTrue(jw.assertStatePause());
        assertTrue(jw.assertStatePlay());
        assertTrue(jw.assertStateMuteTrue());
        assertTrue(jw.assertStateMuteFalse());
        assertTrue(jw.assertVolume(50));
        assertTrue(jw.assertVolume(0));
        assertTrue(jw.assertVolume(100));
        assertTrue(jw.assertStateRetrocede45mins());
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,500)", "");
        By tornaDirecte = By.xpath(".//*[@class='torna-directe']/span");
        wait.forAsyncElement(driver.findElement(tornaDirecte), 10, 3);
        System.out.println("Clicant al botó de directe");
        LocalNavigationActions.hoverAndClick(driver, tornaDirecte);
        assertTrue(jw.assertStateRetornarDirecto());
    }

    //Suposem q s'ha fet un play al media
    //fem un skip de la publicitat si es que existeix
    //per poder fer controls sobre el media i que la publicitat no interfereixi
    //llança exception si rebasem el llindar de publicitat demanat
    public static void skipPublicitat(WebDriver driver) throws Exception {
        String videoObject = ".//video[contains(@class,'jw-video')]";
        String adsObject = ".//*[contains(@class,'jw-flag-ads')]";
        wait.forElementPresent(By.xpath(videoObject));
        try {
            if (wait.forAsyncElement(driver.findElement(By.xpath(adsObject)), 30, 3)) {
                WebElement divAudioPlayer = driver.findElement(By.xpath(videoObject));
                System.out.println("Hi ha publicitat");
                String urlAds = divAudioPlayer.getAttribute("src");
                if (!urlAds.isEmpty())
                    System.out.println("URL de la publicitat: " + urlAds);
                wait.forElementNotVisible(By.xpath(adsObject));
            } else {
                System.out.println("No hi ha publicitat");
            }
        } catch (NoSuchElementException e) {
            System.out.println("No hi ha publicitat");
        } catch (TimeoutException e) {
            System.out.println("No hi ha publicitat");
        }
    }

    public static void acceptarCookies(WebDriver driver) throws InterruptedException {
        try {
            driver.findElement(By.xpath("id('dismiss')/div")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No hem acceptat les cookies");
        } catch (TimeoutException e) {
            System.out.println("No hem acceptat les cookies");
        }
    }
}
