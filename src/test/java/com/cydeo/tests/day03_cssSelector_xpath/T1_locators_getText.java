package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {
    public static void main(String[] args) throws InterruptedException {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a Chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();

        WebDriver driver= WebDriverFactory.getDriver("chrome");//-from utilities
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Enter incorrect username: “incorrect”
        WebElement userNameBox= driver.findElement(By.name("USER_LOGIN"));
        userNameBox.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passwordBox=driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrect");

        //5- Click to log in button.
        WebElement loginButton=driver.findElement(By.className("login-btn"));
        loginButton.click();

        //6- Verify error message text is as expected:
        //Expected: Incorrect login or password

        WebElement errorText=driver.findElement(By.className("errortext"));
        String expectedText="Incorrect login or password";
        String actualText= errorText.getText();

        if(actualText.equals(expectedText)){
            System.out.println("Error message verification is passed!");
        }else{
            System.out.println("Error message verification is failed");

        }
        Thread.sleep(2000);

        driver.close();





    }
}






//PS: Inspect and decide which locator you should be using to locate web
//elements.