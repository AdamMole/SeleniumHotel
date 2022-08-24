package pl.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.epam.utility.Page;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchByCity;

    @FindBy(xpath =  "//div[@id='select2-drop']//input")
    private WebElement typeCity;

    @FindBy(xpath = "//span[@class='select2-match']")
    private WebElement highlightedCity;

    @FindBy(css = "[name='checkin']")
    private WebElement checkIn;

    @FindBy(css = "[name='checkout']")
    private WebElement checkOut;

    @FindBy(id = "travellersInput")
    private WebElement travellers;

    @FindBy(id="adultInput")
    private WebElement adults;

    @FindBy(id="childInput")
    private WebElement child;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    //driver.findElements(By.xpath("//li[@id='li_myaccount']")).stream()
    //                                                      .filter(WebElement::isDisplayed)
    //                                                      .findFirst()
    //                                                      .ifPresent(WebElement::click);
    public HomePage typeCity(String city){
        searchByCity.click();
        typeCity.sendKeys(city);
        System.out.println("Wpisane miasto: " + city);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(highlightedCity));
        highlightedCity.click();
        return this;
    }

    public HomePage selectDates(String checkInDate, String checkOutDate){
        checkIn.sendKeys(checkInDate);
        System.out.println("Wpisana data check inu: " + checkInDate);
        checkOut.sendKeys(checkOutDate);
        System.out.println("Wpisana data check outu: " + checkOutDate);
        return this;
    }

    public HomePage setTravellers(int adultsNumber, int childNumber){
        travellers.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(adults));
        adults.clear();
        adults.sendKeys(String.valueOf(adultsNumber));
        child.clear();
        child.sendKeys(String.valueOf(childNumber));
        return this;
    }

    public HotelListPage clickSearchButton(){
        searchButton.click();
        System.out.println("Kliknąłem w przycisk 'Search'");
        return new HotelListPage(driver);
    }




}
