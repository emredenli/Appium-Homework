package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class HomeControl extends StepImplementation {

    @Step("<id>Acilis sayfasi Kontrol")
    public void homePage(String id) {

        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        logger.info("Uygulama basladi.");
        System.out.println("Uygulama basladi.");

    }
}
