package stepDefinition;

import api.GetApiWeather;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.BaseUtil;

import java.io.IOException;

import static pageObjects.BasePage.accessingProperties;

public class GetApiSteps extends BaseUtil {

    GetApiWeather getApiWeather = new GetApiWeather();

    @When("^I perform GET operations for city weather$")
    public void iPerformGETOperationsForCityWeather() throws IOException {
        getDriver().get(accessingProperties("apiHttp"));
        getApiWeather.getBaseUrl();
    }

    @And("^I perform GET for Great Britain$")
    public void iPerformGETForGreatBritain() {
        getApiWeather.simpleGetForGreatBritain();
    }

    @And("^I perform GET for city London$")
    public void iPerformGETForCityLondon() {
        getApiWeather.simpleGetForCityLondon();

    }

    @And("^I perform GET for city London temperature$")
    public void iPerformGETForCityLondonTemperature() {
        getApiWeather.simpleGetForCityLondonTemperature();

    }
}
