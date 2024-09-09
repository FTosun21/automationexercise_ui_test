package com.automationExercises.stepDefinitions;

import io.cucumber.java.en.Then;

public class PaymentPage_stepDefs extends BasePage_stepDefs{
    @Then("The user enters payment details as {string} {string} {string} {string} {string}")
    public void the_user_enters_payment_details_as(String nameOnCard,String cardNum,String cvcNum,String expirationMonth,String expirationYear) {
        paymentPage.fillPaymentForm(nameOnCard, cardNum, cvcNum, expirationMonth, expirationYear);

    }
}
