package org.example.pages;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class CategoryControl extends StepImplementation {
    @Step("<xpath>Kategori Sayfasi Kontrol")
    public void categoryPage(String xpath) {

        Assert.assertTrue(appiumDriver.findElement(By.xpath(xpath)).isDisplayed());
        logger.info("Kategoriler sayfasi dogrulandi");
        System.out.println("Kategoriler sayfasi dogrulandi");
    }
}
