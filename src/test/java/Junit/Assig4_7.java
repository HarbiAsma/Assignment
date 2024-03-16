
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

    @Test
    public void screenshotTests() throws IOException {

        //Go to Amazon
        driver.get("https://www.amazon.sa");

        // Take a full page screenshot
        TakesScreenshot ss = (TakesScreenshot)driver;
        File ssFile = ss.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(ssFile,new File("C:\\Users\\farah\\IdeaProjects\\Assignment\\test\\image.png"));

        // Take a screenshot of specific WebElement
        File ssFile2 = driver.findElement(By.cssSelector("div#nav-belt")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(ssFile2,new File("C:\\Users\\farah\\IdeaProjects\\Assignment\\test\\image2.png"));

    }
}