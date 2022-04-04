package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductControl extends StepImplementation {
    @Step("<id>Product sayfasi kontrol")
    public void productPage(String id) {
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        logger.info("Product sayfasi dogrulandi.");
        System.out.println("Product sayfasi dogrulandi.");

    }
}