package com.youTube;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouTubeSearchPage {

    WebDriver driver;

    private String url = "https://www.youtube.com/";

    By SEARCH_INPUT_LOCATOR = By.xpath("//input[@id='search']");
    By SEARCH_LIST_LOCATOR = By.xpath("//div[@class = 'gstl_50 sbdd_a' and not(contains(@style, 'display:none'))]");
    By SEARCH_LIST_ITEM_LOCATOR = By.xpath("//div[@class = 'gstl_50 sbdd_a' and not(contains(@style, 'display:none'))]//ul[@class='sbsb_b' and @role='listbox']");
    By FOURTH_VIDEO_LOCATOR = By.xpath("//div[@id = 'contents' and ./ytd-video-renderer]/ytd-video-renderer[4]");
    By SUBSCRIBE_BUTTON_LOCATOR = By.xpath("//div[@id='subscribe-button' and @class='style-scope ytd-video-secondary-info-renderer']");
    By LOGIN_BEFORE_FOLLOW_BUTTON_LOCATOR = By.xpath("//div[@id='contentWrapper']//paper-button[@id='button' and @aria-label='Войти']");


    public YouTubeSearchPage(WebDriver driver){

        this.driver = driver;

    }

    public String getMainPageTitle(){

        return    driver.getTitle();

    }

    public void setSearchCriteria(String randomValue){
        WebElement searchInput = driver.findElement(SEARCH_INPUT_LOCATOR);
        searchInput.click();
        searchInput.sendKeys(randomValue);
    }



    public void selectItemFromSearchResults(int number) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("gstl_50 sbdd_c");
        WebElement searchResultsList = new WebDriverWait(driver, 10)
               .until(ExpectedConditions.visibilityOfElementLocated(SEARCH_LIST_LOCATOR));
 
        WebElement secondSearchResult = searchResultsList.findElements(SEARCH_LIST_ITEM_LOCATOR).get(number);
        secondSearchResult.click();
    }

    public void openVideo(){

        WebElement openVideo = driver.findElement(FOURTH_VIDEO_LOCATOR);
        openVideo.click();

    }

    public void subscribeToChanel(){

        WebElement followChanel = driver.findElement(SUBSCRIBE_BUTTON_LOCATOR);
        followChanel.click();
    }

    public String loginBeforeFollow(){

        return    driver.findElement(LOGIN_BEFORE_FOLLOW_BUTTON_LOCATOR).getText();

    }

}
