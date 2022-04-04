package org.example;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {

    @Step("<time> saniye bekle")
    public void waitSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Step("<id> elemetin sayfada gorunur oldugunu kontrol et ve tikla")
    public void clickElementByid(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()) {
            element.click();
        } else {
            System.out.println("Kontrol edilen element gorunur olmadi");
        }
    }


    @Step("<Key> Id'li elemente <keyword> degerini yaz")
    public void SendkeyElementByid(String Key, String keyword) {
        appiumDriver.findElement(By.id(Key)).sendKeys(keyword);
        //sendKeys(By.id(Key),keyword);
        System.out.println(Key + "Elementine tiklandi");


    }

    @Step("<xpath> xpath'li elemente tikla")
    public void clickElementByxpath(String xpath) {
        MobileElement element = appiumDriver.findElement(By.xpath(xpath));
        element.click();
    }


    @Step("sayfa boyunca scroll et")
    public void ScrollRandomPos() {
        Dimension dmn = appiumDriver.manage().window().getSize();
        int start_x = (int) (dmn.width * 0.5);
        int start_y = (int) (dmn.height * 0.8);

        int end_x = (int) (dmn.width * 0.2);
        int end_y = (int) (dmn.height * 0.2);

        TouchAction tch = new TouchAction(appiumDriver);
        tch.press(PointOption.point(start_x, start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

    @Step("<Key> xpath'te bulunan sayfada gorunen tum urunleri bul ve rastgele bir urune tikla")
    public void findAllProducts(String Key) {
        List<MobileElement> productList = appiumDriver.findElementsByXPath(Key);
        int size = productList.size();
        Random rnd = new Random();
        int randNum = rnd.nextInt(size);
        productList.get(randNum).click();

    }

    @Step("Sepete ekle")
    public void addToBasket() {
        clickElementByxpath("//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[@index=0]");
        clickElementByid("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn");
    }

    protected JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) appiumDriver;
    }

    protected void scrollTo(int x, int y) {
        String jsStmt = String.format("window.scrollTo(%d, %d);", x, y);
        getJSExecutor().executeScript(jsStmt, true);
    }

    public void waitUntilPresence(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitUntilElementClickable(By by) {
        System.out.println(by.toString() + " --> elementin tiklanabilir olmasi bekleniyor");
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilElementAppear(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public void clickElement(By by) {
        waitUntilPresence(by);
        WebElement element;
        element = findElement(by);
        if (!element.isDisplayed()) {
            scrollTo(element.getLocation().getX(), element.getLocation().getY());
        }
        try {
            waitUntilElementClickable(by);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        element.click();
    }
}
