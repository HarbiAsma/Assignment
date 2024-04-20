package API;

import base_urls.AssigUrl;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class Hw5 extends AssigUrl {
    /*
     Given
         https://reqres.in/api/users/23
     When
         User send a GET Request to the url
     Then
         HTTP Status code should be 404
     And
         Status Line should be HTTP/1.1 404 Not Found
     And
         Server is "cloudflare"
     And
         Response body should be empty
  */
    @Test
    public void HW() {

        //Set the Url
        spec.pathParams("first", "users", "second", "23");


        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare");

        //Response empty body
        String stringBody = response.asString();
        System.out.println(" "+ stringBody);

    }
}
