import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.MainPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import pages.MainPage;
import pages.SearchPage;


public class TestPage {
    private static final String SITE = "https://comfy.ua/ua/odessa/";
    private static final String APPIUM = "http://0.0.0.0:4723";
    private static final String searchRequest="роутер";
    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("automationName",
                "UiAutomator2");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

        caps.setCapability("noReset", true);
        driver = new AppiumDriver(new URL(APPIUM), caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSendEmail() {
        MainPage mainPage=new MainPage(driver);
        SearchPage searchPage=new SearchPage(driver);
        mainPage.sendString(searchRequest);
        Assert.assertTrue(searchPage.countSearchItems()>0);
    }
}
