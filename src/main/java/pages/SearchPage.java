package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{

    @FindBy(xpath="//div[contains(@class,'products-list-item products')]")
    List<WebElement> searchResults;

    public Integer countSearchItems()
    {
       waitForVisibility(searchResults.get(0));
       return searchResults.size();
    }

    public SearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


}
