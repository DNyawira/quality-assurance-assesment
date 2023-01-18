package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    //Page Elements

    @FindBy(xpath = "//input[@id='phone-number-input']")
    private WebElement txtMobileNumber;
    @FindBy (xpath = "//input[@id='password']")
    private WebElement txtPassword;
    @FindBy(xpath = "//button[@id='login-btn']")
    private WebElement btnLogin;

    @FindBy(xpath = "//span[contains(text(),'Please enter a valid phone number and password')]")
    private WebElement errorMsgMissingCredentials;

    @FindBy(xpath = "//span[contains(text(),'Account with the phone number provided does not ex')]")
    private WebElement errorMsgAccountDoesNotExist;

    //User Actions
    public void enterMobileNumber(String mobileNumber)
    {
        txtMobileNumber.clear();
        txtMobileNumber.sendKeys(mobileNumber);
    }
    public void enterPassword(String password)
    {
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }
    public void clickLoginButton()
    {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
    }
    public boolean isMissingCredentialsErrorMsgDisplayed()
    {
        return errorMsgMissingCredentials.isDisplayed();
    }
    public boolean isAccDoesNotExistErrorMsgDisplayed()
    {
        return errorMsgAccountDoesNotExist.isDisplayed();
    }

    public void doLogin(String mobileNumber, String password) throws InterruptedException {
        enterMobileNumber(mobileNumber);
        enterPassword(password);
        Thread.sleep(Duration.ofSeconds(10));
        clickLoginButton();
    }
}
