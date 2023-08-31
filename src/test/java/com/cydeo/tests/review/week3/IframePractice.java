package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {
    // TC : Iframe practice



    @Test
    public void sending_message_iframe_test(){

        // 1. Users are already login and on the homepage of CRM app
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.login_crm(driver,ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

        // 2. Users click the MESSAGE tab
        WebElement messageTab=driver.findElement(By.xpath("//span[.='Message']/span"));
        messageTab.click();

        // 3. Users write test message
       // driver.switchTo().frame()


        // 4. Users click the SEND button

        // 5. Verify the message is displayed on the feed



    }


}
