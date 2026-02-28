package com.shop.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuppliersPage extends LoadableComponent<SuppliersPage> {

    private WebDriver driver;

    public SuppliersPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://localhost:8080/suppliers");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue(url != null && url.endsWith("suppliers.html"), "Not on the Suppliers page: " + url);
    }
}
