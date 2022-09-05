import data.AllData;
import driver.DriverSingleton;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MainPage;


public class TestPage {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {
        DriverSingleton.setDriver();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testIsSendEmail() {
        MainPage page = new MainPage(driver);
        boolean isSent = page.openPage()
                .logIn(AllData.EMAIL, AllData.PASSWORD)
                .createMessage()
                .sendMessage(AllData.TO, AllData.THEME)
                .isMailSent();
        Assert.assertTrue(isSent);
    }
}
