package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HW1_Etsy_Xpath_CSS {
    public static void main(String[] args) {
        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //skip cookies
        driver.findElement(By.cssSelector("[class= 'wt-btn wt-btn--filled wt-mb-xs-0']")).click();

        //3. Search for “wooden spoon”
        //WebElement searchBox = driver.findElement(By.xpath("//input[@id='global-enhancements-search-query']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        //WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Ich suche nach']"));

        //input[@type='text']
        // *[@type='text']

        //css Selector
        //syntax #1:tagName[attribute='value']
        //syntax #2: for id--> tag#idValue, for class: tag.classValue

        WebElement searchBox = driver.findElement(By.cssSelector("input#global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”
        String expectedTitle="Wooden spoon - Etsy DE";
        String actualTitle=driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

        driver.close();

    }
}



