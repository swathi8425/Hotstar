
	package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test
    public void verifySearchInput() {

        HomePage homePage = new HomePage(driver);

        // First open Search
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        // Then check search input
        Assert.assertTrue(
            searchPage.isSearchInputDisplayed(),
            "Search input is not displayed"
        );
    }

    @Test
    public void verifySearchMovie() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
            searchPage.isSearchInputDisplayed(),
            "Search input is not displayed"
        );

        searchPage.enterSearch("Criminal Justice");

        Assert.assertTrue(
            driver.getCurrentUrl().contains("hotstar"),
            "Search was not performed"
        );
    }
}