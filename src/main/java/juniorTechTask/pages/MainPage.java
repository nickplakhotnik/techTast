package juniorTechTask.pages;

import juniorTechTask.elements.Button;
import juniorTechTask.elements.TextField;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    private TextField searchWhereAreYouGoing = new TextField(By.id("ss"), "Search input text field where are you going");
    private Button searchButton = new Button(By.xpath("//span[@class='js-sb-submit-text ']"), "Search Button");
    private Button openCalendar = new Button(By.xpath("//div[@class='xp__dates-inner']"), "Open Calendar Button");
    private String MONTH_YEAR_CALENDAR_LOC = "//div[contains(text(), '%s')]";
    private Button nextMonthButtonForCalendar = new Button(By.xpath("//div[contains(@class, 'bui-calendar__control--next')]"),
            "Next Month Button For Calendar");
    private String DATA_IN = "//span[@aria-label='%s']";
    private Button languageButton = new Button(By.xpath("//span[@class='bui-button__text']//span[contains(text(), 'language')]"),
            "Language Button");
    private String VALUE = "value";
    private TextField chosenCheckIn = new TextField(By.xpath("//div[@data-placeholder='Check-in']"),
            "Chosen Check In");
    private TextField chosenCheckOut = new TextField(By.xpath("//div[@data-placeholder='Check-out']"),
            "Chosen Check Out");
    private Button attractionsButton = new Button(By.xpath("//span[contains(text(), 'Attractions')]"),
            "Attractions Button");

    public MainPage() {
        super(By.xpath("//div[@class='hero-banner-searchbox']"), "Main Page");
    }

    public void inputPlaceToGo(String place) {
        searchWhereAreYouGoing.sendKeys(place);
    }

    public void clickOnSearch() {
        searchButton.click();
    }

    public void chooseDatesForBooking(String checkIn, String checkOut) {
        openCalendar.clickAndWait();
        String[] dataCheckIn = checkIn.split(" ");
        while (isMonthAndYearOpenInCalendar(dataCheckIn[1].concat(" ").concat(dataCheckIn[2]))) {
            clickOnNextMonthButtonForCalendar();
        }
        selectDataInCalendar(checkIn);

        String[] dataCheckOut = checkOut.split(" ");
        while (isMonthAndYearOpenInCalendar(dataCheckOut[1].concat(" ").concat(dataCheckOut[2]))) {
            clickOnNextMonthButtonForCalendar();
        }
        selectDataInCalendar(checkOut);
    }

    private boolean isMonthAndYearOpenInCalendar(String monthYear) {
        return new TextField(By.xpath(String.format(MONTH_YEAR_CALENDAR_LOC, monthYear)), "Month Year Button").isNotDisplayed();
    }

    private void clickOnNextMonthButtonForCalendar() {
        nextMonthButtonForCalendar.clickAndWait();
    }

    private void selectDataInCalendar(String data) {
        new Button(By.xpath(String.format(DATA_IN, data)), "Data").click();
    }

    public String getCurrentLanguage() {
        return languageButton.getText();
    }

    public String getChosenCity() {
        return searchWhereAreYouGoing.getAttribute(VALUE);
    }

    public String getChosenCheckIn() {
        return chosenCheckIn.getText();
    }

    public String getChosenCheckOut() {
        return chosenCheckOut.getText();
    }

    public void clickOnAttractionsButton() {
        attractionsButton.clickAndWait();
    }
}
