
//Go to URL: https://the-internet.herokuapp.com/windows
//Verify the text: “Opening a new window”
//Verify the title of the page is “The Internet”
//Click on the “Click Here” button
//Verify the new window title is “New Window”
//Go back to the previous window and then verify the title: “The Internet”

package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assig4_1 {
    public static void main(String[] args) {
            // Set up the WebDriver
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            // Replace with the path to your chromedriver executable
            WebDriver driver = new ChromeDriver();

            // Go to the URL
            driver.get("https://the-internet.herokuapp.com/windows");

            // Verify the text "Opening a new window"
            WebElement textElement = driver.findElement(By.xpath("//h3[contains(text(), 'Opening a new window')]"));
            String text = textElement.getText();
            System.out.println("Text verification: " + text.equals("Opening a new window"));

            // Verify the title of the page is "The Internet"
            String pageTitle = driver.getTitle();
            System.out.println("Page title verification: " + pageTitle.equals("The Internet"));

            // Click on the "Click Here" button
            WebElement button = driver.findElement(By.linkText("Click Here"));
            button.click();

            // Switch to the new window
            String originalWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles())
            {
                driver.switchTo().window(windowHandle);
            }

            // Verify the new window title is "New Window"
            String newWindowTitle = driver.getTitle();
            System.out.println("New window title verification: " + newWindowTitle.equals("New Window"));

            // Go back to the previous window
            driver.switchTo().window(originalWindow);

            // Verify the title is "The Internet"
            String pageTitleAfterSwitch = driver.getTitle();
            System.out.println("Page title after switch verification: " + pageTitleAfterSwitch.equals("The Internet"));

            // Close the browser
            driver.quit();
        }
    }
