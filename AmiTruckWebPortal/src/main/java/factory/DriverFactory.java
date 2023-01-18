package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class DriverFactory {

    public WebDriver webDriver;
    public static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static Logger logger = LoggerFactory.getLogger(factory.DriverFactory.class);

    public WebDriver initializeDriver(String browser) {

        logger.info("Browser Value is:" + browser);
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriverThreadLocal.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriverThreadLocal.set(new FirefoxDriver());
        } else if (browser.equals("safari")) {
            WebDriverManager.chromedriver().setup();
            webDriverThreadLocal.set(new SafariDriver());
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            webDriverThreadLocal.set(new SafariDriver());
        } else {
            logger.info("Please pass the correct browser value:" + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }
}

