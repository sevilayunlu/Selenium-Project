package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //TC#3: Google search
        //1- Open a Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");


        //4- Press ENTER to search
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[id='L2AGLb']")).click();
        WebElement search = driver.findElement(By.name("q"));
        Thread.sleep(3000);
        search.sendKeys("apple" + Keys.ENTER);
        // WebElement googleSearchBox=driver.findElement(By.name("q"));
        //googleSearchBox.sendKeys(Keys.ENTER);-- we can also create a variable and click enter in this way.

        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedTitleStartsWithApple ="apple";
        String actualTitle=driver.getTitle();

        if(actualTitle.contains(expectedTitleStartsWithApple)){//startsWith method can also be applied
            System.out.println("Title verification is PASSED!");
        }else{
            System.out.println("Title verification is FAILED!");
        }

        driver.close();

    }
}





