package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScenario {

    protected static WebDriver driver = null;

    /**
     * Get the driver with devices
     */
    public WebDriver getDriver() {
        if (null != driver) {
            return driver;
        }

        // Environment variables
        String browserName = (String) System.getProperty("browserName", "googlechrome");
        String driverDirectory = System.getProperty("user.dir") + "\\drivers\\";
        String driverLocation = System.getProperty("driverLocation", driverDirectory);
        String machineType = System.getProperty("machineType", "");

        if (browserName.equalsIgnoreCase("googlechrome")) {

            /* Chrome Local */
            if (machineType.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
            }
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("ie")) {

            /* IE Local */
            System.setProperty("webdriver.ie.driver", driverLocation + "IEDriverServer.exe");
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            ieCapabilities.setCapability("ignoreZoomSetting", true);
            driver = new InternetExplorerDriver(ieCapabilities);

        } else if (browserName.equalsIgnoreCase("safari")) {

            /* Safari Driver */
            driver = new SafariDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {

            /* Firefox */
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void waitForElementToBeClickable(By by) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        Thread.sleep(3000); //TODO:
    }

    /**
     * Get Site Url from pom.xml properties or command line -DsiteUrl
     */
    public String getSiteBaseUrl() {
        return (String) System.getProperty("siteUrl");
    }

    /**
     * Close Driver: delete all cookies for new session, tearDownClass() will handle closing the driver
     */
    public static void closeDriver() {
        if (null != driver) {
            driver.manage().deleteAllCookies();
        }
    }

    /**
     * Quit Driver: tearDownClass() will handle closing the driver
     */
    public static void quitDriver() {
        if (null != driver) {
            driver.quit();
        }
    }

}
