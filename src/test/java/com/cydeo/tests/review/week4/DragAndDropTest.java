package com.cydeo.tests.review.week4;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropTest {

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void guru99DragAndDropTest() {
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        //reject/handle all cookies [We have to change the frame (iframe !! for privacy settings)]

        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//*[@id='gdpr-consent-notice']")));

        WebElement acceptAll = Driver.getDriver().findElement(By.xpath("//button[@id='save']"));
        acceptAll.click();

        // back to the main html/frame
        Driver.getDriver().switchTo().defaultContent();


        WebElement bank = Driver.getDriver().findElement(By.linkText("BANK"));
        WebElement accountType = Driver.getDriver().findElement(By.id("bank"));

        actions.dragAndDrop(bank, accountType).perform();


        WebElement fiveK = Driver.getDriver().findElement(By.linkText("5000"));
        WebElement bankAmount = Driver.getDriver().findElement(By.id("amt7"));

        //actions.dragAndDropBy(fiveK, 121, 50).perform();
        actions.dragAndDrop(fiveK, bankAmount).perform();

        Driver.closeDriver();

    }


}
