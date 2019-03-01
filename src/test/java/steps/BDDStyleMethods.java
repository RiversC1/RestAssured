package steps;

import io.restassured.http.ContentType;
import org.hamcrest.collection.IsArrayContainingInAnyOrder;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;

public class BDDStyleMethods {
    public static void GetStreamTitle(String id, String title) {
        given()
                .contentType(ContentType.JSON).
        when()
                .get("http://localhost:3000/streams/%s", id).
        then()
                .body("title", is(title));
    }

    public static void GETStreams(String stream1, String stream2, String stream3, String stream4, String stream5, String stream6) {
        given()
                .contentType(ContentType.JSON).
        when()
                .get("http://localhost:3000/streams").
        then()
                .body("title", containsInAnyOrder(stream1, stream2, stream3, stream4, stream5, stream6));
    }

    public static void GetStreamParam(String param) {
        given()
                .contentType(ContentType.JSON).
        with()
                .pathParam("id", param).
        when()
                .get("http://localhost:3000/streams/{id}").
        then()
                .body("title", containsString("Come here boy! "));

    }

    public static void PotMethodWithBodyParams() {
        HashMap<String, String> BodyPOST = new HashMap<String, String>();
        BodyPOST.put("title", "Best Stream Ever");
        BodyPOST.put("description", "Coding with chat");

        given()
                .contentType(ContentType.JSON).
        with()
                .body(BodyPOST).
        when()
                .post("http://localhost:3000/streams").
        then()
                .body("id", containsString("8")).statusCode(200);
    }

}
