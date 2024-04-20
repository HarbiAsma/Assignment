package API;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Hw3 {
         /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void HW() {

        //1. Set the url:
//        User sends a GET Request to the URL:https://reqres.in/api/users/3
        Response response = RestAssured.get("https://reqres.in/api/users/3");
        response.prettyPrint();


        //2. Assertion:
//        HTTP Status code should be 200
//        Content Type should be JSON
//        Status Line should be HTTP/1.1 200 OK
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");
    }
}