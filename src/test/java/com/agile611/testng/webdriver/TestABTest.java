package com.agile611.testng.webdriver;

import com.agile611.testng.webdriver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestABTest extends BaseTest {

    @Test
    public void testApp() throws InterruptedException {
        int counter1=0, counter2=0;
        for(int i=0; i < 1000; i++){
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
        System.out.println("He recibido la version 1 "+counter1);
        System.out.println("He recibido la version 2 "+counter2);
    }
}