package com.shop.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NavigationPage {

    private WebDriver driver;

    @FindBy(css = ".item a")
    private List<WebElement> navigationNames;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    void navigateTo(Page page) {
        String pageName = page.getName();

        // If the name of the navigation item is the same
        // click on that element to traverse to that page
        for (WebElement currentName : navigationNames) {
            if (currentName.equals(pageName)) {
                currentName.click();

                break;
            }
        }
    }
}
