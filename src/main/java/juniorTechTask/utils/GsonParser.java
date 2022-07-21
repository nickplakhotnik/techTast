package juniorTechTask.utils;

import com.google.gson.Gson;
import juniorTechTask.model.Config;
import juniorTechTask.model.TestData;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class GsonParser {
    private static Logger log = LoggerUtil.getLog(GsonParser.class.getName());
    private Gson gson;
    private String configFile = "src\\main\\resources\\config.json";
    private String testDataFile = "src\\test\\resources\\testData.json";

    public Config parseConfig() {
        gson = new Gson();
        try(FileReader reader = new FileReader(configFile)) {
            log.info("parse file " + configFile);
            return gson.fromJson(reader, Config.class);
        } catch (IOException e) {
            log.info("file " + configFile + " not found ");
            e.printStackTrace();
        }
        return null;
    }

    public TestData parseTestData() {
        gson = new Gson();
        try(FileReader reader = new FileReader(testDataFile)) {
            log.info("parse file " + testDataFile);
            return gson.fromJson(reader, TestData.class);
        } catch (IOException e) {
            log.info("file " + testDataFile + " not found ");
            e.printStackTrace();
        }
        return null;
    }
}
