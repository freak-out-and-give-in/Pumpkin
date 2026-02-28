package com.shop.selenium.tests.pages;

import com.shop.selenium.pom.pages.PurchasesPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { com.shop.pumpkin.config.WebDriverConfig.class })
class PurchasesPageTest {

    @Autowired
    private WebDriver driver;

    private PurchasesPage purchasesPage;

    @BeforeEach
    void setUp() {
        this.purchasesPage = new PurchasesPage(driver)
                .get();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/selenium/pages/PurchaseData.csv", numLinesToSkip = 1)
    void addPurchase(String name, double wholesalePrice, double retailPrice, int amount, int quantity, double weight) {
        System.out.println("in");

        purchasesPage.fillInPurchaseForm(name, wholesalePrice, retailPrice, amount, quantity, weight);
        purchasesPage.submitPurchase();

        // Read from last row

        // Check values are equal

        //assertEquals(expectedMessage, framePage.getButtonText());
    }
}