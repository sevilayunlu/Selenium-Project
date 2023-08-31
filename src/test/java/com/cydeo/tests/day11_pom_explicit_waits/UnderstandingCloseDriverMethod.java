package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class UnderstandingCloseDriverMethod {

    @Test
    public void test1(){
        Driver.getDriver().get("https://google.com");
        //verify something
        //Driver.getDriver().quit();//NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
       //Driver.getDriver().close();//NoSuchSessionException: invalid session id
        Driver.closeDriver();
    }

    @Test
    public void test2(){
        Driver.getDriver().get("https://google.com");
        //verify something else
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }

    @Test
    public void test3(){
        Driver.getDriver().get("https://google.com");
        //verify something completely different
        //Driver.getDriver().quit();
        //Driver.getDriver().close();
        Driver.closeDriver();
    }





}
