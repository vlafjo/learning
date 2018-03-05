package selenium.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class Sample7Task {
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
    public void selectCheckBox() throws Exception {
//        check that none of the checkboxes are ticked
        List <WebElement> checkbox = driver.findElements(By.cssSelector("[type='checkbox']"));
        for (WebElement checkbox1 : checkbox) {
            assertFalse(checkbox1.isSelected());
        }
//        tick  "Option 2"
        driver.findElement(By.id("vfb-6-1")).click();
//        check that "Option 1" and "Option 3' are not ticked, but "Option 2" is ticked
        assertTrue(driver.findElement(By.id("vfb-6-1")).isSelected());
        assertFalse(driver.findElement(By.id("vfb-6-0")).isSelected());
        assertFalse(driver.findElement(By.id("vfb-6-2")).isSelected());
//        tick  "Option 3"
        driver.findElement(By.id("vfb-6-2")).click();
//        click result
        driver.findElement(By.id("result_button_checkbox")).click();
//        check that text 'You selected value(s): Option 2, Option 3' is being displayed
        assertEquals("You selected value(s): Option 2, Option 3",
                driver.findElement(By.id("result_checkbox")).getText());
    }


    @Test
    public void selectRadioButton() throws Exception {
//        check that none of the radio are selected
        List <WebElement> radioButtons = driver.findElements(By.cssSelector("[type='radio']"));
        for (WebElement radioButtons2 : radioButtons) {
            assertFalse(radioButtons2.isSelected());
        }
//        select  "Option 3"
        driver.findElement(By.cssSelector("[value='Option 3'][type='radio']")).click();
//        check that "Option 1" and "Option 2' are not select, but "Option 3" is selected
        assertFalse(driver.findElement(By.cssSelector("[value='Option 1'][type='radio']")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("[value='Option 2'][type='radio']")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("[value='Option 3'][type='radio']")).isSelected());
//        select  "Option 1"
        driver.findElement(By.cssSelector("[value='Option 1'][type='radio']")).click();
//        check that "Option 2" and "Option 3' are not select, but "Option 1" is selected
        assertFalse(driver.findElement(By.cssSelector("[value='Option 2'][type='radio']")).isSelected());
        assertFalse(driver.findElement(By.cssSelector("[value='Option 3'][type='radio']")).isSelected());
        assertTrue(driver.findElement(By.cssSelector("[value='Option 1'][type='radio']")).isSelected());
//        click result
        driver.findElement(By.id("result_button_ratio")).click();
//        check that 'You selected option: Option 1' text is being displayed
        assertEquals("You selected option: Option 1",
                driver.findElement(By.id("result_radio")).getText());
    }

    @Test
    public void selectOption() throws Exception {
//        select "Option 3" in Select
        Select dropdown = new Select(driver.findElement(By.id("vfb-12")));
        dropdown.selectByVisibleText("Option 3");

//        check that selected option is "Option 3"
        assertEquals("Option 3",
                dropdown.getFirstSelectedOption().getText());

//        select "Option 2" in Select
        dropdown.selectByValue("value2");

//        check that selected option is "Option 2"
        assertEquals("Option 2",
                dropdown.getFirstSelectedOption().getText());

//        click result
        driver.findElement(By.id("result_button_select")).click();

//        check that 'You selected option: Option 2' text is being displayed
        assertEquals("You selected option: Option 2",
                driver.findElement(By.id("result_select")).getText());
        System.out.println();
    }

    @Test
    public void chooseDateViaCalendarBonus() throws Exception {
//        enter date '4 of July 2007' using calendar widget
//        check that correct date is added
    }

    @Test
    public void chooseDateViaTextBoxBonus() throws Exception {
//        enter date '2 of May 1959' using text
//        check that correct date is added
    }
}
