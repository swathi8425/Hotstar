package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By searchInput =
            By.cssSelector("input#searchBar");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public boolean isSearchBoxDisplayed() {

        try {
            WebElement searchBox = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(searchInput)
            );

            System.out.println("Search box found: " + searchBox.isDisplayed());

            return searchBox.isDisplayed();

        } catch (Exception e) {

            System.out.println(
                    "Search box not found after 30 seconds."
            );

            System.out.println(
                    "Current URL: " + driver.getCurrentUrl()
            );

            return false;
        }
    }

    public void enterMovieName(String movieName) {

        WebElement searchBox = wait.until(
                ExpectedConditions.elementToBeClickable(searchInput)
        );

        searchBox.clear();
        searchBox.sendKeys(movieName);
    }

    public String getSearchText() {

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchInput)
        );

        return searchBox.getAttribute("value");
    }
}