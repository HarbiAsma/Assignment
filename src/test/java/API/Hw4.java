package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class Hw4 {
     /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be "application/json"
       And
           "email" is "janet.weaver@reqres.in",
       And
           "first_name" is "Janet"
       And
           "last_name" is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void HW(){

        //1. Set the url:
//        User sends a GET Request to the URL:https://reqres.in/api/users/2
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        response.prettyPrint();


        //2. Assertion:
//        HTTP Status code should be 200
//        Content Type should be JSON
//        "email" is "janet.weaver@reqres.in",
//        "first_name" is "Janet"
//        "last_name" is "Weaver"
//        "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"

        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}


