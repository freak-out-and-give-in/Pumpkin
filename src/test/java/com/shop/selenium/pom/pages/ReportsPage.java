package com.shop.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportsPage extends LoadableComponent<ReportsPage> {

    private WebDriver driver;

    public ReportsPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://localhost:8080/reports");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue(url != null && url.endsWith("reports.html"), "Not on the Reports page: " + url);
    }
}
