package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QAJobsPage;

public class QAJobsPageTest extends BaseTest {

    @Test
    public void testLocationFilter() {
        QAJobsPage qaJobsPage = new QAJobsPage(driver);

        // Navigate to the QA careers page
        qaJobsPage.navigateToURL("https://useinsider.com/careers/quality-assurance/");

        // Accept cookies
        qaJobsPage.acceptCookies();

        // Click on "See all QA jobs"
        qaJobsPage.clickSeeAllQAJobs();

        // Select "Istanbul, Turkey" location
        qaJobsPage.selectLocation();

        // Verify job listings are displayed
        boolean jobsDisplayed = qaJobsPage.areJobListingsDisplayed();
        Assert.assertTrue(jobsDisplayed, "No job listings displayed for the selected location!");
    }

}
