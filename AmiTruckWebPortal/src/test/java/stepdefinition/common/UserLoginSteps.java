package stepdefinition.common;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.common.LoginPage;
import pages.landing.LandingPage;

public class UserLoginSteps {
    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    LandingPage landingPage = new LandingPage(DriverFactory.getDriver());

    @Given("User is on the Login Page")
    public void userIsOnTheLoginPage() {
        DriverFactory.getDriver().get("https://customer.amitruck.com/#/");
    }

    @When("User Enters Valid Login Credentials {string}, {string} and clicks on the Login Button")
    public void userEntersValidLoginCredentialsAndClicksOnTheLoginButton(String mobileNo, String password) throws InterruptedException {
        loginPage.doLogin(mobileNo, password);
    }

    @Then("User should be Logged In and Navigated to the Landing Page")
    public void userShouldBeLoggedInAndNavigatedToTheLandingPage() {
        Assert.assertTrue(landingPage.isYourDeliveriesLinkDisplayed());
    }

    @Then("An Error Message Should be Displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isMissingCredentialsErrorMsgDisplayed());
    }

    @Then("An Account Does not Exist Error Message Should be Displayed")
    public void anAccountDoesNotExistErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isAccDoesNotExistErrorMsgDisplayed());
    }


}
