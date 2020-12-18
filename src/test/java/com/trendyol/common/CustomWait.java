package com.trendyol.common;

import com.trendyol.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomWait extends BasePage {

    public static final int timeOutInSeconds = 30;

    public CustomWait(WebDriver driver) {
        super(driver);
    }

    //actions

    public static void waitForPageLoad(){
        driver.manage().timeouts().implicitlyWait(timeOutInSeconds, TimeUnit.SECONDS);
    }

    public static void waitForElementClickable(WebDriver driver, WebElement elem){
        try {
            new WebDriverWait(driver,timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(elem));
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    public static void waitForElementDisplayed(WebDriver driver, WebElement elem){
        try {
            new WebDriverWait(driver,timeOutInSeconds).until(ExpectedConditions.visibilityOf(elem));
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }

    public static void waitForElementDisplayed(WebDriver driver, List<WebElement> elem){
        try {
            new WebDriverWait(driver,timeOutInSeconds).until(ExpectedConditions.visibilityOfAllElements(elem));
        }
        catch (Exception err){
            err.printStackTrace();
        }
    }


}
