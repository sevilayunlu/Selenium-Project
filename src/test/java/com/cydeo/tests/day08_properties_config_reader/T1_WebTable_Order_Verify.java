package com.cydeo.tests.day08_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //TC #1: Web table practice
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void order_verify_name_test(){

        WebElement table=driver.findElement(By.xpath("//table[@class='SampleTable']"));
        //below locator is locating me the Bob's Martin's cell as where it is currently stored.
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

        //locate Bib's cell using its name as the text
        WebElement bobsCell=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));
        System.out.println("bobsCell.getText() = " + bobsCell.getText());


        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        String expectedName="Bob Martin";
        String actualName=bobsCell.getText();

        Assert.assertEquals(actualName,expectedName,"Test is failed!");

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        //WebElement bobs_order_element=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/../td[5]"));
        WebElement bobs_order_element=driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        String expectedDate="12/31/2021";
        String actualDate=bobs_order_element.getText();

        Assert.assertEquals(actualDate,expectedDate);









    }




    @Test
    public void test2_use_order_verify_method(){
        String alexandraGray= WebOrderUtils.returnOrderDate(driver,"Alexandra Gray");
        System.out.println("alexandraGray = " + alexandraGray);




    }

    @Test
    public void test3(){
        WebOrderUtils.orderVerify(driver,"John Doe","01/08/2021");
    }
}


