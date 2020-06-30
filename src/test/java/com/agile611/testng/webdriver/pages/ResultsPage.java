package com.agile611.testng.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    private WebDriver driver;

    @FindBy(id = "links_wrapper")
    public WebElement resultsList;


    public ResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isResultsPagePresent() {
        return resultsList.isDisplayed();
    }
}
