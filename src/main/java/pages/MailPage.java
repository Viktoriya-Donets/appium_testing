package pages;

import data.AllData;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MailPage extends BasePage{


    @FindBy(xpath = "//div[@class = 'il d v']")
    WebElement createButton;

    @FindBy(xpath = "//div[contains(text(),'Отправлено')]")
    WebElement message;

    @FindBy(xpath = "//input[@id='composeto']")
    private WebElement to;

    @FindBy(xpath = "//input[@id='cmcsubj']")
    private WebElement theme;

    @FindBy(xpath = "//div[@data-control-type='cmaasend+104']")
    private WebElement sendButton;

    public MailPage createMessage() {
        createButton.click();
        return new MailPage(driver);
    }

    public MailPage sendMessage(String sender, String emailTheme) {
        waitForVisibility(to);
        to.sendKeys(sender);
        theme.sendKeys(emailTheme);
        sendButton.click();
        return new MailPage(driver);
    }

    public MailPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    public MailPage openPage() {
        driver.get(AllData.SITE);
        return this;
    }

    public boolean isMailSent() {
        return message.isDisplayed();
    }
}
