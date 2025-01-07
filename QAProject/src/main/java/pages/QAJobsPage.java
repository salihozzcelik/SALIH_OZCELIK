package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAJobsPage {
    WebDriver driver;

    // Locators
    private final By seeAllQAJobsButton = By.xpath("//a[contains(text(), 'See all QA jobs') and contains(@href, '/open-positions/?department=qualityassurance')]");
    private final By locationDropdown = By.id("select2-filter-by-location-container");
    private final By allOption = By.xpath("//span[@class='select2-selection__clear']");
    private final By istanbulOption = By.id("select2-filter-by-location-result-4box-Istanbul, Turkey");
    private final By jobListings = By.xpath("//div[contains(@class, 'position-list-item-wrapper')]");

    // Constructor
    public QAJobsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to the specific URL
    public void navigateToURL(String url) {
        driver.get(url);
    }

    // Accept cookies if present
    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("wt-cli-accept-all-btn")));
            cookieButton.click();
        } catch (Exception e) {
            System.out.println("No cookie banner displayed: " + e.getMessage());
        }
    }

    // Click on "See all QA jobs"
    public void clickSeeAllQAJobs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(seeAllQAJobsButton));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", button);
            button.click();
        } catch (Exception e) {
            System.out.println("Failed to click 'See all QA jobs': " + e.getMessage());
        }
    }

    // Select location as "Istanbul, Turkey"
    public void selectLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            // Open the location dropdown
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));
            dropdown.click();

            // Clear "All" filter if it exists
            try {
                WebElement clearFilter = wait.until(ExpectedConditions.elementToBeClickable(allOption));
                clearFilter.click();
                System.out.println("All filter cleared.");
            } catch (Exception e) {
                System.out.println("No 'All' filter to clear: " + e.getMessage());
            }

            // Select "Istanbul, Turkey"
            WebElement istanbul = wait.until(ExpectedConditions.elementToBeClickable(istanbulOption));
            istanbul.click();
            System.out.println("Location 'Istanbul, Turkey' selected.");
        } catch (Exception e) {
            System.out.println("Failed to select location: " + e.getMessage());
        }
    }


    // Check if job listings are displayed
    public boolean areJobListingsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            return !wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(jobListings)).isEmpty();
        } catch (Exception e) {
            System.out.println("No job listings found: " + e.getMessage());
            return false;
        }
    }

}
