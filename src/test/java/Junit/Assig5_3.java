
/* Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */

package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assig5_3 {
    public static void main(String[] args) {
        // Set ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username and password
        String username = "student";
        String password = "incorrectPassword";
        System.out.println("Entering username: " + username);
        System.out.println("Entering password: " + password);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // Click on the login button
        System.out.println("Clicking on the login button");
        driver.findElement(By.id("submit")).click();

        // Get the error message
        String actualErrorMessage = driver.findElement(By.id("error")).getText();

        // Soft assert the error message
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualErrorMessage, "Your password is invalid!", "Error message mismatch");
        System.out.println("Soft assertion for the error message is successful");

        // Close the browser
        driver.quit();

        // Assert all soft assertions
        softAssert.assertAll();
    }

}
