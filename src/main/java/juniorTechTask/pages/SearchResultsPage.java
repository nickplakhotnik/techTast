package juniorTechTask.pages;

import juniorTechTask.elements.TextField;
import org.openqa.selenium.By;

public class SearchResultsPage extends BaseForm {
    private TextField destination = new TextField(By.xpath("//input[@name='ss']"), "Destination");
    private String VALUE = "value";
    private TextField checkInDate = new TextField(By.xpath("//button[@data-testid='date-display-field-start']"),
            "Check In Date");
    private TextField checkOutDate = new TextField(By.xpath("//button[@data-testid='date-display-field-end']"),
            "Check Out Date");

    public SearchResultsPage() {
        super(By.id("basiclayout"), "Search Results Page");
    }

    public String getDestination() {
        return destination.getAttribute(VALUE);
    }

    public String getCheckInDate() {
        return checkInDate.getText();
    }

    public String getCheckOutDate() {
        return checkOutDate.getText();
    }
}
