
//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.

//(create an array structure with "Mac, iPad and Samsung". You can see it in Assignment 2)

package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Assig5_4 {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {

        // Navigate to the login page
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

        // Enter email and password
        String email = "clarusway@gmail.com";
        String password = "123456789";
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-password")).sendKeys(password);

        // Click on the Login button
        driver.findElement(By.cssSelector("input[value='Login']")).click();
    }

    @Test(dataProvider = "searchKeywords")
    public void searchProduct(String keyword) {
        // Clear the search field
        driver.findElement(By.name("search")).clear();

        // Enter the search keyword
        driver.findElement(By.name("search")).sendKeys(keyword);

        // Click on the Search button
        driver.findElement(By.cssSelector("button[type='button'][data-toggle='dropdown']")).click();
    }

    @DataProvider(name = "searchKeywords")
    public Object[][] getSearchKeywords() {
        return new Object[][] {
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }
}
