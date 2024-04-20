package API;

import base_urls.AssigUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Hw8 extends AssigUrl {
    /*
      Given
          1) https://reqres.in/api/users
          2) {
              "name": "morpheus",
              "job": "leader"
              }
      When
          I send POST Request to the Url
      Then
          Status code is 201
          And response body should be like {
                                              "name": "morpheus",
                                              "job": "leader",
                                              "id": "496",
                                              "createdAt": "2022-10-04T15:18:56.372Z"
                                            }
   */
    @Test
    public void HW() {

        //Set the Url
        spec.pathParams("first", "users");

        //Set the expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");

        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(201)
                .body("data.name", equalTo(expectedData.get("data.name")),
                        "data.job", equalTo(expectedData.get("data.job")),
                        "data.id", equalTo(expectedData.get("data.id")),
                        "data.createdAt", equalTo(expectedData.get("data.createdAt")));


    }}
