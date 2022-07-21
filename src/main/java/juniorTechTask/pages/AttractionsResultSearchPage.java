package juniorTechTask.pages;

import juniorTechTask.elements.TextField;
import org.openqa.selenium.By;

public class AttractionsResultSearchPage extends BaseForm {

    private TextField cityInSearching = new TextField(By.xpath("//div//h1[contains(text(), 'New York Attractions')]"),
            "City In Searching");

    public AttractionsResultSearchPage() {
        super(By.xpath("//div[@class='css-wuc7a6']"), "Attractions Result Search Page");
    }

    public String getCityInSearching() {
        return cityInSearching.getText();
    }
}
