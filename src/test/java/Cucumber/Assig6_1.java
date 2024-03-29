package Cucumber;

/*
      go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
      register account test with fluent page object approach
   */

import org.testng.annotations.Test;
import Cucumber.Tests;
import Cucumber.pages.lambdatest.LambdaTestRegisterPage;

public class Assig6_1 {
    @Test
    public void registerLambdatestTest() {
        new LambdaTestRegisterPage(bot)
                .goTo()
                .register("Asma", "ALharbi", "asma_alharbi@outllok.com", "123456", "12345s")
                .assertRegister();
    }
}
