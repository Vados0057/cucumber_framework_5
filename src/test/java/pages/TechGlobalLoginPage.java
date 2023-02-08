package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalLoginPage extends TechGlobalBasePage {
    public TechGlobalLoginPage() {
        super();
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "error_message")
    public WebElement errorMessage;

    @FindBy(id = "success_lgn")
    public WebElement successMessage;

}
