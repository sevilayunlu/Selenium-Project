package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertPractice extends TestBase {



    @Test
    public void prompt_alert_test() {
        // 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        // 3. Click to “Click for JS Prompt” button
        WebElement js_prompt_alert=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        js_prompt_alert.click();

        // 4. Send “hello” text to alert
        Alert alert=driver.switchTo().alert();

        //get the text of alert window
        System.out.println("alert.getText() = " + alert.getText());

        alert.sendKeys("hello");

        // 5. Click to OK button from the alert
        BrowserUtils.sleep(2);
        alert.accept();

        // 6. Verify “You entered: hello” text is displayed.
        WebElement resultText=driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed());


    }


}
// TC : Alert practice
// 1. Open browser
