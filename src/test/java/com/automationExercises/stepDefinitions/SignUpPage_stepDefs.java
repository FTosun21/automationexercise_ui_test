package com.automationExercises.stepDefinitions;

import io.cucumber.java.en.Then;

public class SignUpPage_stepDefs extends BasePage_stepDefs{
    @Then("The user creates an account by clicking the {string} button after filling in all the details in the Sign Up form")
    public void the_user_creates_an_account_by_clicking_the_button_after_filling_in_all_the_details_in_the_sign_up_form(String createAccountBtn) {
        signUpPage.newUserSingUp(createAccountBtn);
    }
}
