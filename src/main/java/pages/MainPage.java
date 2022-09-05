package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    private static final String SITE = "https://gmail.com";

    @FindBy(xpath = "//input[@type = 'email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    public MainPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public MainPage openPage() {
        driver.get(SITE);
        return this;
    }

    public MailPage logIn(String login, String password) {
        sendText(emailField, login + "\n");
        sendText(passwordField, password + "\n");
        return new MailPage(driver);
    }
}
