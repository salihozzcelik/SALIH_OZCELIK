package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class CareersRolePage {
    WebDriver driver;

    // Constructor
    public CareersRolePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By viewRoleButton = By.xpath("//a[contains(text(), 'View Role')]");

    // Method to click "View Role" and switch to new tab
    public void clickViewRole() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement viewRoleBtn = wait.until(ExpectedConditions.elementToBeClickable(viewRoleButton));
        viewRoleBtn.click();
        System.out.println("'View Role' button clicked.");

        // Store current window handle
        String originalWindow = driver.getWindowHandle();

        // Wait for new window/tab to appear
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Switch to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to new tab.");
                break;
            }
        }
    }

    // Method to validate elements on the new page
    public boolean isLeverApplicationPageLoaded() {
        return driver.getCurrentUrl().contains("jobs.lever.co");
    }
}
