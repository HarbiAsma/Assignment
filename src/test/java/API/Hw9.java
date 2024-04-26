package API;


import base_urls.SwaggerURL;
import org.testng.annotations.Test;
import test_data.UserTestData;

import java.util.Map;

public class Hw9 extends SwaggerURL {

    /*
    Write an automation test that will create a 'user'
    using the "https://petstore.swagger.io/" document
*/

    @Test
    public void HW() {
        //Set the url
        spec.pathParams("first", "user");

        Map<String, Object > expectedData = UserTestData.expectedDataMethod( 222,"AsmaHarbi","Asma","Alharbi","asma@outlook.com","1234","05558822",0);
        System.out.println("expectedData = " + expectedData);

}}
