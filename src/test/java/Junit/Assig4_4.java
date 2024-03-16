
/*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/

package Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Assig4_4 extends TestBase{
    static WebDriver driver;
    @Test
    public void test() throws AWTException {
//Go to Amazon
        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");
// Scroll to the bottom of the page using Robot class
        Robot robot = new Robot();
        robot.mouseWheel(10);
//Click on the "Back to top" web element
        driver.findElement(By.linkText("Back to top")).click();
// Click on the Amazon logo at the bottom of the page using JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement amazonLogo = driver.findElement (By.xpath("//a[@href='/?ref_=footer_logo']"));
        jsExecutor.executeScript ("arguments[0].click();", amazonLogo);
// Use Actions to type "Clarusway" in the search box and perform the search
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        new Actions(driver)
                .sendKeys(searchBox, "Clarusway")
                .sendKeys(Keys. ENTER).perform(); 
    }}
