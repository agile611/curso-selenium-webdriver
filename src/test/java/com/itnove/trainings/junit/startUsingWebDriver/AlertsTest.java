package com.itnove.trainings.junit.startUsingWebDriver;



import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Unit test for simple App.
 */
public class AlertsTest extends BaseTest {

    public void acceptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }

    public void dismissAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            //exception handling
        }
    }
    public void promptAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.sendKeys("Hola hola super hola");
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
    }


    @Test
    public void testApp() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[1]/button")).click();
        Thread.sleep(2000);
        acceptAlert();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[2]/button")).click();
        Thread.sleep(2000);
        acceptAlert();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[2]/button")).click();
        Thread.sleep(2000);
        dismissAlert();
        Thread.sleep(2000);
        driver.findElement(By.xpath(".//*[@id='content']/div/ul/li[3]/button")).click();
        Thread.sleep(2000);
        promptAlert();
        Thread.sleep(2000);
    }
}
