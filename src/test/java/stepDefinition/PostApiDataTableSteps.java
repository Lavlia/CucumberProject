package stepDefinition;

import api.PostApiBooks;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.cucumber.datatable.DataTable;
import pageObjects.BaseUtil;

import java.util.List;
import java.util.Map;

public class PostApiDataTableSteps extends BaseUtil {
    PostApiBooks postApiBooks = new PostApiBooks();

    @Given("I am on the library website")
    public void iAmOnTheLibraryWebsite() {
        postApiBooks.getBaseUri();
    }

    @And("I add different books")
    public void iAddDifferentBooks(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            postApiBooks.addBookToLibrary(list.get(i).get("name"), list.get(i).get("isbn"), list.get(i).get("aisle"));
        }
    }

    @Then("I check if the status is correct")
    public void iCheckIfTheStatusIsCorrect(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            postApiBooks.checkStatus(list.get(i).get("status"));
        }

    }
}
