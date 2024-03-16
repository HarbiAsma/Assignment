
/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/

package Junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Assig4_2 {
    static WebDriver driver;
    @Test
    public void dragAndDropTest() {
//Go to URL: http://demo-gurugg.com/test/drag_drop.html
driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");

        By bankButton =By.id("credit2");
        By salesButton =By.id("credit1");
        By fiveThousandButton = (By.id ("fourth"));

        By accountDebitside = By.id("bank");
        By amountDebitside =By.id("amt7");

        By accountCreditside =By.id("loan");
        By amountCreditside = By.id("amt8");

//Drag and drop the BANK button to the Account section in DEBIT SIDE
dragAndDropMethod(bankButton, accountDebitside);
//Drag and drop the SALES button to the Account section in CREDIT SIDE
dragAndDropMethod (salesButton, accountDebitside);
//Drag and drop the 5000 button to the Amount section in DEBIT SIDE
dragAndDropMethod (fiveThousandButton, amountDebitside);
//Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
dragAndDropMethod (fiveThousandButton, amountDebitside);

//verify the visibility of Perfect text.
Assertions.assertEquals("Perfect!", driver.findElement(By.className("table4_result")).getText()); }
    public void dragAndDropMethod(By draggable, By droppable) {
        WebElement draggableElement = driver.findElement(draggable);
        WebElement droppableElement = driver. findElement (droppable);
        new Actions (driver)
                .dragAndDrop(draggableElement, droppableElement)
                .perform();

}}
