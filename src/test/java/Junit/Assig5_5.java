
//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 2.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.

package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class Assig5_5 {
     static WebDriver driver;
    public static void main(String[] args) {

        // Go to the URL
        driver.get("http://crossbrowsertesting.github.io/");

        // Click on To-Do App
        driver.findElement(By.linkText("To-Do App")).click();

        // Check the checkboxes for to do-4 and to do-5
        WebElement todo4Checkbox = driver.findElement(By.xpath("//input[@id='todo-4']"));
        WebElement todo5Checkbox = driver.findElement(By.xpath("//input[@id='todo-5']"));

        todo4Checkbox.click();
        todo5Checkbox.click();

        // Verify the length of the list is 2
        WebElement todoList = driver.findElement(By.className("todo-list"));
        int listLength = todoList.findElements(By.tagName("li")).size();
        Assert.assertEquals(listLength, 2, "List length is not as expected");

        // Assert that the added to-do items are present in the list
        Assert.assertTrue(todoList.getText().contains("to do-4"), "to do-4 is not present in the list");
        Assert.assertTrue(todoList.getText().contains("to do-5"), "to do-5 is not present in the list");

        // Click on the Archive link
        driver.findElement(By.linkText("Archive")).click();

        // Verify the length of the list after archiving
        int updatedListLength = todoList.findElements(By.tagName("li")).size();
        Assert.assertEquals(updatedListLength, 4, "List length after archiving is not as expected");

        // Doing Cross Browser Testing
        System.out.println("Doing Cross Browser Testing");

    }
}
