package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersPage {
    WebDriver driver;

    // Locators
    private final By cookieAcceptButton = By.id("wt-cli-accept-all-btn");
    private final By sliderNextButton = By.xpath("//a[contains(@class, 'location-slider-next')]");

    // Constructor
    public CareersPage(WebDriver driver) {
        this.driver = driver;
    }

    // Accept cookies if present
    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("Cookie accept button not found or not clickable: " + e.getMessage());
        }
    }

    // Scroll to slider and click the next button
    public void interactWithSlider() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement sliderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(sliderNextButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll to slider button
            js.executeScript("arguments[0].scrollIntoView(true);", sliderButton);

            // Click slider button
            js.executeScript("arguments[0].click();", sliderButton);
        } catch (Exception e) {
            System.out.println("Failed to interact with slider: " + e.getMessage());
        }
    }
}
