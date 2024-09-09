package com.automationExercises.stepDefinitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class Checkout_stepDefs extends BasePage_stepDefs {
    @Then("Verify that address details and review order")
    public void verify_that_address_details_and_review_order(List<String> expectedProductList) {
        checkoutPage.verifyAddress();
        checkoutPage.verifyProductList(expectedProductList);
    }

    @Then("The user enters {string} description in comment text area")
    public void the_user_enters_description_in_comment_text_area(String text) {
        checkoutPage.clearAndSendKeys(checkoutPage.l_commentTextArea,text);
    }
}
