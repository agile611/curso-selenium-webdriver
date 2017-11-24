package com.itnove.trainings.junit.startUsingWebDriver.pages.searchPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by guillem on 01/03/16.
 */
public class ResultsPage {

    private WebDriver driver;

    @FindBy(id = "links_wrapper")
    public WebElement resultsList;

    @FindBy(xpath = ".//*[@id='r1-0']/div")
    public WebElement firstResult;

    public boolean isResultsListPresent() {
        return resultsList.isDisplayed();
    }

    public void clickOnFirstResult() {
        firstResult.click();
    }

    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
