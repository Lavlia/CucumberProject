package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SVInsightsPage extends BasePage {

    //Initialize driver and web elements
    public SVInsightsPage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "#back_to_top>span>i")
    private WebElement arrowUpButton;

    @FindBy(xpath = "//input[@id='email-aeeb2a71-15b9-4af8-9991-ab689df545c4']")
    private WebElement subscribeTextBox;

    public WebElement getArrowUpButton() {
        return arrowUpButton;
    }

    public WebElement getSubscribeTextBox() {
        return subscribeTextBox;
    }

    @Override
    public void waitForVisibility(WebElement element) {
        super.waitForVisibility(element);
    }
}
