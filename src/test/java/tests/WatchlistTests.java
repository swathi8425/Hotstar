
	package tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import base.BaseTest;
	import pages.HomePage;
	import pages.WatchlistPage;

	public class WatchlistTests extends BaseTest {

	    // TC06
	    @Test
	    public void verifyMySpaceDisplayed() {

	        WatchlistPage watchlistPage =
	                new WatchlistPage(driver);

	        try {

	            watchlistPage.openMySpace();

	            Assert.assertTrue(
	                watchlistPage.isWatchlistDisplayed(),
	                "My Space / Watchlist is not displayed"
	            );

	        } catch (Exception e) {

	            Assert.fail(
	                "My Space could not be opened. Login may be required."
	            );
	        }
	    }

	    // TC07
	    @Test
	    public void verifyWatchlistButton() {

	        HomePage homePage = new HomePage(driver);

	        homePage.clickSearch();

	        Assert.assertTrue(
	            driver.getCurrentUrl().contains("hotstar"),
	            "Search page not opened"
	        );
	    }

	    // TC08
	    @Test
	    public void verifyWatchlistNavigation() {

	        WatchlistPage watchlistPage =
	                new WatchlistPage(driver);

	        try {

	            watchlistPage.openMySpace();

	            Assert.assertTrue(
	                driver.getCurrentUrl().contains("hotstar"),
	                "My Space navigation failed"
	            );

	        } catch (Exception e) {

	            Assert.fail("My Space navigation failed");
	        }
	    }
	}

