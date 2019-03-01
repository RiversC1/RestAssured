package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import utilities.RestAssuredExtensions;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class PostStreamsSteps {
    public static ResponseOptions<Response> response;

    @Given("^I Perform POST operation for \"([^\"]*)\" with body$")
    public void iPerformPOSTOperationForWithBody(String url, DataTable table) {
        List<List<String>> data = table.raw();

        HashMap<String, String> body = new HashMap<String, String>();
        body.put("id", data.get(1).get(0));
        body.put("title", data.get(1).get(1));
        body.put("description", data.get(1).get(2));

        response = RestAssuredExtensions.PostOpsWithBody(url, body);
    }

    @Then("^I should see the body has title as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasTitleAs(String title) {
        assertThat(response.getBody().jsonPath().getString("title"), containsString(title));
    }


    @Then("^I should see the status code \"([^\"]*)\" Intertal server error$")
    public void iShouldSeeTheStatusCodeIntertalServerError(String statusCode) {
        Assert.assertEquals(Integer.parseInt(statusCode), response.getStatusCode());
    }
}
