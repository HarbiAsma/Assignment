
/*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

package Junit;

import engine.CustomListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners (CustomListener.class)
public class Assig5_1 {

        private WebDriver driver;

        @BeforeClass
        public void setUp() {
            // Set ChromeDriver path
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Create a new instance of ChromeDriver
            driver = new ChromeDriver();
        }

        @Test
        public void testFacebook() {
            // Go to Facebook
            driver.get("https://www.facebook.com/");
        }

        @Test(dependsOnMethods = "testFacebook")
        public void testGoogle() {
            // Go to Google
            driver.get("https://www.google.com/");
        }

        @Test(dependsOnMethods = "testGoogle")
        public void testAmazon() {
            // Go to Amazon
            driver.get("https://www.amazon.com/");
        }

        @AfterClass
        public void tearDown() {
            // Close the browser
            driver.quit();
        }
    }

