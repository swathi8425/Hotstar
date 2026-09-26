package pages;



	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WatchlistPage {

	   
	    private WebDriverWait wait;

	    public WatchlistPage(WebDriver driver) {
	        
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    }

	   
	    private By mySpace = By.xpath(
	        "//*[normalize-space()='My Space']"
	    );
	   


	    private By addToWatchlist = By.xpath(
	    	    "//button[@aria-label='Add to watchlist']"
	    	);

	    private By watchlistHeading = By.xpath(
		        "//*[normalize-space()='My Space']"
		    );

	    public void openMySpace() {

	        WebElement element = wait.until(
	            ExpectedConditions.elementToBeClickable(mySpace)
	        );

	        element.click();
	    }

	    public void addMovieToWatchlist() {

	        WebElement element = wait.until(
	            ExpectedConditions.elementToBeClickable(addToWatchlist)
	        );

	        element.click();
	    }

	    public boolean isWatchlistDisplayed() {

	        try {

	            return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(
	                    watchlistHeading
	                )
	            ).isDisplayed();

	        } catch (Exception e) {

	            return false;
	        }
	    }
	}


