package juniorTechTask.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class DriverUtil {

    private static WebDriver driver;
    private static Logger log = LoggerUtil.getLog(DriverUtil.class.getName());

    public static WebDriver instanceWebDriver() {
        if (driver == null) {
            log.info("Create WebDriver");
            driver = new WebDriverFactory().getWebDriver();
        }
        return driver;
    }

    public static void stopWebDriver() {
        log.info("Stop WebDriver");
        driver.quit();
        driver = null;
    }

}
