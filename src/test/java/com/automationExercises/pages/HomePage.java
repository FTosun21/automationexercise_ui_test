package com.automationExercises.pages;

import com.automationExercises.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.automationExercises.utilities.BrowserUtils.*;

public class HomePage extends BasePage {

    public void addProductToCart(String product,String continue_Shopping_Btn) {
        By chooseProductElem = By.xpath("//p[text()='" + product + "']/../a[.='Add to cart']");
        WebElement productItem = Driver.get().findElement(chooseProductElem);

        try {
            hover(Driver.get().findElement(chooseProductElem));
            waitForClickablility(productItem, 10).click();
        } catch (Exception e) {
            scrollToElement(productItem);
            hover(productItem);
            clickWithWait(chooseProductElem, 10);
        }
        clickButton(continue_Shopping_Btn);


    }
}
