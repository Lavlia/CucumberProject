package api;

import helper.LoggerHelper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PostApiBooks {
    Logger log = LoggerHelper.getLogger(PostApiBooks.class);
    String status;
    Response response;

    public void getBaseUri() {
        RestAssured.baseURI = "https://lavlia.free.beeceptor.com";
    }

    public void addBookToLibrary(String name, String isbn, String aisle) {
        response = given().
                body(addBook(name, isbn, aisle)).
                when().
                post("/my/api/path/post").
                then().assertThat().statusCode(201).log().all().
                extract().response();
    }

    public String addBook(String nameBook, String isbnBook, String aisleBook) {
        String payload = "{\r\n\r\n\"name\":\"" + nameBook + "\",\r\n\"isbn\":\"" + isbnBook +
                "\",\r\n\"aisle\":\"" + aisleBook + "\",\r\n\"author\":\"John Doe\",\n" +
                "\"id\":\"" + isbnBook + aisleBook + "\"\n}\r\n";
        log.info(payload);
        return payload;
    }

    public void checkStatus(String statusBook) {
        String responseString = response.asString();
        JsonPath json = new JsonPath(responseString);
        status = json.get("Status");
        log.info(status);
        log.info(status.equalsIgnoreCase(statusBook));
        Assert.assertTrue(status.equalsIgnoreCase(statusBook));


    }

}
