package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {

    @Test
    public void t1_double_click_practice() {
        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        // cookie Accept all
        WebElement cookieAccept = Driver.getDriver().findElement(By.xpath("//div[@id='accept-choices']"));
        cookieAccept.click();

        //2. Switch to iframe.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. Click double on the text “Double-click me to change my text color."
        //Using W3 page object ot reach to the 'paragraph 'web element'
        W3Page w3Page = new W3Page();
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3Page.paragraph).perform();

        //4. Assert: Text’s “style” attribute value contains “red”.
        String actualValue = w3Page.paragraph.getAttribute("style");
        String expectedValue = "color: red;";
        Assert.assertEquals(actualValue, expectedValue);

    }


}


//NOTE: FOLLOW POM^