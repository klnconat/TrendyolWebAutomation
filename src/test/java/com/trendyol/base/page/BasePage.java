package com.trendyol.base.page;

import com.trendyol.common.CustomWait;
import com.trendyol.common.ScrollDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    // actions
    public boolean checkElementVisibility(WebElement elem) {
        return elem.isDisplayed();
    }

    public void waitElementVisibility(WebElement elem){
        CustomWait.waitForElementDisplayed(driver,elem);
    }

    public void goToUrl(String url) {
        driver.get(url);
        CustomWait.waitForPageLoad();
    }

    public void waitAndClick(WebElement elem) {
        CustomWait.waitForElementDisplayed(driver,elem);
        CustomWait.waitForElementClickable(driver,elem);
        elem.click();
    }

    public void waitAndAssign(WebElement elem,String value){
        CustomWait.waitForElementDisplayed(driver,elem);
        elem.sendKeys(value);
    }

    public void elementSelectionFromTheList(List<WebElement> elem){
        int index=0;
        if(elem.size()>1){
            Random rand = new Random();
            index=rand.nextInt(elem.size()-1);
            System.out.println("Random index: " + index);
            WebElement laptop = elem.get(index);
            System.out.println("Selected Laptop From The List: " + laptop);
            ScrollDown.scrollingDown(laptop);
            CustomWait.waitForElementDisplayed(driver,laptop);
            laptop.click();
        }
        else if(elem.size()<1){
            return;
        }
    }

    public String basketCheck(List<WebElement> elem){
        WebElement item = elem.get(0);
        String titleOfItem = item.getText();
        return titleOfItem;
    }

    public void removeItemFromTheBasket(WebElement elem1,WebElement elem2,WebElement elem3,WebElement elem4){
        if (checkElementVisibility(elem1)){
            return;
        }
        else {
            waitAndClick(elem2);
            waitAndClick(elem3);
            driver.navigate().refresh();
            if(checkElementVisibility(elem1)){
                return;
            }
            waitAndClick(elem4);
            waitAndClick(elem3);
            driver.navigate().refresh();
        }
    }

    public boolean featureComparison(String str1, String str2){
        if(str1.contains(str2)){
            return true;
        }
        else if(str2.contains(str1)){
            return true;
        }
        else {
            return false;
        }
    }
}
