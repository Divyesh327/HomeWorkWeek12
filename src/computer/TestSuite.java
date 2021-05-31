package computer;

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

public class TestSuite extends BrowserAction
{

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphaBeticalOrder() throws InterruptedException
    {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computer).moveToElement(desktops).click().build().perform();
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name: Z to A");
        String expectedMessage = "Lenovo IdeaCentre 600 All-in-One PC";
        String actualMessage = getTextFromElement(By.xpath("//h2[@class='product-title']/a[text()='Lenovo IdeaCentre 600 All-in-One PC']"));
        Assert.assertEquals("Sort by Z to A is not selected", expectedMessage, actualMessage);

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException
    {
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
        WebElement desktops = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]"));
        actions.moveToElement(computer).moveToElement(desktops).click().build().perform();
        WebElement dropdown = driver.findElement(By.id("products-orderby"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Name: A to Z");


        Thread.sleep(5000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        String expectedMessage1 = "Build your own computer";
        String actualMessage1 = getTextFromElement(By.xpath("//div[@data-productid='1']/div[1]/div[2]/div[1]/h1"));
        Assert.assertEquals("Build your own computer page is not there....", expectedMessage1, actualMessage1);

        WebElement dropdown1 = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/dl[1]/dd[1]/select[1]"));
        Select select1 = new Select(dropdown1);
        select1.selectByValue("1");

        WebElement dropdown2 = driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[7]/dl[1]/dd[2]/select[1]"));
        Select select2 = new Select(dropdown2);
        select2.selectByVisibleText("8GB [+$60.00]");

        WebElement radio = driver.findElement(By.xpath("//label[contains(text(),'400 GB [+$100.00]')]"));
        radio.click();

        WebElement radio1 = driver.findElement(By.xpath("//label[contains(text(),'Vista Premium [+$60.00]')]"));
        radio1.click();

        Thread.sleep(5000);
        WebElement check1 = driver.findElement(By.xpath("//label[contains(text(),'Total Commander [+$5.00]')]"));
        check1.click();

        Thread.sleep(5000);
        //Assert
        String expectedMessage2 = "$1,475.00";
        String actualMessage2 = getTextFromElement(By.id("price-value-1"));
        Assert.assertEquals("Wrong price match....", expectedMessage2, actualMessage2);

        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        String expectedMessage3 = "The product has been added to your shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//div[@id='bar-notification']/div/p"));
        Assert.assertEquals("Not added to shopping cart....", expectedMessage3, actualMessage3);

        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        Actions actions1 = new Actions(driver);
        WebElement shoppingcart = driver.findElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        actions.moveToElement(shoppingcart).click().build().perform();

        String expectedMessage4 = "Shopping cart";
        String actualMessage4 = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Shopping cart page is not there....", expectedMessage4, actualMessage4);

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElement(By.xpath("//input[@value='1']"), "2");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@class='common-buttons']/button[1]"));
        Thread.sleep(3000);

        String expectedText5 = "$2,950.00";
        String actualMessage5 = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]/span[1]/strong[1]"));

        Assert.assertEquals("The Amount is Different",expectedText5,actualMessage5);

        Thread.sleep(5000);
        clickOnElement(By.id("termsofservice"));
        Thread.sleep(5000);
        clickOnElement(By.id("checkout"));

        String expected6 = "Welcome, Please Sign In!";
        String actual6 = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Not on sign in page....", expected6, actual6);

        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@class='buttons']/button[@class='button-1 checkout-as-guest-button']"));

        //Billing Address
        Thread.sleep(5000);
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "Div");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "Soni");
        sendTextToElement(By.id("BillingNewAddress_Email"), "div@gmail.com");
        Thread.sleep(3000);

        WebElement dropdown3 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select3 = new Select(dropdown3);
        select3.selectByValue("233");

        sendTextToElement(By.id("BillingNewAddress_City"), "Southall");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "31 Morland Gardens");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "UB1 3DY");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "0745321254");
        Thread.sleep(5000);
        clickOnElement(By.xpath("//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']"));

        //Shipping Method
        Thread.sleep(5000);
        clickOnElement(By.id("shippingoption_1"));
        clickOnElement(By.xpath("//div[@id='shipping-method-buttons-container']/button"));

        Thread.sleep(5000);
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//div[@id='payment-method-buttons-container']/button"));

        //Payment detail
        Thread.sleep(5000);

        /*WebElement dropdown4 = driver.findElement(By.id("BillingNewAddress_CountryId"));
        Select select4 = new Select(dropdown4);
        select4.selectByValue("MasterCard");*/

        sendTextToElement(By.id("CardholderName"), "Div Soni");
        sendTextToElement(By.id("CardNumber"), "5227735054577520");

        Thread.sleep(3000);
        WebElement dropdown5 = driver.findElement(By.id("ExpireMonth"));
        Select select5 = new Select(dropdown5);
        select5.selectByVisibleText("12");

        Thread.sleep(3000);
        WebElement dropdown6 = driver.findElement(By.id("ExpireYear"));
        Select select6 = new Select(dropdown6);
        select6.selectByVisibleText("2022");

        sendTextToElement(By.id("CardCode"), "722");
        clickOnElement(By.xpath("//div[@id='payment-info-buttons-container']/button"));

        //Assert
        Thread.sleep(5000);
        String expectedPayment = "Credit Card";
        String actualPayment = getTextFromElement(By.xpath("//li[@class='payment-method']/span[@class='value']"));
        Assert.assertEquals("Wrong Information filled....", expectedPayment, actualPayment);

        //Assert
        Thread.sleep(3000);
        String expectedShipping = "Next Day Air";
        String actualShipping = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Assert.assertEquals("Wrong Information filled....", expectedShipping, actualShipping);

        //Assert
        Thread.sleep(3000);
        String expectedTotal = "$2,950.00";
        String actualTotal = getTextFromElement(By.xpath("//tr[@class='order-total']/td[2]/span[1]/strong"));
        Assert.assertEquals("Total not updated....", expectedTotal, actualTotal);

        //Confirm order
        clickOnElement(By.xpath("//div[@id='confirm-order-buttons-container']/button"));

        //Assert
        Thread.sleep(3000);
        String expectedThankYou = "Thank you";
        String actualThankYou = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Assert.assertEquals("Thank you is not there....", expectedThankYou, actualThankYou);

        //Assert
        Thread.sleep(3000);
        String expectedSuccess = "Your order has been successfully processed!";
        String actualSuccess = getTextFromElement(By.xpath("//div[@class='page-body checkout-data']/div/div/strong"));
        Assert.assertEquals("Thank you is not there....", expectedSuccess, actualSuccess);

        //Click on continue
        clickOnElement(By.xpath("//div[@class='page-body checkout-data']/div/div[3]/button"));

        //Assert
        Thread.sleep(3000);
        String expectedWelcome = "Welcome to our store";
        String actualWelcome = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));
        Assert.assertEquals("Thank you is not there....", expectedWelcome, actualWelcome);


    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }


}
