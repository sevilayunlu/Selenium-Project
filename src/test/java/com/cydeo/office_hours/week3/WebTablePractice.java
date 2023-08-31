package com.cydeo.office_hours.week3;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePractice {
    @Test
    public void webTable_test() {
        //url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        //Task 2:  Web Table
        //Step 1- Click on calendar
        Driver.getDriver().get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        WebElement calendarInput = Driver.getDriver().findElement(By.xpath("//input[@id='datepicker']"));
        calendarInput.click();

        //Step 2- Get all td of tables using findElements method
        List<WebElement> allDays = Driver.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //Step 3- using for loop get the text of all elements
        //
        //Step 4- using if else condition we will check the specific date
        //
        //Step 5- If the date is matched then click and break the loop.


        for (WebElement eachDay : allDays) {
            String day = eachDay.getText();
            System.out.println("eachDay.getText() = " + day);

            if (day.equalsIgnoreCase("5")) {
                eachDay.click();
                break;

            }




        }





    }
}