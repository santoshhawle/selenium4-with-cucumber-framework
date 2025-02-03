package roboticqa.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public enum BrowserType {
        CHROME,
        FIREFOX
    }
    public static WebDriver getDriver(BrowserType browserType) {
        if (driver.get() == null) {
            switch (browserType) {
                case CHROME:
                    driver.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
