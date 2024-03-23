
//Go to URL: https://opensource-demo.orangehrmlive.com/
//Login with negative credentilas by Data Provider.
//Then assert that " Invalid credentials " is displayed.
//Run it parallel with 3 threads
//Generate Allure report


package Junit;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.*;

public class Assig5_2 extends Tests{

    @DataProvider(name = "invalidCredentials")
    public Object[][] getInvalidCredentials() {
        return new Object[][] {
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"}
        };
    }

    @Test(dataProvider = "invalidCredentials")
    public void testInvalidLogin(String username, String password) {
        // Go to the login page
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Enter invalid credentials
        driver.findElement(By.id("txtUsername")).sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        // Assert that "Invalid credentials" is displayed
        String errorMessage = driver.findElement(By.id("spanMessage")).getText();
        Assert.assertEquals(errorMessage, "Invalid credentials");
    }
    }



