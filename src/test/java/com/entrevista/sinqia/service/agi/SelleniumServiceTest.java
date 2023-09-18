package com.entrevista.sinqia.service.agi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelleniumServiceTest {

    private static final String TEXT_SEARCH_ARTICLES_FOUND = "Portabilidade";
    private static final String TEXT_SEARCH_ARTICLES_NOT_FOUND = "Chandler Bing";

    private SelleniumService selleniumService;

    @BeforeEach
    public void setUp() {
        selleniumService = new SelleniumService();
    }

    @Test
    public void shouldDoBlogAgiSearchWithArticlesFound() {

        // arrange
        List<WebElement> webElementList;

        // act
        webElementList = selleniumService.doBlogAgiSearch(TEXT_SEARCH_ARTICLES_FOUND);

        // assert
        assert !webElementList.isEmpty();
    }

    @Test
    public void shouldDoBlogAgiSearchWithArticlesNotFound() {

        // arrange
        List<WebElement> webElementList;

        // act
        webElementList = selleniumService.doBlogAgiSearch(TEXT_SEARCH_ARTICLES_NOT_FOUND);

        // assert
        assert webElementList.isEmpty();
    }

}
