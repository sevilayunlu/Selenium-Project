package com.cydeo.tests.day06_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void information_alert_test() throws InterruptedException {
        //TC #1: Information alert practice
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Alert” button
        WebElement infoAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        infoAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        System.out.println("resultText.isDisplayed() = " + resultText.isDisplayed());
    }

    @Test
    public void confirmation_alert_practice() {
        //TC #2: Confirmation alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Confirm” button
        WebElement confAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confAlertButton.click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement verifyText = driver.findElement(By.xpath("//p[.='You clicked: Ok']"));
        Assert.assertTrue(verifyText.isDisplayed(), "Message is not there");


    }

    @Test
    public void prompt_alert_practice() {
        //TC #3: Information alert practice
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        //3. Click to “Click for JS Prompt” button
        WebElement promtAlert=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promtAlert.click();

        //4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        WebElement helloText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(helloText.isDisplayed());

    }


}




