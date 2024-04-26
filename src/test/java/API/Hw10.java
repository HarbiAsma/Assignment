package API;

import base_urls.SwaggerURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;


public class Hw10 extends SwaggerURL {
/*
    Using the https://petstore.swagger.io,
    write an automation test that finds the number of "pets" with the status "available"
    and asserts that there are more than 100.
 */


    @Test
    public void HW() {

        spec.pathParams("first", "pet","second","findByStatus").queryParams("status","available");


        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        // Get the count of pets with status "available"
        int availablePets = jsonPath.getList("findAll{it.status=='available'}").size();
        System.out.println("Pets Status = " + availablePets);
        assertTrue(availablePets>100);

    }}
