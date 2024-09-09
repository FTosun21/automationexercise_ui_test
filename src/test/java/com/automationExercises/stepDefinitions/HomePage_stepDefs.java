package com.automationExercises.stepDefinitions;

import com.automationExercises.utilities.ConfigurationReader;
import com.automationExercises.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class HomePage_stepDefs extends BasePage_stepDefs {
    @When("The user navigates to url")
    public void the_user_navigates_to_url() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @Then("Verify that the user is on the {string} page")
    public void verify_that_the_user_is_on_the_page(String page) {
        homePage.verifyMenu(page);
    }
    @Then("The user adds following products to cart and clicks {string} button")
    public void the_user_adds_following_products_to_cart_and_clicks_button(String continue_Shopping_Btn, List<String> products) {
        for (String product : products) {
            homePage.addProductToCart(product,continue_Shopping_Btn);
        }
    }
    @Then("The user clicks {string} button")
    public void the_user_clicks_button(String button) {
        cartPage.clickButton(button);
    }
    @Then("The user clicks {string} menu")
    public void the_user_clicks_menu(String menu) {
        homePage.clickMenu(menu);
    }

    @Then("Verify that {string} text is displayed")
    public void verify_that_text_is_displayed(String expectedText) {
        if(expectedText.equals("Logged in as John Doe")){
        expectedText=ConfigurationReader.get("fullName");
        }
        System.out.println("expectedText = " + expectedText);
        signUpPage.verifyText(expectedText);
    }


}
