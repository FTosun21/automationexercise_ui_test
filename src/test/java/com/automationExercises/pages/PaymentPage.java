package com.automationExercises.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.automationExercises.utilities.BrowserUtils.*;
import static org.junit.Assert.*;

public class PaymentPage extends BasePage{

    public void fillPaymentForm(String nameOnCard,String cardNum,String cvcNum,String expirationMonth,String expirationYear) {

        // "Name on Card" alanını doldur
        getPaymentInputElement(nameOnCard).sendKeys(paymentDetails[0]);

        // "Card Number" alanını doldur
        getPaymentInputElement(cardNum).sendKeys(paymentDetails[1]);

        // "CVC" alanını doldur
        getPaymentInputElement(cvcNum).sendKeys(paymentDetails[2]);

        // "Expiration Month" alanını doldur
        getPaymentInputElement(expirationMonth).sendKeys(paymentDetails[3]);

        // "Expiration Year" alanını doldur
        getPaymentInputElement(expirationYear).sendKeys(paymentDetails[4]);
    }
    // Ortak web element locator'ı kullanarak input alanlarına erişen metod
    private WebElement getPaymentInputElement(String dataQaValue) {
        return waitForVisibility(By.cssSelector("input[data-qa='" + dataQaValue + "']"), 5);
    }
    // Array içinde ödeme bilgilerini tanımlıyoruz
    String[] paymentDetails = {
            "John Doe",          // nameOnCard
            "4111111111111111",  // cardNum
            "123",               // cvcNum
            "12",                // expirationMonth
            "2025"               // expirationYear
    };

   







}
