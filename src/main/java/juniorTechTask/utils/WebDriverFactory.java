package juniorTechTask.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import juniorTechTask.model.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    private GsonParser gsonParser = new GsonParser();
    private Config config = gsonParser.parseConfig();

    WebDriver getWebDriver(){
        switch (config.getBrowser()){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions());
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "Edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            case "Opera":
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            default:
                throw new RuntimeException("Incorrect BrowserName");
        }
    }

}
