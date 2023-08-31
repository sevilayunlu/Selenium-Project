package com.cydeo.tests.review.week4;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSExecutor_Scroll {
    @Test
    public void etsy_scroll_test() throws InterruptedException {

        //Go to Etsy homepage
        Driver.getDriver().get("https://www.etsy.com");


        //skip cookies
        Driver.getDriver().findElement(By.cssSelector("[class='wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // window.scrollBy(x, y)  ; x(right or left) stands for horizontal line and y stands for vertical line(up or down)
        // js.executeScript("window.scrollBy(0, 5000)");

        WebElement email = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)", email);


        //Generate random email and enter into subscribe box
        //Click on Subscribe
        Faker faker = new Faker();
        email.sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.xpath("//button[normalize-space(text())='Jetzt abonnieren']")).click();
        Thread.sleep(10000);

        //Verify "Great! We've sent you an email to confirm your subscription." is displayed
        WebElement resultMsg = Driver.getDriver().findElement(By.xpath("//div[normalize-space(text())='Fantastisch! Wir haben dir eine E-Mail geschickt, damit du deine Abos bestätigen kannst.']"));

        Thread.sleep(10000);
        Assert.assertEquals(resultMsg.getText(), "Fantastisch! Wir haben dir eine E-Mail geschickt, damit du deine Abos bestätigen kannst.");

        Driver.closeDriver();
    }


}
