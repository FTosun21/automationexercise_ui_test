package com.automationExercises.pages;


import com.automationExercises.utilities.ConfigurationReader;
import com.automationExercises.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.Random;
import static com.automationExercises.utilities.BrowserUtils.*;
import static org.junit.Assert.assertTrue;

public abstract class BasePage {
    protected Faker faker = new Faker();
    protected String company;
    protected String state;
    protected String city;
    protected String zipCode;
    protected String country;
    protected String mobileNumber;
    protected String address;

    protected BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public Boolean isMenuSelected(String menu) {
        Boolean flag = false;
        By l_menu = By.partialLinkText(menu);
        WebElement baseMenu = Driver.get().findElement(l_menu);
        String menuColor = baseMenu.getAttribute("style");
        if (menuColor.equals("color: orange;")) {
            flag = true;
        }
        return flag;
    }

    public void verifyMenu(String menu) {
        assertTrue(isMenuSelected(menu));
    }

    public void verifyText(String text) {
        By l_text = By.xpath("//*[contains(text(),'"+text+"')]/..");
        WebElement textElem = waitForVisibility(l_text,5);
        String actualText = textElem.getText().toUpperCase();
        System.out.println("actualText = " + actualText);
        assertTrue("ExpectedText is not displayed: ", actualText.contains(text.toUpperCase()));
    }
    public void clickMenu(String menu) {
        By l_menu = By.partialLinkText(menu);
        waitForVisibility(l_menu, 10).click();
    }

    public void clickButton(String button) {
        By buttonElem = By.xpath("//*[text()='" + button + "']");
        waitForClickablility(buttonElem, 10).click();
    }

    public void selectByValueFromDropDown(WebElement element, String option) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(option);
    }

    // Rastgele ülke seçimi yapan method
    public String selectRandomValue(WebElement dropDown) {

        // Select sınıfını kullanarak dropdown'u yönet
        Select select = new Select(dropDown);

        // Dropdown'daki tüm seçenekleri al
        List<WebElement> selectOptions = select.getOptions();

        // Seçenekleri array veya list şeklinde sakla (ilk option genellikle placeholder'dır, o yüzden 1. indexten başlıyoruz)
        int totalOptions = selectOptions.size();

        // Random sınıfı kullanarak rastgele bir index seç (1'den başlatıyoruz, çünkü genelde ilk option boş olabilir)
        Random random = new Random();
        int randomIndex = random.nextInt(totalOptions - 1) + 1; // 1 ile totalOptions arasında rastgele bir sayı

        // Rastgele seçilen option'un value'sunu al
        return selectOptions.get(randomIndex).getAttribute("value");
    }

    // Rastgele seçim yapmak için kullanılabilecek method
    public void randomSelectForAnyDropdown(WebElement dropdownElement, String option) {
        String randomValue;
        if (dropdownElement.getText().contains(option)) {
            randomValue = option;
        }
        // Rastgele seçilen değeri al
        randomValue = selectRandomValue(dropdownElement);
        // Rastgele seçimi dropdown'dan yap
        selectByValueFromDropDown(dropdownElement, randomValue);
    }
    public void clearAndSendKeys(WebElement locator, String value) {
        WebElement element = waitForVisibility(locator, 5);
        element.clear();
        element.sendKeys(value);
    }

    // Sabit adres bilgilerini içeren array
    private static final String[] ADDRESS_DETAILS = {
            ConfigurationReader.get("fullName"),
            "Lakin Group",
            "716 Nicolas Gardens, P.O. Box 1234, Lakin Group",
            "New Magaliton New York 61902",
            "Singapore",
            "1-784-688-9978"
    };

    public void setAddressDetails() {
        this.company = ADDRESS_DETAILS[1];
        this.address = ADDRESS_DETAILS[2];
        this.state = ADDRESS_DETAILS[3].split(" ")[0]; // State bilgisi burada ilk kelime olarak alındı
        this.city = ADDRESS_DETAILS[3].split(" ")[1]; // City bilgisi burada ikinci kelime olarak alındı
        this.zipCode = ADDRESS_DETAILS[3].split(" ")[2]; // Zip Code bilgisi burada üçüncü kelime olarak alındı
        this.country = ADDRESS_DETAILS[4];
        this.mobileNumber = ADDRESS_DETAILS[5];
    }

}
