package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.qadepartmanisecimi;
import pages.CareersNavigationPage;
import pages.CareersRolePage;

public class CareersRoleTest extends BaseTest {

    @Test
    public void testViewRoleRedirection() {
        CareersNavigationPage navigationPage = new CareersNavigationPage(driver);
        qadepartmanisecimi filterPage = new qadepartmanisecimi(driver);
        CareersRolePage rolePage = new CareersRolePage(driver);

        // Navigate to open positions page
        navigationPage.navigateToURL("https://useinsider.com/careers/open-positions/");
        navigationPage.acceptCookies();

        // Apply filters
        filterPage.selectLocationAll();
        filterPage.selectDepartmentQualityAssurance();

        // Click "View Role" and switch to new tab
        rolePage.clickViewRole();

        // Verify redirection to Lever application form
        Assert.assertTrue(rolePage.isLeverApplicationPageLoaded(), "Lever application form not loaded.");
    }
}
