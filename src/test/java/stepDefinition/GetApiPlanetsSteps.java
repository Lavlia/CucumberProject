package stepDefinition;

import api.GetApiPlanets;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.BaseUtil;

public class GetApiPlanetsSteps extends BaseUtil {
    GetApiPlanets getApiPlanets = new GetApiPlanets();

    @Given("I perform GET operation on all the planets")
    public void iPerformGETOperationOnAllThePlanets() {
        getDriver().get("https://www.swapi.co/api/planets/?format=json");
        getApiPlanets.getBaseUri();

    }

    @And("I perform GET for planets descriptions")
    public void iPerformGETForPlanetsDescriptions() {
        getApiPlanets.getAllPlanetsDescription();
    }

    @Then("I store them in a list")
    public void iStoreThemInAList() {
        getApiPlanets.planetsJsonResponse();
    }
}
