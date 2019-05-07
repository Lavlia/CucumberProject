package stepDefinition;

import api.PostApiBooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.BaseUtil;

public class PostApiBooksSteps extends BaseUtil {

    PostApiBooks postApiBooks = new PostApiBooks();

    @Given("I am on the library site")
    public void iAmOnTheLibrarySite() {
        postApiBooks.getBaseUri();
    }

    @When("I add different books ([^\"]*) with unique ([^\"]*) and store then on their ([^\"]*)")
    public void iAddDifferentBooksNameWithUniqueIsbnAndStoreThenOnTheirAisle(String name, String isbn, String aisle) {
        postApiBooks.addBookToLibrary(name, isbn, aisle);
    }


    @Then("I check if books have the correct ([^\"]*)")
    public void iCheckIfBooksHaveTheCorrectId(String status) {
        postApiBooks.checkStatus(status);
    }
}
