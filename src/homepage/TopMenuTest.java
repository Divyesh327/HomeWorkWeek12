package homepage;

import browseraction.BrowserAction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class TopMenuTest extends BrowserAction
{
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
      openBrowser(baseUrl);
    }

    @Test
    public void selectMenu ()
    {
           clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[1]/a[1]"));
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
