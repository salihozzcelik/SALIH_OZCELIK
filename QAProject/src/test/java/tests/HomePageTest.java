package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends BaseTest {

    @Test
    public void testHomePageNavigation() {
        HomePage homePage = new HomePage(driver);

        // Verify home page is opened
        Assert.assertTrue(homePage.isHomePageOpened(), "Home page is not opened.");

        // Navigate to Careers page
        homePage.clickCompanyMenu();
        homePage.clickCareersLink();

        // Verify that Careers page is opened
        Assert.assertTrue(driver.getTitle().contains("Careers"), "Careers page is not opened.");
    }
}
