package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//input[@name='q']")
    WebElement searchString;

    public void sendString(String string)
    {
        waitForVisibility(searchString);
        searchString.sendKeys(string);
    }

    public MainPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

}
