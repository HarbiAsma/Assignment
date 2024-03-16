
/*   Go to URL: http://facebook.com
      getCookies,
      addCookie,
      deleteCookieNamed,
      deleteAllCookies
   */

package Junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


public class Assig4_5 extends Tests {
    @Test
    public void cookies(){

        // Go to URL: http://facebook.com
        driver.get("http://facebook.com");

        // getCookies
        System.out.println("Cookies are:\n"+driver.manage().getCookies());


        // addCookie
        driver.manage().addCookie(new Cookie("STUDENT","Asma"));
        System.out.println("New Cookie :"+driver.manage().getCookies().size());

        // deleteCookieNamed
        driver.manage().deleteCookieNamed("STUDENT");
        System.out.println("Cookie Deleted :"+driver.manage().getCookies().size());

        // deleteAllCookies
        driver.manage().deleteAllCookies();
        System.out.println("Cookie After Delete :"+driver.manage().getCookies().size());

}}
