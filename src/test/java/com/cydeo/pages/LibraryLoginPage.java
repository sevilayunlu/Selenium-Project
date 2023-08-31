package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {
    //#1- Initialize the object of the class and the driver instance inside the constructor

    public LibraryLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);//returns the object of this class

    }



    //#2- USe @FindBy annotation instead of FindElement method


    @FindBy(id="inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passWordInput;

    @FindBy(xpath ="//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(xpath = "//div[.='This field is required.']/div")
    public WebElement fieldRequiredErrorMessage;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']/div")
    public WebElement enter_ValidEmailErrorMessage;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPasswordErrorMessage;











}
