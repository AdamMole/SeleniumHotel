package pl.epam.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HotelsTest {

    private static WebDriver driver;
    private static HomePage homePage;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        driver.get("http://www.kurs-selenium.pl/demo/m-hotels");
    }

    @Test
    public void checkHotelNamesTest(){
//        homePage.typeCity("Dubai")
//                .selectDates("25/08/2022","30/08/2022")
//                .setTravellers(3,3)
//                .clickSearchButton()
//                .checkHotelNamesTest();

        String hotelName = homePage.typeCity("Dubai")
                .selectDates("25/02/2023","26/02/2023")
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
//                .checkHotelNamesTest()
//                .getHotelName()).isEqualTo("Jumeirah Beach Hotel");

    }
    @AfterTest
    public void tearDown() {
        driver.close();
    }
}
