package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By mySpace =
            By.xpath("//*[normalize-space()='My Space']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isHomePageOpened() {
        return driver.getCurrentUrl().contains("hotstar");
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickMySpace() {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(mySpace)
        );

        element.click();
    }

    public void clickSearch() {

        By searchIcon =
                By.cssSelector("i.icon-search-line");

        WebElement icon = wait.until(
                ExpectedConditions.presenceOfElementLocated(searchIcon)
        );

        System.out.println("Search icon found");

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].click();",
                        icon
                );

        System.out.println("Search icon clicked using JavaScript");
    }
}