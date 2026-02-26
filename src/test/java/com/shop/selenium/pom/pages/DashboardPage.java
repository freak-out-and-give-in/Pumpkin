package com.shop.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DashboardPage extends LoadableComponent<DashboardPage> {

    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://localhost:8080/dashboard");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue(url != null && url.endsWith("dashboard.html"), "Not on the Dashboard page: " + url);
    }
}
