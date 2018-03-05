package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample3Task {
    WebDriver driver;

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void assertEqualsTask() throws Exception {
//         check how many element with class "test" there are on page (5)
        assertEquals(5, driver.findElements(By.className("test")).size());
        assertEquals("This is also a button",
                driver.findElement(By.name("randomButton2")).getAttribute("value"));

//         check that value of second button is "This is also a button"
        assertEquals("This is also a button",
                driver.findElement(By.id("buttonId")).getAttribute("value"));
    }

    @Test
    public void assertTrueTask() throws Exception {
//         check that it is True that value of second button is "this is Also a Button" if you ignore Caps Locks
       assertTrue(driver.findElement(By.id("buttonId")).getAttribute("value")
                .equalsIgnoreCase("this is Also a Button"));

//       fail with custom error message:
        assertTrue("Expected text 'This is also a button'",
                driver.findElement(By.id("buttonId")).getAttribute("value")
                .equalsIgnoreCase("this is 7 Also a Button"));
    }

    @Test
    public void assertFalseTask() throws Exception {
//         TODO:
//        check that it is False that value of second button is "This is a button"
    }

    @Test
    public void failTask() throws Exception {
//        TODO:
//        check that none of items with class "test" contain number 190
    }
}
