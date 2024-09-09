package com.automationExercises.pages;

import com.automationExercises.utilities.BrowserUtils;
import com.automationExercises.utilities.ConfigurationReader;
import com.automationExercises.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutPage extends BasePage{
    @FindBy(xpath = "//tbody/tr/td[2]//a")
    public List<WebElement> l_product_details;
    @FindBy(css = "[id='ordermsg'] textarea")
    public WebElement l_commentTextArea;


    public void verifyAddress() {
        // Formu doldururken kullanılan adres bilgilerini al
        String[] expectedAddressArray = getFormAddressData();

        // Web sayfasından alınan adres bilgilerini al
        String[] actualAddressArray = getAddressFromWeb();

        // Adres doğrulama işlemi
        verifyAddress(expectedAddressArray, actualAddressArray);
    }

    // Web'den adres bilgilerini alacak metod
    public String[] getAddressFromWeb() {
        // Web sayfasındaki adres bilgilerini içeren UL elementi
        WebElement addressList = Driver.get().findElement(By.id("address_delivery"));
        // UL içindeki tüm LI elemanlarını al
        List<WebElement> addressItems = addressList.findElements(By.tagName("li"));

        // Her bir adres bilgisini al
        String[] webAddressArray = new String[7];

        // Adres bilgilerini web elementlerinden al
        if (addressItems.size() > 0) {
            webAddressArray[0] = addressItems.get(1).getText(); // fullName: "Mr. John Doe"
            webAddressArray[1] = addressItems.get(2).getText(); // Company: "Lakin Group"
            webAddressArray[2] = addressItems.get(3).getText(); // Street ve PO Box: "716 Nicolas GardensP.O. Box 1234Lakin Group"
            webAddressArray[3] = addressItems.get(5).getText(); // State ve City ve Zip Code: "New Magaliton New York 61902"
            webAddressArray[4] = addressItems.get(6).getText(); // Country: "Singapore"
            webAddressArray[5] = addressItems.get(7).getText(); // Phone Number: "1-784-688-9978"
        }
        return webAddressArray;
    }

    // Form verilerini döndüren metod
    private String[] getFormAddressData() {

        return new String[] {
                ConfigurationReader.get("fullName"),
                company,
                address,
                state,
                city,
                zipCode,
                country,
                mobileNumber
        };
    }

    // Adres doğrulama metodu
    private void verifyAddress(String[] expected, String[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != null && !expected[i].isEmpty()) {
                assertTrue("Mismatch found: Expected '" + expected[i] + "' but found '" + actual[i] + "'",
                        actual[i] != null && actual[i].contains(expected[i]));
            }
        }
    }

    public void verifyProductList(List<String> expectedProductList){
        List<String> actualProductList = BrowserUtils.getElementsText(l_product_details);
        System.out.println("actualProductList = " + actualProductList);
        assertEquals(expectedProductList,actualProductList);
    }
}
