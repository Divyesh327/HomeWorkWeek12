package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility
{

 public WebDriver driver;


    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by)
    {
                return  driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    public void mouseHoverToElement(By by)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void selectByValueFromDropDown(By by,String value)
    {
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);//select by value
    }

}
