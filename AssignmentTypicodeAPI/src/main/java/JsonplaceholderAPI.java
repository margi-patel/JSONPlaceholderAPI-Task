import io.restassured.response.Response;

import java.util.prefs.BackingStoreException;

import static io.restassured.RestAssured.given;

public class JsonplaceholderAPI {

    String BASE_URI = "";

    public JsonplaceholderAPI(String BASE_URI) {
        this.BASE_URI = BASE_URI;
    }

    public Response getData(String pathURI) {
        Response response = given().header("content-type", "application/json").
                baseUri(BASE_URI).
                when().get(pathURI).
                then().assertThat().statusCode(200).
                extract().response();
        return response;
    }

    public Response getData(String pathURI, String queryParamKey, String queryParamValue) {
        Response response = given().header("content-type", "application/json").
                queryParam(queryParamKey, queryParamValue).
                baseUri(BASE_URI).
                when().get(pathURI).
                then().assertThat().statusCode(200).
                extract().response();
        return  response;
    }

    public Response postData(String pathURI, String postBody) {
        Response response = given().header("content-type", "application/json").
                baseUri(BASE_URI).
                body(postBody).
                when().post(pathURI).
                then().assertThat().statusCode(201).
                extract().response();

        return  response;
    }

    public Response deleteData(String pathURI) {
        Response response = given().header("content-type", "application/json").
                baseUri(BASE_URI).
                when().delete(pathURI).
                then().assertThat().statusCode(200).
                extract().response();

        return  response;
    }

    public Response updateData(String pathURI, String postBody) {
        Response response = given().header("content-type", "application/json").
                baseUri(BASE_URI).
                body(postBody).
                when().put(pathURI).
                then().assertThat().statusCode(200).
                extract().response();

        return  response;
    }
}
