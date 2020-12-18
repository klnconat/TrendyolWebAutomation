package com.trendyol.test;

import com.trendyol.base.test.BaseTest;
import com.trendyol.pageobjects.LoginPage;
import com.trendyol.pageobjects.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    protected LoginPage onLoginPage;
    protected SearchPage onSearchPage;

    @BeforeClass
    public void testSetup(){
        onLoginPage = new LoginPage(driver);
        onSearchPage = new SearchPage(driver);

        onLoginPage.goToUrl("https://www.trendyol.com/");
        onLoginPage.clickCloseButtonForPopUp();
        onLoginPage.clickFirstLoginButton();
        onLoginPage.assignEmailAndPassword();
        onLoginPage.clickSecondLoginButton();
    }

    @Test(priority = 1)
    public void isBasketEmpty(){
        onSearchPage.clickCloseButtonForPopUp();
        onLoginPage.clickMyBasketButton();
        onLoginPage.checkBasket();
        Assert.assertEquals(onLoginPage.basketIconDisplayed(),true);
    }


    @Test(priority = 2)
    public void isDescriptionMatched(){
        onLoginPage.clickStartShoppingButton();
        onSearchPage.clickSearchBox();
        onSearchPage.writeComputerWordInSearchBox();
        onSearchPage.clickSearchButton();
        Assert.assertEquals(onSearchPage.checkBilgisayarWord(),"bilgisayar");
    }
}
