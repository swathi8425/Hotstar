
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.SearchPage;

public class SearchTests extends BaseTest {

    @Test
    public void TC16_verifySearchBoxDisplayed() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        // Click Search icon
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        System.out.println(
                "Search box is displayed successfully"
        );
    }


    @Test
    public void TC17_searchMovie() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        // Open Search
        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        // Search movie
        searchPage.enterMovieName("Pushpa");

        Assert.assertEquals(
                searchPage.getSearchText(),
                "Pushpa",
                "Movie name was not entered correctly"
        );

        System.out.println(
                "Movie searched successfully"
        );
    }


    @Test
    public void TC18_verifySearchText() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("RRR");

        String actualText = searchPage.getSearchText();

        Assert.assertEquals(
                actualText,
                "RRR",
                "Search text is incorrect"
        );

        System.out.println(
                "Search text verified: " + actualText
        );
    }
    @Test
    public void TC19_verifySearchInputText() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("Avengers");

        Assert.assertEquals(
                searchPage.getSearchText(),
                "Avengers",
                "Search text is incorrect"
        );
    }
    @Test
    public void TC20_searchValidMovie() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("Avengers");

        Assert.assertEquals(
                searchPage.getSearchText(),
                "Avengers",
                "Movie search text is incorrect"
        );
    }
    @Test
    public void TC21_searchAnotherMovie() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("Pushpa");

        Assert.assertEquals(
                searchPage.getSearchText(),
                "Pushpa",
                "Search text is incorrect"
        );
    }
    @Test
    public void TC22_searchInvalidMovie() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("XYZ123456789");

        Assert.assertEquals(
                searchPage.getSearchText(),
                "XYZ123456789",
                "Invalid search text was not entered correctly"
        );
    }
    @Test
    public void TC23_verifySearchBoxAcceptsText() {

        HomePage homePage = new HomePage(driver);

        homePage.clickSearch();

        SearchPage searchPage = new SearchPage(driver);

        Assert.assertTrue(
                searchPage.isSearchBoxDisplayed(),
                "Search box is not displayed"
        );

        searchPage.enterMovieName("Cricket");

        Assert.assertFalse(
                searchPage.getSearchText().isEmpty(),
                "Search box did not accept text"
        );
    }
}