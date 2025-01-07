package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareersNavigationPage {
    WebDriver driver;

    // Locators
    private final By companyMenu = By.xpath("//a[contains(text(), 'Company')]");
    private final By careersMenu = By.xpath("//a[contains(text(), 'Careers')]");
    private final By findYourDreamJobButton = By.xpath("//a[contains(@class, 'btn btn-info') and contains(text(), 'Find your dream job')]");
    private final By acceptCookiesButton = By.id("wt-cli-accept-all-btn");

    // Constructor
    public CareersNavigationPage(WebDriver driver) {
        this.driver = driver;
    }



    // Navigate to Careers page
    public void navigateToCareersPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(companyMenu)).click();
        pause(1000); // Bekleme süresi (1 saniye)
        wait.until(ExpectedConditions.elementToBeClickable(careersMenu)).click();
        pause(1000); // Bekleme süresi (1 saniye)
    }

    public void navigateToURL(String url) {
        driver.get(url);
        System.out.println("Navigated to URL: " + url);
    }

    // Accept cookies
    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            cookieButton.click();
            System.out.println("Cookies accepted successfully.");
            pause(1000); // Bekleme süresi (1 saniye)
        } catch (Exception e) {
            System.out.println("No cookie banner displayed: " + e.getMessage());
        }
    }

    // Click on "Find your dream job"
    public void clickFindYourDreamJob() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Çerezleri kabul et
        acceptCookies();

        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(findYourDreamJobButton));

            // Kaydır ve bekle
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
            Thread.sleep(1000); // Bekleme süresi

            // Normal tıklama dene
            button.click();
            System.out.println("Button clicked successfully.");
        } catch (Exception e) {
            // Eğer normal tıklama başarısız olursa, JavaScript ile tıklama dene
            System.out.println("Normal click failed, attempting JavaScript click.");
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(findYourDreamJobButton));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
            System.out.println("Button clicked successfully using JavaScript.");
        }
    }


    // Duraklama
    private void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
