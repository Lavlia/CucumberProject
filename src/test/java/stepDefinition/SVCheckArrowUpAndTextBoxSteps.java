package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObjects.SVHomePage;
import pageObjects.SVInsightsPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static pageObjects.BasePage.accessingProperties;

public class SVCheckArrowUpAndTextBoxSteps extends BaseUtil {


    SVInsightsPage insightsPage = new SVInsightsPage();
    SVHomePage svHomePage = new SVHomePage();
    JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor) getDriver());

    @Given("^I navigate to Softvision Site$")
    public void iNavigateToSoftvisionSite() throws IOException {
        getDriver().navigate().to(accessingProperties("baseUrlSV"));
    }

    @When("^I click on Insights Page$")
    public void iClickInsightsPage() {
        svHomePage.waitForVisibility(svHomePage.getCookiesButton());
        svHomePage.getCookiesButton().click();
        svHomePage.waitForVisibility(svHomePage.getInsightsButton());
        svHomePage.getInsightsButton().click();
    }

    @When("^I scroll down the page$")
    public void iScrollDownThePage() {
        javaScriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I click on Arrow Up Button$")
    public void iClickOnArrowUpButton() {
        javaScriptExecutor.executeScript("arguments[0].click();", insightsPage.getArrowUpButton());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I check the button title$")
    public void iCheckTheButtonTitle() {
        String titleClass = (String) javaScriptExecutor.executeScript(
                "return arguments[0].getAttribute('class');", insightsPage.getArrowUpButton());
        Assert.assertEquals(titleClass, "fa fa-arrow-up");
    }

    @When("^I click on Text Box$")
    public void iClickOnTextBox() {
        insightsPage.waitForVisibility(insightsPage.getSubscribeTextBox());
        insightsPage.getSubscribeTextBox().click();

    }

    @And("^I try to write something to the Text Box$")
    public void iTryToWriteSomethingToTheTextBox() {
        insightsPage.getSubscribeTextBox().sendKeys("lavinia.bogdanescu@gmail.com");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("^I should see the text i wrote$")
    public void iShouldSeeTheTextIWrote() {
        String result = insightsPage.getSubscribeTextBox().getAttribute("value");
        Assert.assertTrue(result.contains("lavinia"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
