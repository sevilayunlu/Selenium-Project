package com.cydeo.office_hours.week01;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class TC02_LoginPage {
    public static void main(String[] args) {
        //TC002 As a user I should be able to see the login page
        // 1- Setup the "browser driver"
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");


        // 3- Click Login label
        WebElement loginButton = driver.findElement(By.xpath("//a[.='LOGIN']"));
        loginButton.click();

        // 3- Verify the title contains "Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title verification is passed!");
        } else {
            System.out.println("Title verification is failed!");
        }


        driver.quit();


    }
}


