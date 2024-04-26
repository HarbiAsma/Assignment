package API;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Hw11 {

    /*
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/


    @Test
    public void HW() {

        String url = "https://automationexercise.com/api/productsList";

        Response response = given().get(url);
        response.jsonPath().prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        int usertype = response.jsonPath().getList("data.findAll{it.category.usertype.usertype=='Women' }").size();
        assertEquals(usertype,12);

    }
}
