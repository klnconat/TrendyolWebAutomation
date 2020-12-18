package com.trendyol.test;

import com.trendyol.base.test.BaseTest;
import com.trendyol.pageobjects.BasketPage;
import com.trendyol.pageobjects.LoginPage;
import com.trendyol.pageobjects.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasketTest extends BaseTest {

    protected LoginPage onLoginPage;
    protected SearchPage onSearchPage;
    protected BasketPage onBasketPage;

    @BeforeClass
    public void testSetup(){
        onLoginPage = new LoginPage(driver);
        onSearchPage = new SearchPage(driver);
        onBasketPage = new BasketPage(driver);

        onLoginPage.goToUrl("https://www.trendyol.com/");
        onLoginPage.clickCloseButtonForPopUp();
        onLoginPage.clickFirstLoginButton();
        onLoginPage.assignEmailAndPassword();
        onLoginPage.clickSecondLoginButton();
        onSearchPage.clickCloseButtonForPopUp();
        onLoginPage.clickMyBasketButton();
        onLoginPage.checkBasket();
        onLoginPage.clickStartShoppingButton();
        onSearchPage.clickSearchBox();
        onSearchPage.writeComputerWordInSearchBox();
        onSearchPage.clickSearchButton();
    }

    @Test(priority = 1)
    public void isFirstLaptopSelectionDone(){
        onBasketPage.clickHP();
        onBasketPage.waitForLaptopList();
        onBasketPage.laptopSelection();
        onBasketPage.getLaptopFeature();
        onBasketPage.clickAddToBasketButton();
        onBasketPage.clickMyBasketButton();
        onBasketPage.addedLaptopToTheBasket();

        Assert.assertEquals(onBasketPage.featureComparison(),true);
    }

    @Test(priority = 2)
    public void isSecondLaptopSelectionDone(){
        onBasketPage.clickBackToShoppingButton();
        onSearchPage.clickSearchBox();
        onSearchPage.writeComputerWordInSearchBox();
        onSearchPage.clickSearchButton();
        onBasketPage.clickHP();
        onBasketPage.laptopSelection();
        onBasketPage.getLaptopFeature();
        onBasketPage.clickAddToBasketButton();
        onBasketPage.clickMyBasketButton();
        onBasketPage.addedLaptopToTheBasket();

        Assert.assertEquals(onBasketPage.featureComparison(),true);
    }

}
