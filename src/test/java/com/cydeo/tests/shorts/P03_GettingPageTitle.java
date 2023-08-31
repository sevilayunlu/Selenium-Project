package com.cydeo.tests.shorts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GettingPageTitle {

    public static void main(String[] args) {
        WebDriverManager .chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://cydeo.com");


        System.out.println(driver.getTitle());

        //test if the title of the page is Cydeo
        if(driver.getTitle().equals("Cydeo")){
            System.out.println("Title verification is passed");
        }else{
            System.out.println("Title verification is failed");
        }







    }
}
