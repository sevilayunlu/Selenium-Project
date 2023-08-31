package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_cssSelector {

    public static void main(String[] args) {
        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //Expected: Log In
        String expectedLoginText="Log In";
        WebElement loginButton=driver.findElement(By.cssSelector("input[type='submit']"));
        String actualLoginTExt=loginButton.getAttribute("value");

        //Locating login button using cssSelector using class attribute's value
        //WebElement loginButton=driver.findElement(By.cssSelector("input[class='login-btn']"));
        //WebElement loginButton=driver.findElement(By.cssSelector("input.login-btn"));//2. syntax for class


        if(actualLoginTExt.equals(expectedLoginText)){
            System.out.println("Login button text verification PASSED!");
        }else{
            System.out.println("Login button text verification FAILED!");
        }






    }
}


//3- Verify “Log in” button text is as expected:
//Expected: Log In
//PS: Inspect and decide which locator you should be using to locate web
//elements.
//PS2: Pay attention to where to get the text of this button from