package com.trendyol.pageobjects;

import com.trendyol.base.page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(css = "input[class='search-box']")
    private WebElement searchBox;

    @FindBy(id = "Group-38")
    private WebElement closeButtonForPopUp;

    @FindBy(xpath = "//div[@class='suggestion-result']/a[1]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='dscrptn']/h1")
    private WebElement textAfterSearch;

    @FindBy(xpath = "//div[@class='fltrs ctgry']/a[1]")
    private WebElement laptopCategory;

    //actions
    public void clickCloseButtonForPopUp(){
        waitAndClick(closeButtonForPopUp);
    }

    public void clickSearchBox(){
        waitAndClick(searchBox);
    }

    public void writeComputerWordInSearchBox(){
        waitAndAssign(searchBox,"bilgisayar");
    }

    public void clickSearchButton(){
        waitAndClick(searchButton);
    }

    public String checkBilgisayarWord(){
        checkElementVisibility(textAfterSearch);
        return textAfterSearch.getText();
    }

}
