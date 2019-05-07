package stepDefinition;

import cucumber.api.java.en.When;
import pageObjects.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.SVHomePage;

import java.io.IOException;

import static pageObjects.BasePage.accessingProperties;

public class SVCheckLeftMenuBarSteps extends BaseUtil {

    SVHomePage svHomePage = new SVHomePage();

    @Given("^I am on the Softvision Site$")
    public void iAmOnTheSoftvisionSite() throws IOException {
        getDriver().navigate().to(accessingProperties("baseUrlSV"));
    }

    @When("^I click on ([^\"]*) on Left Main Menu$")
    public void iClickOnLinkNameOnLeftMainMenu(String linkElement) {
        svHomePage.clickOnLeftMenuLink(linkElement);
    }

    @Then("^I check if Element have the correct ([^\"]*)$")
    public void iCheckIfElementHaveTheCorrectText(String elementTitle) {
        svHomePage.verifyElementTitle(elementTitle);
    }
}

