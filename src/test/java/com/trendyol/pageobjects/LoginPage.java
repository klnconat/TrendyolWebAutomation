package com.trendyol.pageobjects;

import com.trendyol.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(css = "a[title='Close']")
    private WebElement closeButtonForPopUp;

    @FindBy(id="accountBtn")
    private WebElement firstLoginButton;

    @FindBy(xpath = "//div[@id='login-register']/div[1]/h1")
    private WebElement helloText;

    @FindBy(id = "login-email")
    private WebElement email;

    @FindBy(id = "login-password-input")
    private WebElement password;

    @FindBy(css = "button[class='q-primary q-fluid q-button-medium q-button submit']")
    private WebElement secondLoginButton;

    @FindBy(css = ".icon.navigation-icon-basket")
    private WebElement myBasketButton;

    @FindBy(css = ".basketIcon")
    private WebElement basketIcon;

    @FindBy(css = ".btn.shoppingStart")
    private WebElement startShoppingButton;

    @FindBy(css = ".pb-wrapper > div:nth-of-type(2) .i-trash")
    private WebElement trashButton1;

    @FindBy(css = ".btn-item.btn-remove > span")
    private WebElement removeItem;

    @FindBy(css = ".i-trash")
    private WebElement trashButton2;

    //actions
    public void clickCloseButtonForPopUp(){
        waitAndClick(closeButtonForPopUp);
    }

    public void clickFirstLoginButton(){
        waitAndClick(firstLoginButton);
    }

    public String checkHelloMsg(){
        waitElementVisibility(helloText);
        return helloText.getText();
    }

    public void assignEmailAndPassword(){
        waitAndAssign(email,"exampletrendyol@gmail.com");
        waitAndAssign(password,"123456789o");
    }

    public void clickSecondLoginButton(){
        waitAndClick(secondLoginButton);
    }

    public void clickMyBasketButton(){
        waitAndClick(myBasketButton);
    }

    public void checkBasket(){
        removeItemFromTheBasket(basketIcon,trashButton1,removeItem,trashButton2);
    }

    public boolean basketIconDisplayed(){
        return checkElementVisibility(basketIcon);
    }

    public void clickStartShoppingButton(){
        waitAndClick(startShoppingButton);
    }

}
