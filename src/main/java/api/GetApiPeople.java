package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetApiPeople {

    Response response;
    JSONArray peopleList = new JSONArray();

    public void getBaseUrl() {
        RestAssured.baseURI = "http://www.swapi.co";
    }

    public void getAllPeopleDescription() {
        response = given().
                header("Content-Type", "application/json").
                param("format", "json").
                get("/api/people/").
                then().assertThat().statusCode(200).contentType(ContentType.JSON).extract().response();
    }

    public void peopleJsonResponse() {
        String responseString = response.asString();
        JsonPath json = new JsonPath(responseString);
        int size = json.get("results.size()");

        for (int i = 0; i < size; i++) {
            String name = json.get("results[" + i + "].name");
            String yearOfBirth = json.get("results[" + i + "].birth_year");
            String gender = json.get("results[" + i + "].gender");

            JSONObject peopleDetails = new JSONObject();
            peopleDetails.put("name", name);
            peopleDetails.put("birth year", yearOfBirth);
            peopleDetails.put("gender", gender);

            JSONObject peopleObject = new JSONObject();
            peopleObject.put("people" + i, peopleDetails);

            peopleList.add(peopleObject);
        }

        try {
            //creating the output file
            FileWriter file = new FileWriter("people.json");

            //creating a gson and set it to pretty
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            //creating a json parser object
            JsonParser jp = new JsonParser();

            //creating a json element to store the analyzed list of people
            JsonElement je = jp.parse(peopleList.toJSONString());

            //convert the gson into a json
            String prettyJsonString = gson.toJson(je);

            //Write the file with pretty json
            file.write(prettyJsonString);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
