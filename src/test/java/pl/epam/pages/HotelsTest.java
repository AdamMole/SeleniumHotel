package pl.epam.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;

public class HotelsTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("http://www.kurs-selenium.pl/demo/m-hotels");
    }

    @Test
    public void checkHotelNames(){
//        homePage.typeCity("Dubai")
//                .selectDates("25/08/2022","30/08/2022")
//                .setTravellers(3,3)
//                .clickSearchButton()
//                .checkHotelNames();

        String hotelName = homePage.typeCity("Dubai")
                .selectDates("25/10/2022","30/10/2022")
                .setTravellers(3,3)
                .clickSearchButton()
                .checkHotelNames()
                .getHotelName();

        Assert.assertEquals(hotelName, "Jumeirah Beach Hotel");
        Assert.assertTrue(hotelName.equals("Jumeirah Beach Hotel"));

//        assertThat(homePage.typeCity("Dubai")
//                .selectDates("25/08/2022","30/08/2022")
//                .setTravellers(3,3)
//                .clickSearchButton()
//                .checkHotelNames()
//                .getHotelName()).isEqualTo("Jumeirah Beach Hotel");

    }



}
