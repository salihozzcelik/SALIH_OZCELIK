package tests;

import org.testng.annotations.Test;
import pages.CareersPage;
import pages.HomePage;

public class CareersPageTest extends BaseTest {

    @Test
    public void testAcceptCookiesAndSliderInteraction() {
        HomePage homePage = new HomePage(driver);
        CareersPage careersPage = new CareersPage(driver);

        // Navigate to Careers page
        homePage.clickCompanyMenu();
        homePage.clickCareersLink();

        // Accept cookies
        careersPage.acceptCookies();

        // Interact with the slider
        careersPage.interactWithSlider();
    }
}
