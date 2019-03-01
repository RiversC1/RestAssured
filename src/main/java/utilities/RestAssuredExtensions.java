package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtensions {

    public static RequestSpecification Request;

    public RestAssuredExtensions() {
        // Arrange
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000");
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = builder.build();
        Request = RestAssured.given().spec(requestSpec);
    }

    public static ResponseOptions<Response> GetOps(String url) {
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void GetOpsConParametros(String url, Map<String, String> pathParameters) {
        Request.pathParams(pathParameters);

        try {
            Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    public static ResponseOptions<Response> GetOpsQueryParams(String url, String queryParam) {
        try {
            Request.queryParam(queryParam);
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) {
        Request.pathParams(pathParams);
        Request.body(body);
        return Request.post(url);

    }

    public static ResponseOptions<Response> PostOpsWithBody(String url, Map<String, String> body) {
        Request.body(body);
        return Request.post(url);
    }


}
