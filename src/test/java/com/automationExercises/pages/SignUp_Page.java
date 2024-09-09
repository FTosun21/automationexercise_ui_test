package com.automationExercises.pages;

import static com.automationExercises.utilities.BrowserUtils.*;

import com.automationExercises.utilities.ConfigurationReader;
import com.automationExercises.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class SignUp_Page extends BasePage {

    @FindBy(id = "id_gender1")
    public WebElement l_genderTitle_radioBtn;
    @FindBy(id = "name")
    public WebElement l_name_InputBox;
    @FindBy(id = "password")
    public WebElement l_password_InputBox;
    @FindBy(id = "days")
    public WebElement l_DateOfBirth_days;
    @FindBy(id = "months")
    public WebElement l_DateOfBirth_months;
    @FindBy(id = "years")
    public WebElement l_DateOfBirth_years;
    @FindBy(id = "newsletter")
    public WebElement l_newsletter_chkBox;
    @FindBy(id = "optin")
    public WebElement l_specialOffers_chkBox;
    @FindBy(id = "first_name")
    public WebElement l_first_name_InputBox;
    @FindBy(id = "last_name")
    public WebElement l_last_name_InputBox;
    @FindBy(id = "company")
    public WebElement l_company_InputBox;
    @FindBy(id = "address1")
    public WebElement l_address1_InputBox;
    @FindBy(id = "country")
    public WebElement l_country_DropDownMenu;
    @FindBy(id = "state")
    public WebElement l_state_InputBox;
    @FindBy(id = "city")
    public WebElement l_city_InputBox;
    @FindBy(id = "zipcode")
    public WebElement l_zipcode_InputBox;
    @FindBy(id = "mobile_number")
    public WebElement l_mobile_number_InputBox;


   public void signUp_login(List<String> inputInfo, String actionType) {
        String email = faker.internet().emailAddress();  // Rastgele email üretimi

        // Eğer 'actionType' login ise email ve password alanlarını kullan
        if (actionType.toLowerCase().equals("login")) {
            inputInfo = Arrays.asList("email", "password");
        }
        // Eğer 'actionType' signup ise name ve email alanlarını kullan
        else if (actionType.toLowerCase().equals("signup")) {
            inputInfo = Arrays.asList("name", "email");
            ConfigurationReader.set("email", email); // Rastgele email signup için ayarlanıyor
        }

        // Tüm input alanlarını doldur
        for (String info : inputInfo) {
            // action attribute'a göre input alanını seç
            WebElement inputBox = Driver.get().findElement(By.cssSelector("[action='/" + actionType + "'] [name='" + info + "']"));

            // Input alanlarını doldur
            switch (info) {
                case "name":
                    inputBox.sendKeys(ConfigurationReader.get("fullName"));
                    break;
                case "email":
                    inputBox.sendKeys(ConfigurationReader.get("email"));
                    break;
                case "password":
                    inputBox.sendKeys(ConfigurationReader.get("password"));
                    break;
                default:
                    System.out.println("Geçersiz input: " + info);
                    break;
            }
        }
        // Butona tıklama işlemi
        clickButton(actionType.equals("login") ? "Login" : "Signup");
    }

    public void newUserSingUp(String createAccountBtn) {
        signUp_login(Arrays.asList("name", "email"), "signup");
        fillForm();
        clickButton(createAccountBtn);


    }
    // Formu doldur
   public void fillForm() {
        setAddressDetails(); // Sabit adres bilgilerini ayarla

        // Form alanlarını doldur
        waitForClickablility(l_genderTitle_radioBtn, 5).click();
        clearAndSendKeys(l_name_InputBox, ConfigurationReader.get("fullName"));
        waitForVisibility(l_password_InputBox, 5).sendKeys(ConfigurationReader.get("password"));
        selectRandomDateOfBirth(" ");
        waitForClickablility(l_newsletter_chkBox, 5).click();
        waitForClickablility(l_specialOffers_chkBox, 5).click();
        clearAndSendKeys(l_first_name_InputBox, ConfigurationReader.get("firstName"));
        clearAndSendKeys(l_last_name_InputBox, ConfigurationReader.get("lastName"));
        clearAndSendKeys(l_company_InputBox, company);
        clearAndSendKeys(l_address1_InputBox, address);
        randomSelectForAnyDropdown(l_country_DropDownMenu, country);
        clearAndSendKeys(l_state_InputBox, state);
        clearAndSendKeys(l_city_InputBox, city);
        clearAndSendKeys(l_zipcode_InputBox, zipCode);
        clearAndSendKeys(l_mobile_number_InputBox, mobileNumber);
    }

    // Doğum tarihi için rastgele seçim yap
    private void selectRandomDateOfBirth(String option) {
        waitForVisibility(l_DateOfBirth_days, 5);
        randomSelectForAnyDropdown(l_DateOfBirth_days, option);
        waitForVisibility(l_DateOfBirth_months, 5);
        randomSelectForAnyDropdown(l_DateOfBirth_months, option);
        waitForVisibility(l_DateOfBirth_years, 5);
        randomSelectForAnyDropdown(l_DateOfBirth_years, option);
    }
}
