package com.cydeo.tests.week1.morning;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;

public class Task02 {

    public static void main(String[] args) {

        //1- Setup the "browser driver"
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();


        //  2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click Login label
        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));
        loginLink.click();


        //  4- Verify the title contains "Login"
        String title = driver.getTitle();
        if (title.equals("Login")){
            System.out.println("Title test is passed.");
        }else {
            System.out.println("Title test is failed.");
        }

        //  5- Verify the password is hidden
        WebElement password = driver.findElement(By.id("prependedInput2"));
        String passwordTypeAttribute = password.getAttribute("type");
        if (passwordTypeAttribute.equals("password")){
            System.out.println("Password hidden test is passed.");
        }else{
            System.out.println("Password hidden test is failed.");

        }



    }
}
