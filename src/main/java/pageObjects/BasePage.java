package pageObjects;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage extends BaseUtil {

    public static Logger log = LoggerHelper.getLogger(BasePage.class);

    protected WebDriverWait wait;

    //Wait for driver
    public BasePage() {
        log.info("Wait for the driver and maximize window");
        wait = new WebDriverWait(getDriver(), 30);
        getDriver().manage().window().maximize();
    }

    //Wait for visibility of the element
    public void waitForVisibility(WebElement element) {
        try {
            wait = new WebDriverWait(getDriver(), 100);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    //accessing values from commons.properties
    public static String accessingProperties(String key) throws IOException {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("F:\\repo\\CopyCucumberBasics\\commons.properties"));
            return properties.getProperty(key);
        } catch (IOException io) {
            io.printStackTrace();
            return "IOException!!!";
        }
    }
}
