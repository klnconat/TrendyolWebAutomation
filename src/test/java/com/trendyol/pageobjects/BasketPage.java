package com.trendyol.pageobjects;

import com.trendyol.base.page.BasePage;
import com.trendyol.common.CustomWait;
import com.trendyol.common.ScrollDown;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public String laptopFeatureAsString;
    public String laptopFeatureAsString2;

    //elements
    @FindBy(xpath = "//div[@class='fltrs']/a[2]")
    private WebElement HP;

    @FindBy(css = "img.p-card-img")
    private List<WebElement> laptopList;

    @FindBy(css = "h1.pr-new-br span") /////uygun css yazılışı
    private WebElement laptopFeature;

    @FindBy(css = "h1.pr-new-br a")
    private WebElement laptopBrand;

    @FindBy(css = "button[class='pr-in-btn add-to-bs']")
    private WebElement addToBasketButton;

    @FindBy(css = ".icon.navigation-icon-basket")
    private WebElement myBasketButton;

    @FindBy(css = ".ty-bordered.ty-button.ty-font-w-semi-bold.ty-input-medium.ty-notr.ty-transition")
    private WebElement backToShoppingButton;

    @FindBy(css = "p.pb-item")
    private List<WebElement> itemList;


    //actions
    public void clickHP(){
        ScrollDown.scrollingDown(HP);
        waitAndClick(HP);
    }

    public void waitForLaptopList(){
        CustomWait.waitForPageLoad();
    }

    public void laptopSelection(){
        elementSelectionFromTheList(laptopList);
    }

    public String getLaptopFeature(){
        laptopFeatureAsString = laptopBrand.getText().toLowerCase() + laptopFeature.getText().toLowerCase();
        return laptopFeatureAsString;
    }

    public void clickAddToBasketButton(){
        ScrollDown.scrollingDown(myBasketButton);
        waitAndClick(addToBasketButton);
    }

    public void clickMyBasketButton(){
        waitAndClick(myBasketButton);
    }

    public String addedLaptopToTheBasket(){
        laptopFeatureAsString2 = basketCheck(itemList).toLowerCase();
        return laptopFeatureAsString2;
    }

    public boolean featureComparison(){
        waitElementVisibility(backToShoppingButton);

        if(laptopFeatureAsString.length()>=laptopFeatureAsString2.length()){
            return featureComparison(laptopFeatureAsString,laptopFeatureAsString2);
        }
        else{
            return featureComparison(laptopFeatureAsString2,laptopFeatureAsString);
        }
    }

    public void clickBackToShoppingButton(){
        waitAndClick(backToShoppingButton);
    }

}
