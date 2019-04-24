package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import helper.LoggerHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetApiPlanets {
    Logger log = LoggerHelper.getLogger(GetApiPlanets.class);

    Response response;
    JSONArray planetsList = new JSONArray();


    public void getBaseUri() {
        RestAssured.baseURI = "https://swapi.co/";
    }

    public void getAllPlanetsDescription() {

        response = given().
                header("Content-Type", "application/json").
                param("format", "json").
                when().
                get("api/planets/").
                then().statusCode(200).and().log().all().
                contentType(ContentType.JSON).extract().response();
    }

    public void planetsJsonResponse() {
        String responseString = response.asString();
        JsonPath json = new JsonPath(responseString);
        int size = json.get("results.size()");
        log.info(size);

        //Iterating through the list of planets found in the json response
        for (int i = 0; i < size; i++) {

            String name = json.get("results[" + i + "].name");
            String climate = json.get("results[" + i + "].climate");
            String population = json.get("results[" + i + "].population");

            //Creating a json object and put in it details about the planet
            JSONObject planetDetails = new JSONObject();
            planetDetails.put("planet name", name);
            planetDetails.put("planet climate", climate);
            planetDetails.put("planet population", population);

            //Creating another json object to store the planet details
            JSONObject planetObject = new JSONObject();
            planetObject.put("planet" + i, planetDetails);

            //Store in a json array all the planets
            planetsList.add(planetObject);

        }
        try {
            FileWriter file = new FileWriter("planets.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(planetsList.toJSONString());
            String prettyJsonString = gson.toJson(je);
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
