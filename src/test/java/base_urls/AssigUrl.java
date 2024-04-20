package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class AssigUrl {

    protected RequestSpecification spec;

    @BeforeMethod //Runs before each @Test
    public void setSpec(){

        spec = new RequestSpecBuilder()
                .setBaseUri("https://reqres.in/api")
                .setContentType(ContentType.JSON)
                .build();

    }
}
