package com.cydeo.tests.week1.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackLogin {

    public static void main(String[] args) {

        //  1- Open a chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //  2- Goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3- Verify LOGIN is displayed
        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));

        String expectedText = "LOGIN";
        String actualText = loginLink.getText();

        if(actualText.equals(expectedText)){
            System.out.println("Text verification passed!");
        }else{
            System.out.println("Text verification failed!");
        }

        driver.quit();
    }
}
