package com.agile611.testng.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    @FindBy(id = "search_form_input_homepage")
    public WebElement searchBox;


    @FindBy(id = "search_button_homepage")
    public WebElement searchButton;


    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.get("https://duckduckgo.com/");
    }

    public void searchKeyword(String keyword) {
        searchBox.clear();
        searchBox.sendKeys(keyword);
        searchButton.click();
    }
}
