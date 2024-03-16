
//( This task should be managed with keyboard actions )
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object

package Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assig4_3 {
  static WebDriver driver;
    @Test
    public void search(){
      driver.get("https://www.google.com/");

        WebElement seerchIn = driver.findElement(By.name("q"));

        Actions ac = new Actions(driver);
            ac.moveToElement(seerchIn)
                    .click()
                    .keyDown(Keys.SHIFT)

                    .sendKeys("s")
                    .keyUp(Keys.SHIFT)

                    .sendKeys("croll")
                    .sendKeys(Keys.SPACE)
                    .keyDown(Keys.SHIFT)

                    .sendKeys("m")
                    .keyUp(Keys.SHIFT)

                    .sendKeys("ethods")
                    .sendKeys(Keys.ENTER)

                    .build()
                    .perform();


    }
}
