package tests;

import org.testng.annotations.Test;
import pages.CareersNavigationPage;

public class CareersNavigationTest extends BaseTest {



    @Test
    public void testNavigateAndFilterJobs() {
        CareersNavigationPage careersPage = new CareersNavigationPage(driver);

        // Ana Sayfa
        driver.get("https://useinsider.com/");
        careersPage.navigateToCareersPage();

        // Find your dream job"a tıklama
        careersPage.clickFindYourDreamJob();

        System.out.println("Test completed successfully.");


    }


}
