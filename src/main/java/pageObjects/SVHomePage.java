package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class SVHomePage extends BasePage {

    //Initialize driver and web elements
    public SVHomePage() {
        super();
        PageFactory.initElements(getDriver(), this);
    }

    WebElement element;

    @FindBy(xpath = "//*[@class = 'pagination dark']/li[1]/a")
    private WebElement hrefWhatsNew;

    @FindBy(xpath = "//*[@class = 'pagination dark']/li[2]/a")
    private WebElement hrefOurStories;

    @FindBy(xpath = "//*[@class = 'pagination dark']/li[3]/a")
    private WebElement hrefOurTalent;

    @FindBy(xpath = "//*[@class = 'pagination dark']/li[4]/a")
    private WebElement hrefWhereWeAre;

    @FindBy(xpath = "//*[@class = 'pagination dark']/li")
    private WebElement leftMainMenu;

    @FindBy(xpath = "//*[@id='nav-menu-item-19892']/a/span[1]")
    private WebElement insightsButton;

    @FindBy(xpath = "//a[@id='hs-eu-confirmation-button']")
    private WebElement cookiesButton;

    @FindBy(xpath = "//span[@class='search-trigger']/img[2]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//*[@id='result']/div[1]/a/span")
    private WebElement linkSearch;

    public WebElement getHrefWhatsNew() {
        return hrefWhatsNew;
    }

    public WebElement getHrefOurStories() {
        return hrefOurStories;
    }

    public WebElement getHrefOurTalent() {
        return hrefOurTalent;
    }

    public WebElement getHrefWhereWeAre() {
        return hrefWhereWeAre;
    }

    public WebElement getInsightsButton() {
        return insightsButton;
    }

    public WebElement getCookiesButton() {
        return cookiesButton;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchTextBox() {
        return searchTextBox;
    }

    public WebElement getLinkSearch() {
        return linkSearch;
    }

    public WebElement getLeftMainMenu() {
        return leftMainMenu;
    }

    public void clickOnLeftMenuLink(String linkElement) {
        element = getDriver().findElement(By.xpath("//*[@class = 'pagination dark']" + "//li/a/span[contains(text(),'" + linkElement + "')]"));
        waitForVisibility(element);
        element.click();
    }

    public void verifyElementTitle(String elementTitle) {
        Assert.assertTrue(element.getAttribute("textContent").contains(elementTitle));
    }

    @Override
    public void clickOnElement(WebElement element) {
        super.clickOnElement(element);
    }

}
