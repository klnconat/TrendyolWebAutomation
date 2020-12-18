package com.trendyol.common;

import com.trendyol.base.page.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollDown extends BasePage {

    public ScrollDown(WebDriver driver) {
        super(driver);
    }

    public static void scrollingDown(WebElement elem){
        CustomWait.waitForElementDisplayed(driver,elem);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",elem);
    }
}
