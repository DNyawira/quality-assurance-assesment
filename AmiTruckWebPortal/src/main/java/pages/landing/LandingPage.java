package pages.landing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPage {
    WebDriver webDriver;

    public LandingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //Page Elements
    @FindBy(xpath = "//a[contains(text(),'Your deliveries')]")
    private WebElement lnkYourDeliveries;
    @FindBy(xpath = "//input[@id='stop0']")
    private WebElement txtPickUpLocation;
    @FindBy(xpath = "//input[@id='stop1']")
    private WebElement txtDestinationLocation;
    @FindBy(xpath = "//button[contains(text(),'Next')]")
    private WebElement btnNext;
    @FindBy(xpath = "//textarea[@id='deliveryDescription']")
    private WebElement txtDeliveryDescription;
    @FindBy(xpath =  "//input[@id='wantInsuranceNo']")
    private  WebElement chkInsurance;


    //Actions
    public boolean isYourDeliveriesLinkDisplayed() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return webDriverWait.until(ExpectedConditions.visibilityOf(lnkYourDeliveries)).isDisplayed();
    }

    public void enterPickUp(String pickUpLocation) {
        txtPickUpLocation.clear();
        txtPickUpLocation.sendKeys(pickUpLocation);
    }

    public void enterDestination(String destinationLocation) {
        txtDestinationLocation.clear();
        txtDestinationLocation.sendKeys(destinationLocation);
    }

    public void selectVehicle(String vehicle) {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='" + vehicle + "']"))).click();
    }

    public void clickNextButton() {
        btnNext.click();
    }
    public void enterDeliveryDescription(String deliveryDescription)
    {
        txtDeliveryDescription.clear();
        txtDeliveryDescription.sendKeys(deliveryDescription);
    }
    public void selectInsurance()
    {
        chkInsurance.click();
    }

    public void bookDelivery(String pickUpLocation, String destinationLocation, String vehicle, String deliveryDescription)
    {
        enterPickUp(pickUpLocation);
        enterDestination(destinationLocation);
        selectVehicle(vehicle);
        clickNextButton();
        enterDeliveryDescription(deliveryDescription);
        selectInsurance();
    }
}
