package steps;

import cucumber.api.java.Before;
import utilities.RestAssuredExtensions;

public class TestInitialize {

    @Before
    public void TestSetup() {
        RestAssuredExtensions restAssuredExtensions = new RestAssuredExtensions();
    }
}
