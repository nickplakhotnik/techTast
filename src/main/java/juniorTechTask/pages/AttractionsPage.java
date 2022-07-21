package juniorTechTask.pages;

import juniorTechTask.elements.Button;
import juniorTechTask.elements.TextField;
import juniorTechTask.utils.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AttractionsPage extends BaseForm {
    private TextField whereAreYouGoingTextField = new TextField(By.xpath("//input[@data-testid='search-input-field']"),
            "Searching Field");
    private Button searchButton = new Button(By.xpath("//span[contains(text(), 'Search')]"), "Search Button");
    private String DESTINATIONS = "//div[contains(text(),'Destinations')]";

    public AttractionsPage() {
        super(By.xpath("//div[@class='css-0']"), "Attractions Page");
    }

    public void setSearchingField(String place) {
        whereAreYouGoingTextField.sendKeys(place);
    }

    public void clickOnSearchButton() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.instanceWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(DESTINATIONS), "Destinations"));
        searchButton.clickAndWait();
    }
}
