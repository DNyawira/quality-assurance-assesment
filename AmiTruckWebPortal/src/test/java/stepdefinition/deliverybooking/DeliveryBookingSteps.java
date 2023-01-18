package stepdefinition.deliverybooking;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import pages.landing.LandingPage;

public class DeliveryBookingSteps {
    LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @And("Enters the delivery Details {string}, {string}, {string} and {string}")
    public void entersTheDeliveryDetailsAnd(String pickUpLocation, String deliveryLocation, String vehicle, String deliveryDescription) {
        landingPage.bookDelivery(pickUpLocation, deliveryLocation, vehicle, deliveryDescription);
    }
}
