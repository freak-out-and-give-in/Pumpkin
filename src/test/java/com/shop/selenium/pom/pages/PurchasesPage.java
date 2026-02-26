package com.shop.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Component
public class PurchasesPage extends LoadableComponent<PurchasesPage> {

    private WebDriver driver;

    @FindBy(css = "form")
    private WebElement form;

    public PurchasesPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://127.0.0.1:8080/purchases");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        assertTrue(url != null && url.endsWith("purchases"), "Not on the Purchases page: " + url);
    }

    public void fillInPurchaseForm(String name, double wholesalePrice, double retailPrice, int amount, int quantity,
                                   double weight) {
        WebElement nameInput = form.findElement(By.id("name"));
        WebElement wholesalePriceInput = form.findElement(By.id("wholesalePrice"));
        WebElement retailPriceInput = form.findElement(By.id("retailPrice"));
        WebElement amountInput = form.findElement(By.id("amount"));
        WebElement quantityInput = form.findElement(By.id("quantity"));
        WebElement weightInput = form.findElement(By.id("weight"));

        nameInput.sendKeys(name);
        wholesalePriceInput.sendKeys(wholesalePrice + "");
        retailPriceInput.sendKeys(retailPrice + "");
        amountInput.sendKeys(amount + "");
        quantityInput.sendKeys(quantity + "");
        weightInput.sendKeys(weight + "");
    }

    public void submitPurchase() {
        WebElement submitInput = form.findElement(By.cssSelector("input[type=submit]"));

        submitInput.click();
    }
}
