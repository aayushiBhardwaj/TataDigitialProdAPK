package com.browserstack;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set;

public class ProdTest extends BrowserStackTestNGTest {


        boolean addressPresent = false;

        @Test
        public void test() throws Exception {

                JavascriptExecutor jse = (JavascriptExecutor) driver;

                        WebElement numberTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.tatadigital.tcp:id/mobileNumberEditText")));
                        numberTxb.sendKeys("8779626887");

                        WebElement getOtpBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.id("com.tatadigital.tcp:id/mobileConfirmButton")));
                        getOtpBtn.click();

                        WebElement loginWithPasswordLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.tatadigital.tcp:id/tvLoginWithPassword")));
                        loginWithPasswordLnk.click();

                        WebElement passwordTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.id("com.tatadigital.tcp:id/edtPassword")));
                        passwordTxb.sendKeys("Jan@2023");

                        WebElement submitBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.id("com.tatadigital.tcp:id/btnSubmit")));
                        submitBtn.click();

                        Thread.sleep(5000);

                        WebElement locationLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.ImageView)[4]")));
                        locationLnk.click();

                        Thread.sleep(3000);

                        try {
                                System.out.println("In Try block");
                               if(driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Default']")).isDisplayed()) {
                                       addressPresent = true;
                               }

                        } catch (Exception ele) {
                                System.out.println("in catch block");
                                ele.printStackTrace();

                        }
                        WebElement homeLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(" //android.widget.FrameLayout[@content-desc='Home']/android.widget.ImageView")));
                        homeLnk.click();

                        Thread.sleep(5000);


                        TouchAction action = new TouchAction(driver);
                        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(20)))
                                .moveTo(PointOption.point(115, 350)).release().perform();


                        WebElement mobileLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Mobiles']")));
                        mobileLnk.click();

                        Thread.sleep(3000);

                        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                                .moveTo(PointOption.point(115, 350)).release().perform();

                        WebElement topMobileLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.xpath(" //android.view.View[@content-desc=\"Most searched in Mobiles\"]/android.view.View/android.view.View/android.widget.ImageView[1]\n" +
                                        "\n")));
                        topMobileLnk.click();

                        Thread.sleep(5000);

                        Set<String> contextNames = driver.getContextHandles();
                        System.out.println("Printing Context");
                        System.out.println(contextNames.size());
                        System.out.println(contextNames.toString());
                        Thread.sleep(5000);
                        driver.context("WEBVIEW_com.tatadigital.tcp");

                        WebElement productTitle = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[@class='product-item'])[1]//h3/a")));
                        productTitle.click();
                        Thread.sleep(2000);

                        jse.executeScript("scrollBy(0, 100)");

                        jse.executeScript("scrollBy(0, 4500)");

                        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                                .moveTo(PointOption.point(115, 350)).release().perform();

                        Thread.sleep(5000);

                        WebElement buyNowBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'buy now')]")));
                        driver.executeScript("arguments[0].scrollIntoView(true);", buyNowBtn);

                        Thread.sleep(3000);

                        WebDriverWait wait;
                        wait = new WebDriverWait(driver, Duration.ofSeconds(300));
                        wait.until(ExpectedConditions.elementToBeClickable(buyNowBtn));
                        System.out.println("FIELD NAME " + buyNowBtn.getText());
                        buyNowBtn.click();
                        wait.until(ExpectedConditions.invisibilityOf(buyNowBtn));
                        Thread.sleep(3000);

                        action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                                .moveTo(PointOption.point(115, 350)).release().perform();


                        WebElement checkOutBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Checkout')]")));
                        driver.executeScript("arguments[0].scrollIntoView(true);", checkOutBtn);
                        checkOutBtn.click();

                        Thread.sleep(8000);

                        if (!addressPresent) {
                                WebElement fullNameTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='addShipAddressFullName']")));
                                fullNameTxb.sendKeys("Sanket");

                                WebElement addressNameTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='addShipAddressMobileNo']")));
                                addressNameTxb.sendKeys("1234567890");

                                WebElement nickNameTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='addShipAddressNickName']")));
                                nickNameTxb.sendKeys("sank");

                                WebElement addressLine1 = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='shipAddLine1']")));
                                addressLine1.sendKeys("Test");

                                WebElement addressLine2 = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='shipAddLine2']")));
                                addressLine2.sendKeys("Test");


                                action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                                        .moveTo(PointOption.point(115, 350)).release().perform();


                                WebElement proceedToCheckoutBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='payment_footer_container']//button[contains(text(),'Proceed to Payment')]")));
                                proceedToCheckoutBtn.click();

                        } else {


                                action.press(PointOption.point(115, 650)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(10)))
                                        .moveTo(PointOption.point(115, 350)).release().perform();


                                WebElement proceedToCheckoutBtn2 = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                        ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Proceed to Payment')])[2]")));
                                proceedToCheckoutBtn2.click();
                                // jse.executeScript("arguments[0].click();", proceedToCheckoutBtn2);

                        }

                        Thread.sleep(15000);

                        driver.switchTo().defaultContent();

                        driver.switchTo().frame("juspay_iframe");

                        WebElement tataPayLnk = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//article[contains(text(),'Tata Pay')])[2]")));
                        tataPayLnk.click();

                        WebElement payBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(90)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//article[contains(text(),'Place Order & Pay')])[6]")));
                        payBtn.click();

                        wait.until(ExpectedConditions.invisibilityOf(payBtn));

                        driver.switchTo().defaultContent();

                        driver.context("NATIVE_APP");
                Thread.sleep(2000);

                        WebElement cardPaymentBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/rbCardPayment")));
                        cardPaymentBtn.click();

                        WebElement addNewCardBtn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/clAddNewCard")));
                        addNewCardBtn.click();


                        WebElement CardNameTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etCardName")));
                        CardNameTxb.sendKeys("Test");

                        WebElement CardNumberTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etCardNumber")));
                        CardNumberTxb.sendKeys("374245455400126");

                        WebElement expMonthTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etExpMonth")));
                        expMonthTxb.sendKeys("10");

                        WebElement expYearTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etExpYear")));
                        expYearTxb.sendKeys("23");

                        WebElement cvvTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etCvvField")));
                        cvvTxb.sendKeys("130");

                        WebElement tagNameTxb = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(120)).until(
                                ExpectedConditions.visibilityOfElementLocated(By.id("com.tatadigital.tcp:id/etTagName")));
                        tagNameTxb.sendKeys("Test");




/*

                        WebElement backBtunn = (WebElement) new WebDriverWait(driver, Duration.ofSeconds(30)).until(
                                ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));
                        backBtunn.click();*/
                        Thread.sleep(3000);

                        jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Assertion Successful!\"}}");


        }

}


