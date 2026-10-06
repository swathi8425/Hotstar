package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchlistPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // My Space
    private By mySpace =
            By.xpath("//*[normalize-space()='My Space']");

    // Add to Watchlist
    private By addToWatchlist =
            By.cssSelector(
                    "button[aria-label='Add to watchlist']"
            );

    public WatchlistPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    // Click My Space
    public void clickMySpace() {

        WebElement mySpaceElement = wait.until(
                ExpectedConditions.elementToBeClickable(mySpace)
        );

        mySpaceElement.click();
    }

    // Verify My Space is displayed
    public boolean isMySpaceDisplayed() {

        try {

            WebElement mySpaceElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            mySpace
                    )
            );

            return mySpaceElement.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "My Space is not displayed: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // Verify Add to Watchlist button
    public boolean isAddToWatchlistDisplayed() {

        try {

            WebElement button = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            addToWatchlist
                    )
            );

            return button.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Add to Watchlist button is not displayed: "
                    + e.getMessage()
            );

            return false;
        }
    }

    // Click Add to Watchlist
    public void clickAddToWatchlist() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(
                        addToWatchlist
                )
        );

        button.click();
    }
}