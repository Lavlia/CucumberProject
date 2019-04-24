package stepDefinition;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import pageObjects.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.SVHomePage;

import java.io.IOException;

import static pageObjects.BasePage.accessingProperties;


public class SVCheckSearchButtonSteps extends BaseUtil {

    Logger log = LoggerHelper.getLogger(SVCheckSearchButtonSteps.class);

    SVHomePage svHomePage = new SVHomePage();

    @Given("^I am on the Softvision Home Page$")
    public void iAmOnTheSoftvisionHomePage() throws IOException {
        log.info("i am in search");
        getDriver().get(accessingProperties("baseUrlSV"));
    }

    @When("^I click on Search Button on Softvision Home Page$")
    public void iClickOnSearchButtonOnSoftvisionHomePage() {
        //Wait and click on Cookies Buttton
        svHomePage.waitForVisibility(svHomePage.getCookiesButton());
        svHomePage.clickOnElement(svHomePage.getCookiesButton());

        //Wait and click on Search Button
        svHomePage.waitForVisibility(svHomePage.getSearchButton());
        svHomePage.clickOnElement(svHomePage.getSearchButton());
    }

    @And("^I search the year (\\d+)$")
    public void iSearchTheYear(int year) {
        //Write the year in the Search Text Box
        svHomePage.getSearchTextBox().sendKeys(String.valueOf(year));

    }

    @Then("^I check if search engine sends the search$")
    public void iCheckIfSearchEngineSendsTheSearch() {
        //Wait for result and assert that the link contains the year we input
        svHomePage.waitForVisibility(svHomePage.getLinkSearch());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(svHomePage.getLinkSearch().getAttribute("textContent").contains("2018"));

    }
}
