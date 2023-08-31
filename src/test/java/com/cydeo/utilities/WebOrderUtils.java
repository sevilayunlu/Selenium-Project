package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebOrderUtils {


    //Method #1 info:
//• Name: returnOrderDate ()
//• Return type: String
//• Arg1: WebDriver driver
//• Arg2: String costumerName
//This method should accept a costumerName and return the costumer order date

   /*public static String returnOrderDate(WebDriver driver, String customerName){
        String locator="//td[.='"+customerName+"']/following-sibling::td[3]";
        WebElement customerDateCell=driver.findElement(By.xpath(locator));

        return customerDateCell.getText();

    }*/

    public static String returnOrderDate(WebDriver driver, String customerName){

         return driver.findElement(By.xpath("//td[.='"+customerName+"']/following-sibling::td[3]")).getText();

    }




    //Method #2 info:
//• Name: orderVerify ()
//• Return type: void
//• Arg1: WebDriver driver
//• Arg2: String costumerName
//• Arg3: String expectedOrderDate
//This method should accept above mentioned arguments and internally assert
//expectedOrderDate matching actualOrderDate.

        public static void orderVerify(WebDriver driver, String customerName, String expectedOrderDate){
            String locator="//td[.='"+customerName+"']/following-sibling::td[3]";
            WebElement customerDateCell=driver.findElement(By.xpath(locator));

            String actualDate=customerDateCell.getText();
            Assert.assertEquals(actualDate,expectedOrderDate);



        }
}
//TC #2: Web table practice Task1 cont.
//1. Create a new class called WebTableUtils.
//2. Create two methods to verify order

//as a String.
