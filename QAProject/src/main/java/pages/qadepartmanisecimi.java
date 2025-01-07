// Pages Class: CareersFilterPage
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class qadepartmanisecimi {
    WebDriver driver;

    // Locators
    private final By locationDropdown = By.id("select2-filter-by-location-container");
    private final By locationOptionAll = By.xpath("//li[contains(@id, 'select2-filter-by-location-result') and text()='All']");
    private final By locationOptionIstanbul = By.xpath("//li[contains(@id, 'select2-filter-by-location-result') and text()='Istanbul, Turkey']");

    private final By departmentDropdown = By.id("select2-filter-by-department-container");
    private final By departmentOptionQualityAssurance = By.xpath("//li[contains(text(), 'Quality Assurance')]");

    // Constructor
    public qadepartmanisecimi(WebDriver driver) {
        this.driver = driver;
    }

    // Dropdown içerisinden hepsi seçiliyor
    public void selectLocationAll() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Dropdown tıklama
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(locationDropdown));
        dropdown.click();

        // Select "All" option
        WebElement optionAll = wait.until(ExpectedConditions.elementToBeClickable(locationOptionAll));
        optionAll.click();
        System.out.println("Selected 'All' in Location filter.");
    }

    // Departman menüden QA seçimi
    public void selectDepartmentQualityAssurance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Dropdown menüsünü bul ve tıkla
        WebElement departmentDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-filter-by-department-container")));
        departmentDropdown.click();
        System.out.println("Department dropdown clicked.");

        // 'Quality Assurance' seçeneğini bul ve tıkla
        By qaOption = By.xpath("//li[contains(@id, 'select2-filter-by-department-result') and text()='Quality Assurance']");
        WebElement qualityAssuranceOption = wait.until(ExpectedConditions.elementToBeClickable(qaOption));
        qualityAssuranceOption.click();
        System.out.println("Selected 'Quality Assurance' in Department filter.");
    }


}
