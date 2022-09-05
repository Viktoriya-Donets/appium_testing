package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    public static final long WAIT = 20;

    public BasePage(AppiumDriver appiumDriver) {
         PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(80)), this);
         driver = appiumDriver;
    }

    public void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public void sendText(WebElement element, String text) {
        waitForVisibility(element);
        element.sendKeys(text);
    }

}
