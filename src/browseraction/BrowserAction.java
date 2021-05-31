package browseraction;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Utility;

import java.util.concurrent.TimeUnit;

public class BrowserAction extends Utility
{

    public void openBrowser (String baseurl)
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseurl);
    }
        public void closeBrowser()
        {
            if (driver != null)
            {
                driver.quit();
            }
        }

    }


