package com.cydeo.tests.day04_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Xpath_CssSelector_Practices {

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        //Locate "Home " link, using cssSelector,syntax #1, class attribute value
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));


        //Locate "Home" link, using cssSelector, syntax #2, class attribute value
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));

        //Locate "Home" link, using cssSelector, syntax #1, href attribute value
        WebElement homeLik_ex3 = driver.findElement(By.cssSelector("a[href]"));

        //b. “Forgot password” header
        //Locate header using xpath, using text of header
        WebElement header_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));//div.example>h2


        //Locate header using cssSelector, using patent element and move down to h2
        WebElement header_ex2 = driver.findElement(By.cssSelector("div[class='example']>h2"));

        //c. “E-mail” text
        //Locate email element using xpath
        WebElement email_ex1 = driver.findElement(By.xpath("//label[@for='email']"));


        //Locate email element using xpath text
        WebElement email_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));


        //d. E-mail input box
        //Locate the 'email' input box by using xpath
        WebElement input_ex1 = driver.findElement(By.xpath("//input[@type='text']"));


        //Locate the 'email' input box by using xpath contains method
        WebElement input_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, '[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]')]"));

        //e. “Retrieve password” button
        //Locate the retrieve password button using xpath
        WebElement retrievePassword = driver.findElement(By.xpath("//button[@type='submit']"));


        //f. “Powered by Cydeo text
        //Locate poweredbyCydeo text using xpath
        WebElement poweredByText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        System.out.println("homeLink.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("email_ex1.isDisplayed() = " + email_ex1.isDisplayed());
        System.out.println("input_ex1.isDisplayed() = " + input_ex1.isDisplayed());
        System.out.println("retrievePassword.isDisplayed() = " + retrievePassword.isDisplayed());
        System.out.println("poweredByText.isDisplayed() = " + poweredByText.isDisplayed());


        Thread.sleep(2000);
        driver.close();

    }


}
//XPATH and CSS Selector PRACTICES
//DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
//TC #1: XPATH and cssSelector Practices

//4. Verify all web elements are displayed.
//First solve the task with using cssSelector only. Try to create 2 different
//cssSelector if possible
//Then solve the task using XPATH only. Try to create 2 different
//XPATH locator if possible