package com.cydeo.tests.week1.morning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;

import java.util.*;

public class Task01 {

    public static void main(String[] args) {

        //  1- Open a firefox browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();


        //  2- Goto https://vytrack.com/
        driver.get("https://vytrack.com/");  // first way
        //driver.navigate().to("https://vytrack.com/"); // second way


        //3- verify login is displayed
        // locate element
        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));
        if (loginLink.isDisplayed()){
            System.out.println("Test is passed.");
        }else{
            System.out.println("Test is failed.");
        }



    }
}
