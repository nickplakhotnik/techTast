package juniorTechTask.elements;

import juniorTechTask.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.logging.Logger;

public class TextField extends BaseElement {
    private static Logger log = LoggerUtil.getLog(TextField.class.getName());
    private String name;
    private By locator;

    public TextField(By locator, String name) {
        super(locator, name);
        this.name = name;
        this.locator = locator;
    }

    public void sendKeys(String text) {
        click();
        findElement().sendKeys(text);
    }
}
