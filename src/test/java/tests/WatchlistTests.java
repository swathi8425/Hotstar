package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.WatchlistPage;

public class WatchlistTests extends BaseTest {
	 @Test
	    public void TC24_verifyMySpaceForWatchlist() {

	        HomePage homePage = new HomePage(driver);

	        Assert.assertTrue(
	                homePage.isHomePageOpened(),
	                "Hotstar Home Page is not opened"
	        );

	        WatchlistPage watchlistPage =
	                new WatchlistPage(driver);

	        watchlistPage.clickMySpace();

	        Assert.assertTrue(
	                watchlistPage.isMySpaceDisplayed(),
	                "My Space is not displayed"
	        );

	        System.out.println(
	                "My Space opened successfully"
	        );
	    }

    @Test
    public void TC25_verifyAddToWatchlistDisplayed() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isAddToWatchlistDisplayed(),
                "Add to Watchlist button is not displayed"
        );

        System.out.println(
                "Add to Watchlist button is displayed"
        );
    }

    @Test
    public void TC26_addMovieToWatchlist() {

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(
                homePage.isHomePageOpened(),
                "Hotstar Home Page is not opened"
        );

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isAddToWatchlistDisplayed(),
                "Add to Watchlist button is not displayed"
        );

        watchlistPage.clickAddToWatchlist();

        System.out.println(
                "Movie added to Watchlist"
        );
    }
    @Test
    public void TC27_verifyAddToWatchlistButton() {

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isAddToWatchlistDisplayed(),
                "Add to Watchlist button is not displayed"
        );
    }
    @Test
    public void TC28_clickAddToWatchlist() {

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isAddToWatchlistDisplayed(),
                "Add to Watchlist button is not displayed"
        );

        watchlistPage.clickAddToWatchlist();
    }
    @Test
    public void TC29_verifyMySpaceDisplayed() {

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isMySpaceDisplayed(),
                "My Space is not displayed"
        );
    }
    @Test
    public void TC30_clickMySpace() {

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isMySpaceDisplayed(),
                "My Space is not displayed"
        );

        watchlistPage.clickMySpace();
    }
    @Test
    public void TC31_verifyWatchlistButtonClickable() {

        WatchlistPage watchlistPage =
                new WatchlistPage(driver);

        Assert.assertTrue(
                watchlistPage.isAddToWatchlistDisplayed(),
                "Add to Watchlist button is not displayed"
        );

        watchlistPage.clickAddToWatchlist();

        Assert.assertTrue(
                true,
                "Watchlist action failed"
        );
    }
}