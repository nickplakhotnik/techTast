package juniorTechTask.pages;

import juniorTechTask.utils.DriverUtil;
import juniorTechTask.utils.LoggerUtil;
import org.openqa.selenium.By;

import java.util.logging.Logger;

public class BaseForm {
    private static Logger log = LoggerUtil.getLog(BaseForm.class.getName());
    private String name;
    private By uniqElement;

    public BaseForm(By uniqElement, String name) {
        this.uniqElement = uniqElement;
        this.name = name;
    }

    public boolean isPageOpened() {
        log.info("Checking if the " + name + " is open");
        return DriverUtil.instanceWebDriver().findElement(uniqElement).isDisplayed();
    }
}
