package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SubscriptionPage;

public class SubscriptionTests extends BaseTest {

    @Test
    public void verifySubscriptionPage() {

        // Home page is opened by BaseTest

        SubscriptionPage subscription = new SubscriptionPage(driver);

        // 1. Click MySpace
        subscription.clickMySpace();

        // 2. Select Premium
        subscription.selectPremium();

        // 3. Click Payment Details
        subscription.clickPaymentDetails();

        // 4. Click Continue
        subscription.clickContinue();

        // 5. Verify Subscription page
        Assert.assertTrue(
                subscription.isSubscriptionPageDisplayed(),
                "Subscription page was not displayed"
        );

        System.out.println("Subscription page displayed successfully");
    }
}
