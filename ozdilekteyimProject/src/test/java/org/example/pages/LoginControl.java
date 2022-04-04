package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginControl extends StepImplementation {
    @Step("<id>Login kontrol")
    public void loginPage(String id) {
        Assert.assertTrue(appiumDriver.findElement(By.id(id)).isDisplayed());
        logger.info("Login sayfasi dogrulandi");

    }
}