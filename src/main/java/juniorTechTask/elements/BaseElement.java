package juniorTechTask.elements;

import juniorTechTask.utils.DriverUtil;
import juniorTechTask.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class BaseElement {
    protected WebDriverWait wait = new WebDriverWait(DriverUtil.instanceWebDriver(), Duration.ofSeconds(10));
    private static Logger log = LoggerUtil.getLog(BaseElement.class.getName());
    private By locator;
    private String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        log.info("Click on element " + name);
        findElement().click();
    }

    public void clickAndWait() {
        wait.until(ExpectedConditions.visibilityOf(findElement()));
        click();
    }

    public boolean isDisplayed() {
        log.info("Сheck if the element is displayed");
        if(findElement() != null) {
            return findElement().isDisplayed();
        }
        return false;
    }

    protected WebElement findElement() {
        log.info("Create element " + name);
        return wait.until(ExpectedConditions.visibilityOf(DriverUtil.instanceWebDriver().findElement(locator)));
    }

    protected List<WebElement> findElements() {
        log.info("Create elements" + name);
        return DriverUtil.instanceWebDriver().findElements(locator);
    }

    public boolean isNotDisplayed() {
        log.info("Сheck if the element is not displayed");
        if(findElements().size() == 0) {
            return true;
        } return false;
    }

    public String getText() {
        log.info("Get text from " + name);
        return findElement().getText();
    }

    public String getAttribute(String name) {
        log.info("Get attribute " + name);
        return findElement().getAttribute(name);
    }
}
