package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class Sample4Task {
    WebDriver driver;
    String base_url = "https://kristinek.github.io/test-sample/examples/act";

    // method which is being run before each test
    @Before
    public void startingTests() throws Exception {
        // from Sample 1:
        String libWithDriversLocation =  System.getProperty("user.dir") + "\\lib\\";
        System.setProperty("webdriver.chrome.driver", libWithDriversLocation + "chromedriver.exe");
        // declaration above:
        driver = new ChromeDriver();

        //open page:
        driver.get(base_url);
    }

    // method which is being run after each test
    @After
    public void endingTests() throws Exception {
        driver.close();
    }

    @Test
    public void enterNumber() throws Exception {
//        enter a number under "Number"
        String number = "7";
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(number);

//        check that button is not clickable
        assertFalse(driver.findElement(By.id("clear_result_button_number")).isEnabled());

//        click on "Result" button
        driver.findElement(By.id("result_button_number")).click();

//        check that text is displayed
        assertTrue(driver.findElement(By.id("result_number")).isDisplayed());

//        check that the correct Text appears ("You entered number: "NUMBER YOU ENTERED"")
        System.out.println("You entered number: \"" + number + "\"");
        System.out.println(driver.findElement(By.id("result_number")).getText());
        assertEquals("You entered number: \"" + number + "\"",
                driver.findElement(By.id("result_number")).getText());

//        check that the button "Clear Result" is clickable now
        assertTrue(driver.findElement(By.id("clear_result_button_number")).isEnabled());

//        click on "Clear Result"
        driver.findElement(By.id("clear_result_button_number")).click();

//        check that the text is still ("You entered number: "NUMBER YOU ENTERED""), but it is not displayed
        assertFalse(driver.findElement(By.id("result_number")).isDisplayed());
        assertEquals("You entered number: \"" + number + "\"",
                driver.findElement(By.id("result_number")).getText());
    }

    @Test
    public void clickOnLink() throws Exception {
//        check current url is base_url
        assertEquals(base_url, driver.getCurrentUrl());

//        click on "This is a link to Homepage"
        driver.findElement(By.id("homepage_link")).click();

//        check that current url is not base_url
        assertFalse(driver.getCurrentUrl().equals(base_url));

//        verify that current url is homepage
        assertEquals(driver.getCurrentUrl(), "https://kristinek.github.io/test-sample/");
    }
}
