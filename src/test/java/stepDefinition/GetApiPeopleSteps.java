package stepDefinition;

import api.GetApiPeople;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseUtil;

public class GetApiPeopleSteps extends BaseUtil {

    GetApiPeople getApiPeople = new GetApiPeople();

    @When("I perform GET operation on all the people")
    public void iPerformGETOperationOnAllThePeople() {
        getDriver().get("https://www.swapi.co/api/people/?format=json");
        getApiPeople.getBaseUrl();
    }

    @And("I perform GET for people descriptions")
    public void iPerformGETForPeopleDescriptions() {
        getApiPeople.getAllPeopleDescription();
    }

    @Then("I store them in another list")
    public void iStoreThemInAnotherList() {
        getApiPeople.peopleJsonResponse();
    }
}
