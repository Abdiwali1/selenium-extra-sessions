package com.cydeo.tests.week1.evening;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VytrackLoginPassword {

    public static void main(String[] args) {
        //1- Setup the "browser driver"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

        // 3- Click Login label
     //   driver.findElement(By.xpath("(//a[.='LOGIN'])[1]")).click();
        driver.findElement(By.cssSelector("a[href='http://app.vytrack.com']")).click();

        // 4- Verify the title contains "Login"
        if(driver.getTitle().contains("Login")){
            System.out.println("Title verification is passed!");
        }else{
            System.out.println("Title verification is failed!");
        }

        // 5- Verify the password is hidden
        WebElement passwordInput = driver.findElement(By.id("prependedInput2"));

        String actualPasswordType = passwordInput.getAttribute("type");
        String expectedPasswordType = "password";

        if (actualPasswordType.equals(expectedPasswordType)){
            System.out.println("Password is hidden");
        }else{
            System.out.println("Password is not hidden");
        }

        driver.quit();
    }
}
