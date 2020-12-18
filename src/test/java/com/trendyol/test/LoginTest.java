package com.trendyol.test;

import com.trendyol.base.test.BaseTest;
import com.trendyol.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    protected LoginPage onLoginPage;

    @BeforeClass
    public void testSetup(){
        onLoginPage = new LoginPage(driver);
        onLoginPage.goToUrl("https://www.trendyol.com/");
        onLoginPage.clickCloseButtonForPopUp();
    }

    @Test(priority = 1)
    public void isPageOpened(){
        String expectedUrl = "https://www.trendyol.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expectedUrl);
    }

    @Test(priority = 2)
    public void isHelloMessageDisplayed(){
        onLoginPage.clickFirstLoginButton();
        Assert.assertEquals(onLoginPage.checkHelloMsg(),"Merhaba,");
    }

}
