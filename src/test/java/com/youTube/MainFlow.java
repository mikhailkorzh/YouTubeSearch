package com.youTube;

import org.junit.Assert;
import org.junit.Test;

public class MainFlow extends WebDriverSettings {

    YouTubeSearchPage objSearch;

    @Test
    public void mainFlow() {

        objSearch = new YouTubeSearchPage(driver);

        int a = 0;
        int b = 99;
        int random_number1 = a + (int) (Math.random() * b);
        int random_number2 = a + (int) (Math.random() * b);
        String randomValue1 = String.valueOf(random_number1);
        String randomValue2 = String.valueOf(random_number2);

        String mainPageHeader = objSearch.getMainPageTitle();
        Assert.assertTrue(mainPageHeader.contains("YouTube"));
        objSearch.setSearchCriteria(randomValue1 + randomValue2);
        objSearch.selectItemFromSearchResults(1);
        objSearch.openVideo();
        objSearch.subscribeToChanel();
        String loginBeforeFollow = objSearch.loginBeforeFollow().toUpperCase();
        Assert.assertTrue(loginBeforeFollow.contains("ВОЙТИ"));


    }
}
