package com.entrevista.sinqia.service.agi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class SelleniumService {

    private static final String URL_BLOG_AGI = "https://blogdoagi.com.br";

    public List<WebElement> doBlogAgiSearch(String textSearch) {
        WebDriver driver = buildFirefoxDriver(URL_BLOG_AGI);
        driver.findElement(By.id("search-open")).click();
        driver.findElements(By.className("search-field")).get(0).sendKeys(textSearch);
        driver.findElements(By.className("search-submit")).get(0).click();
        List<WebElement> webElementList = driver.findElements(By.tagName("article"));

        if (!webElementList.isEmpty()) {
            System.out.println("Found " + webElementList.size() + " articles");

        } else {
            System.out.println("No articles found");
        }

        return webElementList;
    }

    private WebDriver buildFirefoxDriver(String url) {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

}
