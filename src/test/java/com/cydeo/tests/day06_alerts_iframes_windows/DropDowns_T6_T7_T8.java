package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DropDowns_T6_T7_T8 {

    WebDriver driver;


    @BeforeMethod
    public void setupMethod() throws InterruptedException {
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
        Thread.sleep(2000);

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }


    @Test
    public void dropDowns_task6() {


        //3. Select “December 1st, 1933” and verify it is selected.
        //Locate dropdowns and pass them in Select object constructors
        Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));

        //Select year using : visible text
        selectYear.selectByVisibleText("1933");


        //Select month using : value attribute
        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        selectMonth.selectByValue("11");

        //Select day using : index number
        Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        selectDay.selectByIndex(0);

        //create expected values
        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //getting actual values from the browser
        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expectedYear);//a message can be also added here and it will be displayed on the console whe the test is failed
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);


    }

    @Test
    public void dropDowns_task_7() {
        //TC #7: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //3. Select Illinois
        Select dropdownState = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        dropdownState.selectByVisibleText("Illinois");

        //4. Select Virginia
        dropdownState.selectByValue(("VA"));

        //5. Select California
        dropdownState.selectByIndex(5);

        //6. Verify final selected option is California.
        String actualState = dropdownState.getFirstSelectedOption().getText();
        String expectedState = "California";

        Assert.assertEquals(actualState, expectedState);

    }

    @Test
    public void dropDowns_task_8() throws InterruptedException {
        //TC #8: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        //3. Click to non-select dropdown
        //Locate the non-select object
        Thread.sleep(2000);
        WebElement dropDownHTML=driver.findElement(By.linkText("Dropdown link"));
        dropDownHTML.click();
        Thread.sleep(2000);

        //4. Select Facebook from dropdown
        WebElement faceBook=driver.findElement(By.xpath("//a[.='Facebook']"));
        faceBook.click();
        Thread.sleep(2000);

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Giriş Yap veya Kaydol";

        Assert.assertEquals(actualTitle,expectedTitle);



    }


}













//Use all Select options. (visible text, value, index)


