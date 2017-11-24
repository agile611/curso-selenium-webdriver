package com.itnove.trainings.testng.startUsingWebDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class TestABTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        int counter1=0, counter2=0;
        for(int i=0; i < 10; i++){
            driver.get("https://the-internet.herokuapp.com/abtest");
            WebElement title =
                    driver.findElement(By.xpath(".//*[@id='content']/div/h3"));
            if(title.getText().equals("A/B Test Variation 1")){
                counter1++;
            }
            else{
                counter2++;
            }
            driver.manage().deleteAllCookies();
        }
        System.out.println("Han anat a la versio 1 "+counter1);
        System.out.println("Han anat a la versio 2 "+counter2);
    }
}
