package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SubscriptionPage;

public class SubscriptionTests extends BaseTest {

    @Test
    public void TC32_verifyMySpaceDisplayed() {

        SubscriptionPage subscriptionPage =
                new SubscriptionPage(driver);

        Assert.assertTrue(
                subscriptionPage.isMySpaceDisplayed(),
                "My Space is not displayed"
        );
    }

    @Test
    public void TC33_verifyPremiumDisplayed() {

        SubscriptionPage subscriptionPage =
                new SubscriptionPage(driver);

        Assert.assertTrue(
                subscriptionPage.isMySpaceDisplayed(),
                "My Space is not displayed"
        );

        subscriptionPage.clickMySpace();

        Assert.assertTrue(
                subscriptionPage.isPremiumDisplayed(),
                "Premium is not displayed"
        );
    }
    @Test
    public void TC34_verifyPaymentDetailsDisplayed() {

        SubscriptionPage subscriptionPage =
                new SubscriptionPage(driver);

        subscriptionPage.clickMySpace();

        Assert.assertTrue(
                subscriptionPage.isPremiumDisplayed(),
                "Premium is not displayed"
        );

        subscriptionPage.clickPremium();

        Assert.assertTrue(
                subscriptionPage.isPaymentDetailsDisplayed(),
                "Payment Details is not displayed"
        );
    }
}