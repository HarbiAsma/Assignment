package API;

import base_urls.SwaggerURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class Hw12 extends SwaggerURL {
/*
    //Write an automation test that will create, read, update, delete
    a 'pet' using the "https://petstore.swagger.io/" document
    (All actions must be done on same pet)
    (Use Pojo)
 */

    PetPojo expectedData;

    @Test (priority = 1)
    public void PostPet(){

        spec.pathParams("first","pet");

        //Set the expected data 'With Pojo Class'
        expectedData = new PetPojo(11,"Kitten","available");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

    @Test (priority = 2)
    public void GetPet(){

        PetPojo expectedData = new PetPojo(11,"Kitten","available");
        System.out.println("ExpectedData = " + expectedData);

        Response response = given(spec).get("pet/11");
        response.prettyPrint();

        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("ActualData = " + actualData);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

    @Test (priority = 3)
    public void PurPet(){
        spec.pathParams("first","pet");

        PetPojo expectedData = new PetPojo(11,"Kitten","sold");
        System.out.println("ExpectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("ActualData = " + actualData);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());
    }

    @Test (priority = 4)
    public void DelPet(){
        spec.pathParams("first","pet","second","11");

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);
        response.then().body("message",equalTo(expectedData.getId()+""));

    }

}


