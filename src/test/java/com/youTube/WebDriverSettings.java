package com.youTube;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","K:\\DevTools\\chromedriver_1\\chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Test started");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        driver.quit();
        System.out.println("Test closed");
    }
}
