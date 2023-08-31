package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Practice {

    public static void main(String[] args) {
        //TC #4: Library verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

        //3. Enter username: “incorrect@email.com”
        WebElement emailAddressBox=driver.findElement(By.className("form-control"));
        emailAddressBox.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password”
        WebElement passwordBox=driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("incorrect password");

        WebElement signInButton=driver.findElement(By.tagName("button"));
        signInButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();











    }
}




//5. Verify: visually “Sorry, Wrong Email or Password”
//displayed
//PS: Locate username input box using “className” locator
//Locate password input box using “id” locator
//Locate Sign in button using “tagName” locator