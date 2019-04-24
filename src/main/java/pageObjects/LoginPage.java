package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //Initialize driver and web elements
    public LoginPage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='session_key']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='session_password']")
    private WebElement password;
    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement buttonSingIn;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getButtonSingIn() {
        return buttonSingIn;
    }

    public void inputLogin(String user, String pass) {
        getUsername().sendKeys(user);
        getPassword().sendKeys(pass);
    }

    public void clickButtonSingIn() {
        getButtonSingIn().click();
    }

    @Override
    public void waitForVisibility(WebElement element) {
        super.waitForVisibility(element);
    }

}
