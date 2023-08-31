package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoad7Page {

    public DynamicLoad7Page(){

        PageFactory.initElements(Driver.getDriver(),this);//returns the object of this class

    }

    @FindBy(xpath = "//div[.='Done!']/strong")
    public WebElement doneMessage;

    @FindBy(xpath = "//img")
    public WebElement spongeBobImg;





}
