package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetApiWeather {
    public void getBaseUrl() {
        RestAssured.baseURI = "https://samples.openweathermap.org/";
    }

    public void simpleGetForGreatBritain() {
        given().
                param("q", "London,uk").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("data/2.5/weather").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("sys.country", equalTo("GB"));
    }

    public void simpleGetForCityLondon() {
        given().
                param("q", "London,uk").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("data/2.5/weather").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("name", equalTo("London"));
    }

    public void simpleGetForCityLondonTemperature() {
        given().
                param("q", "London,uk").
                param("appid", "b6907d289e10d714a6e88b30761fae22").
                when().
                get("data/2.5/weather").
                then().
                assertThat().statusCode(200).and().
                contentType(ContentType.JSON).and().
                body("main.temp", equalTo("280.32"));
    }
}
