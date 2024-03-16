
// Go to amazon.com
// Take Full Page Screenshot.
// Take any specific WebElement ScreenShot

package Junit;

import org.openqa.selenium.*;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;


public class Assig4_7 extends Tests{
    static WebDriver driver;

    @Test
    public void screenshotTests() throws IOException {

        //Go to Amazon
        driver.get("https://www.amazon.sa");

        // Take a full page screenshot
        File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(Screenshot,new File("target/fullPageScreenshot.png"));

        // Take a screenshot of specific WebElement
        File Screenshot2 = driver.findElement(By.cssSelector("div#nav-belt")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(Screenshot2,new File("target/WebElementScreenshot.png"));

    }
}