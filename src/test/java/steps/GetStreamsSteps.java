package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtensions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class GetStreamsSteps {
    public static ResponseOptions<Response> response;

    @Given("^I want to do GET request for the resource \"([^\"]*)\"$")
    public void iWantToDoGETRequestForTheResource(String uri) {
            response = RestAssuredExtensions.GetOps(uri);
    }

    @When("^I want to do GET request for the ID \"([^\"]*)\" and the name \"([^\"]*)\"$")
    public void iWantToDoGETRequestForTheIDAndTheName(String id, String title) {
            // BDDStyleMethods.GetStreamTitle(id, title);
    }

    @Then("^I should be able to see the stream \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheStream(String name) {
            assertThat(response.body().jsonPath().getString("title"), containsString("Coding Stream"));
    }


    @Then("^I should be able to see the titles of the streams \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",  \"([^\"]*)\", \"([^\"]*)\"$")
    public void iShouldBeAbleToSeeTheTitlesOfTheStreams(String stream1, String stream2, String stream3, String stream4, String stream5, String stream6) {
            BDDStyleMethods.GETStreams(stream1,stream2,stream3,stream4,stream5,stream6);
    }

    @Then("^I should be able to verifiy the Query parameter for the operation \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifiyTheQueryParameterForTheOperation(String id) {
            BDDStyleMethods.GetStreamParam(id);
    }
}
