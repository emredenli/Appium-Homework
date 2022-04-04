package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


public class ShoppingControl extends StepImplementation {
    @Step("<id>Alisveris sayfasi kontrol")
    public void shoppingPage(String id) {
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        logger.info("Alisveris sayfasi acildigi dogrulandi");
        System.out.println("Alisveris sayfasi acildigi dogrulandi");

    }

}