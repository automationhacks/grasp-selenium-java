package org.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumHomePageObject {

    public SeleniumHomePageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Download")
    public WebElement downloadLink;

    @FindBy(xpath = "//a[@title=\"Return to Selenium home page\"]")
    public WebElement homeLink;

    public void clickDownload() {
        downloadLink.click();
    }

    public void clickHome() {
        homeLink.click();
    }
}
