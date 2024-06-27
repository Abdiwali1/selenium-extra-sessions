package com.cydeo.tests.week3.evening;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableTest {

    @Test
    public void web_table_test(){
        //url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html
        //Task 2:  Web Table
        //Step 1- Click on calendar
        Driver.getDriver().get(ConfigurationReader.getProperty("calendar.url"));

        WebElement dateInput = Driver.getDriver().findElement(By.id("datepicker"));
        dateInput.click();

        //Step 2- Get the text of all test data of tables
        List<WebElement> allTestData = Driver.getDriver().findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        for (WebElement eachDay : allTestData) {
            System.out.println(eachDay.getText());
        }

        //Step 3- Click the specific date with creating dynamic method
        selectDay(20); // 06/20/2024

        Assert.assertEquals(dateInput.getAttribute("value"),"06/20/2024");
    }

    public void selectDay(int day){
        Driver.getDriver().findElement(By.xpath("//td[.='"+day+"']")).click();
    }

}
