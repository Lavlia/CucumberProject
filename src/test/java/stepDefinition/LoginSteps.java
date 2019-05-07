package stepDefinition;

import cucumber.api.java.en.When;
import pageObjects.BaseUtil;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import org.testng.Assert;
import pageObjects.LoginPage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static pageObjects.BasePage.accessingProperties;


public class LoginSteps extends BaseUtil {

    LoginPage loginPage = new LoginPage();

    @Given("^I navigate to LinkedIn Website$")
    public void iNavigateToLinkedInWebsite() throws IOException {
        getDriver().get(accessingProperties("baseUrlLI"));
    }

    @When("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) {

        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            loginPage.waitForVisibility(loginPage.getUsername());
            loginPage.waitForVisibility(loginPage.getPassword());
            loginPage.inputLogin(list.get(i).get("username"), list.get(i).get("password"));
        }
    }

    @And("^I click login button$")
    public void iClickLoginButton() {
        loginPage.waitForVisibility(loginPage.getButtonSingIn());
        loginPage.clickButtonSingIn();
    }

    @Then("^I should see the user home page$")
    public void iShouldSeeTheUserHomePage() {
        Assert.assertTrue(getDriver().getTitle().contains("LinkedIn"), "It's not the Home Page!");
    }

}


