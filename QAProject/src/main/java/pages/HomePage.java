package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Locators
    By companyMenu = By.linkText("Company");
    By careersLink = By.linkText("Careers");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickCompanyMenu() {
        driver.findElement(companyMenu).click();
    }

    public void clickCareersLink() {
        driver.findElement(careersLink).click();
    }

    public boolean isHomePageOpened() {
        return driver.getTitle().contains("Insider");
    }
}
