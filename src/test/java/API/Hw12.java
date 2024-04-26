package API;


import base_urls.SwaggerURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class Hw12 extends SwaggerURL {
/*
    //Write an automation test that will create, read, update, delete
    a 'pet' using the "https://petstore.swagger.io/" document
    (All actions must be done on same pet)
    (Use Pojo)
 */


    @Test
    public void PostPet(){

        spec.pathParams("first","pet");

        PetPojo expectedData = new PetPojo(11,"Kitten","available");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

    @Test
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

    @Test
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

    @Test
    public void DelPet(){
        spec.pathParams("first","pet","second","11");
        Map<Object, Object> expectedData = new HashMap<>();

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        Map<Object, Object> actualData = response.as(Map.class);
        System.out.println("ActualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData, expectedData);

    }

}


