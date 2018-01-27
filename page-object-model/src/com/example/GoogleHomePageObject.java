package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePageObject {

    // Constructor to initialize objects in the page
    // Uses PageFactory's initElements method
    public GoogleHomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    public WebElement searchTextBox;

    @FindBy(name = "btnK")
    public WebElement searchButton;

    @FindBy(linkText = "Selenium - Web Browser Automation")
    public WebElement seleniumLink;

    public void searchGoogle(String searchText) {
        // Enter search text and click on search button
        searchTextBox.sendKeys(searchText);
        searchButton.click();
    }

    public SeleniumHomePageObject clickSeleniumLink(WebDriver driver){
        seleniumLink.click();
        return new SeleniumHomePageObject(driver);
    }

}
