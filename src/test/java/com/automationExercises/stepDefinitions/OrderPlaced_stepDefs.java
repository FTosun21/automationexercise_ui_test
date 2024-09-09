package com.automationExercises.stepDefinitions;

import com.automationExercises.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OrderPlaced_stepDefs extends BasePage_stepDefs{
    @And("The user clicks {string} button new")
    public void theUserClicksButtonNew(String button) {
        orderPlacedPage.clickButton(button);
        BrowserUtils.waitFor(3); // 3 saniye bekle
        try {
            Thread.sleep(5000); // 5 saniye bekle
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Then("Verify that invoice is downloaded successfully.")
    public void verify_that_invoice_is_downloaded_successfully() {
        orderPlacedPage.checkDownloadedFile("invoice.txt");
    }


}
