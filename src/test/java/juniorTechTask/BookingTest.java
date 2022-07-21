package juniorTechTask;

import juniorTechTask.pages.MainPage;

import juniorTechTask.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingTest extends BaseTest {

    @Test
    public void searchingTest() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpened(), "Main Page is not open");
        Assert.assertTrue(mainPage.getCurrentLanguage().contains(testData.getLanguage()), "Language is not correct");

        mainPage.inputPlaceToGo(testData.getCity());
        Assert.assertEquals(mainPage.getChosenCity(), testData.getCity());

        mainPage.chooseDatesForBooking(testData.getDataIn(), testData.getDataOut());
        Assert.assertEquals(mainPage.getChosenCheckIn(), testData.getCurrentDataIn(), "Chosen Check In is not correct");
        Assert.assertEquals(mainPage.getChosenCheckOut(), testData.getCurrentDataOut(), "Chosen Check out is not correct");

        mainPage.clickOnSearch();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        Assert.assertTrue(searchResultsPage.isPageOpened(), "Search Results Page is not open");
        Assert.assertEquals(searchResultsPage.getDestination(), testData.getCity(), "City in results is not correct");
        Assert.assertTrue(searchResultsPage.getCheckInDate().contains(testData.getCurrentResultDataIn()),
                "CheckIn in results is not correct");
        Assert.assertTrue(searchResultsPage.getCheckOutDate().contains(testData.getCurrentResultDataOut()),
                "CheckOut in results is not correct");
    }

}
