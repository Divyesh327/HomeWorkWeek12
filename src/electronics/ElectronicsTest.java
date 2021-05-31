package electronics;

import browseraction.BrowserAction;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utility.Utility;

public class ElectronicsTest extends BrowserAction
{
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException
    {
        Thread.sleep(5000);
        mouseHoverToElement(By.xpath("//ul[@class='top-menu notmobile']/child::li[2]"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[2]/ul/li[2]/a"));

        String expectedCellphone = "Cell phones";
        String actualCellphone = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Sort by Z to A is not selected", expectedCellphone, actualCellphone);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException
    {
        verifyUserShouldNavigateToCellPhonesPageSuccessfully();

        clickOnElement(By.xpath("//div[@class='product-viewmode']/a[@class='viewmode-icon list']"));

        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@data-productid='20']/div[2]/h2/a"));

        String expectedNokia = "Nokia Lumia 1020";
        String actualNokia = getTextFromElement(By.xpath("//div[@class='product-name']/h1"));
        Assert.assertEquals("Nokia not selected...",expectedNokia,actualNokia);

        String expectedNokiaPrice = "$349.00";
        String actualNokiaPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("Price not match..",expectedNokiaPrice,actualNokiaPrice);

        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//div[@id='bar-notification']/div/p"));
        Assert.assertEquals("Not added to shopping cart....", expectedMessage, actualMessage);

        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //mouseHoverToElement(By.xpath("//li[@id='topcartlink']/a"));
        //clickOnElement(By.xpath("//div[@id='flyout-cart']/div[1]/div[4]/button"));

        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Shopping cart page is not there....", expectedMessage4, actualMessage4);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@class='common-buttons']/button[1]"));
        Thread.sleep(3000);

        String expectedPrice = "$698.00";
        String actualPrice = getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span"));
        Assert.assertEquals("Price not updated....", expectedPrice, actualPrice);

        Thread.sleep(5000);
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(5000);
        clickOnElement(By.id("checkout"));

        Thread.sleep(3000);
        String expected = "Welcome, Please Sign In!";
        String actual = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Not on sign in page....", expected, actual);

        clickOnElement(By.xpath("//div[@class='buttons']/button[2]"));

        Thread.sleep(3000);
        String expectedRegister = "Register";
        String actualRegister = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Not Register Page...",expectedRegister,actualRegister);

        Thread.sleep(5000);
        clickOnElement(By.id("gender-male"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"),"Div");
        sendTextToElement(By.xpath("//input[@id='LastName']"),"Soni");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.name("DateOfBirthDay"),"3");
        Thread.sleep(5000);
        selectByValueFromDropDown(By.name("DateOfBirthMonth"),"11");
        selectByValueFromDropDown(By.name("DateOfBirthYear"),"1986");
        sendTextToElement(By.id("Email"),"abc@gmail.com");
        sendTextToElement(By.id("Password"),"XYZABC@123");
        sendTextToElement(By.id("ConfirmPassword"),"XYZABC@123");
        clickOnElement(By.id("register-button"));

        String expectedRegCompleted = "Your registration completed";
        String actualRegCompleted = getTextFromElement(By.xpath("//div[text()='Your registration completed']"));
        Assert.assertEquals("User is not Register Successfully..",expectedRegCompleted,actualRegCompleted);

        clickOnElement(By.xpath("//div[@class='buttons']/a"));

        String expectedCart = "Shopping cart";
        String actualCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Shopping cart page is not there....", expectedCart, actualCart);

        Thread.sleep(5000);
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(5000);
        clickOnElement(By.id("checkout"));

        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("BillingNewAddress_CountryId"), "233");
        sendTextToElement(By.id("BillingNewAddress_City"), "Southall");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "31 Morland Gardens");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "UB1 3DY");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "05758425455");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));

        Thread.sleep(5000);
        clickOnElement(By.id("shippingoption_2"));
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        Thread.sleep(5000);
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));

        Thread.sleep(5000);
        selectByValueFromDropDown(By.id("CreditCardType"), "visa");
        sendTextToElement(By.id("CardholderName"), "Div Soni");
        sendTextToElement(By.id("CardNumber"), "584554550318117");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("ExpireMonth"), "11");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.id("ExpireYear"), "2022");
        sendTextToElement(By.id("CardCode"), "605");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        Thread.sleep(5000);
        String expectedPayment = "Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Assert.assertEquals("Wrong Information filled....", expectedPayment, actualPayment);

        Thread.sleep(3000);
        String expectedShipping = "2nd Day Air";
        String actualShipping = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Assert.assertEquals("Wrong Information filled....", expectedShipping, actualShipping);

        Thread.sleep(3000);
        String expectedTotal = "$698.00";
        String actualTotal = getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span[1]/strong"));
        Assert.assertEquals("Total not updated....", expectedTotal, actualTotal);

        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));

        Thread.sleep(3000);
        String expectedThankYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Thank you is not there....", expectedThankYou, actualThankYou);

        Thread.sleep(3000);
        String expectedSuccess = "Your order has been successfully processed!";
        String actualSuccess = getTextFromElement(By.xpath("//div[@class='page-body checkout-data']/div/div/strong"));
        Assert.assertEquals("Thank you is not there....", expectedSuccess, actualSuccess);

        clickOnElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));

        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        Assert.assertEquals("Thank you is not there....", expectedWelcome, actualWelcome);

        clickOnElement(By.xpath("//div[@class='header-links']/ul/li[2]/a"));

        String expectedLink = "https://demo.nopcommerce.com/";
        String actualLink = driver.getCurrentUrl();
        Assert.assertEquals("Url not mathched...",expectedLink,actualLink);
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }


}



