package juniorTechTask;

import juniorTechTask.model.Config;
import juniorTechTask.model.TestData;
import juniorTechTask.utils.GsonParser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected DriverManager driverManager = new DriverManager();
    private GsonParser gsonParser = new GsonParser();
    private Config config = gsonParser.parseConfig();
    protected TestData testData = gsonParser.parseTestData();

    @BeforeTest
    public void beforeMethod() {
        driverManager.openURL(config.getStartURL());
    }

    @AfterTest
    public void afterMethod() {
        driverManager.closeBrowser();
    }

}
