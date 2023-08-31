package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_locators_getText_getAttribute {

    public static void main(String[] args) {
        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String actualRemember = driver.findElement(By.className("login-item-checkbox-label")).getText();
        String expectedRemember = "Remember me on this computer";

        if (actualRemember.equals(expectedRemember)) {
            System.out.println("Remember me text verification is PASSED!");
        } else {
            System.out.println("Remember me text verification is FAILED!");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        String expectedForgotPassword = "FORGOT YOUR PASSWORD?";
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPassword = forgotPasswordLink.getText();


        if (actualForgotPassword.equals(expectedForgotPassword)) {
            System.out.println("Forgot password text verification PASSED!");
        } else {
            System.out.println("actualForgotPassword = " + actualForgotPassword);
            System.out.println("expectedForgotPassword = " + expectedForgotPassword);
            System.out.println("Forgot password text verification FAILED!");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualHrefValue = forgotPasswordLink.getAttribute("href");

        if (actualHrefValue.contains(expectedInHref)) {
            System.out.println("Href verification is PASSED!");
        } else {
            System.out.println("Href verification is FAILED!");
        }


        driver.close();

    }


}


//PS: Inspect and decide which locator you should be using to locate web
//elements.