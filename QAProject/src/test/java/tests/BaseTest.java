package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setup() {
        // ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver.manage().window().maximize();
        driver.get("https://useinsider.com/");
    }

    @AfterMethod
    public void teardown() {
        // Geçici olarak tarayıcıyı kapatma işlemini yorum satırına alabilirsiniz.
        // if (driver != null) {
        //    driver.quit();
        // }
    }

}
