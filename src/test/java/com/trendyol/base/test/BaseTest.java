package com.trendyol.base.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected static WebDriver driver = null;

    @BeforeClass
    public void beforeMethod() {
        //create driver
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();
        //delete cookies
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterMethod() {
        driver.close();
        driver.quit();
    }
}
