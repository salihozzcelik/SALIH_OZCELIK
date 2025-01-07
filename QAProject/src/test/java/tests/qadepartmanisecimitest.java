// Tests Class: CareersFilterTest
package tests;

import org.testng.annotations.Test;
import pages.CareersNavigationPage;

public class qadepartmanisecimitest extends BaseTest {

    @Test
    public void testFilterByLocationAndDepartment() {
        CareersNavigationPage navigationPage = new CareersNavigationPage(driver);
        pages.qadepartmanisecimi filterPage = new pages.qadepartmanisecimi(driver);

        // Navigate to the open positions page
        navigationPage.navigateToURL("https://useinsider.com/careers/open-positions/");
        navigationPage.acceptCookies();

        // Apply filters
        filterPage.selectLocationAll(); // Tüm Lokasyonlar Seçiliyor
        filterPage.selectDepartmentQualityAssurance(); // Departman içerisinden Quality Assurance Seçiliyor

        System.out.println("Filters applied successfully.");
    }
}
