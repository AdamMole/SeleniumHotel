package pl.epam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.epam.utility.Page;

import java.util.List;
import java.util.stream.Collectors;

public class HotelListPage extends Page {
    public HotelListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h4[contains(@class, 'list_title')]//b")
    private List<WebElement> hotelNames;

    List<String> hotele = driver.findElements(By.xpath("//h4[contains(@class, 'list_title')]//b")).stream()
            .map(el -> el.getText())
            .collect(Collectors.toList());

    public HotelListPage checkHotelNames(){
        System.out.println("Liczba hoteli na liście: "+hotelNames.size());
        hotelNames.forEach(el -> System.out.println(el.getAttribute("textContent")));
        return this;
    }

    public String getHotelName(){
        System.out.println("Pobrana nazwa hotelu to: "+ hotelNames.get(0).getText());
        return hotelNames.get(0).getText();
        //Jumeirah Beach Hotel
    }

    public List<String> getHotelNames(){
        return hotelNames.stream()
                .map(el -> el.getAttribute("textContent"))
                .collect(Collectors.toList());
    }


}
