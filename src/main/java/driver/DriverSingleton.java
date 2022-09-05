package driver;

import com.google.common.collect.ImmutableMap;
import data.AllData;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static AppiumDriver driver;
    private static DesiredCapabilities caps = new DesiredCapabilities();


    public static void setDriver() throws MalformedURLException {
        setCapabilities();
        driver = new AppiumDriver(new URL(AllData.APPIUM), caps);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    private static void setCapabilities() {
        caps.setCapability("platformName", AllData.PLATFORM_NAME);
        caps.setCapability("platformVersion", AllData.PLATFORM_VERSION);
        caps.setCapability("deviceName", AllData.DEVICE_NAME);
        caps.setCapability("automationName",
                AllData.AUTOMATION_NAME);
        caps.setCapability("browserName", AllData.BROWSWER_NAME);
        caps.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        caps.setCapability("noReset", true);
    }
}
