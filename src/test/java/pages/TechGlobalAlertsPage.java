package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalAlertsPage extends TechGlobalBasePage {
    public TechGlobalAlertsPage() {
        super();
    }

    @FindBy(css = "li button")
    public List<WebElement> alertButton;

    @FindBy(id = "action")
    public WebElement result;

    @FindBy(id = "result_id")
    public WebElement resultTitle;

    @FindBy(id = "main_heading")
    public WebElement headingText;

    public void clickOnAlert(String text) {
        for (WebElement element : alertButton) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

}
