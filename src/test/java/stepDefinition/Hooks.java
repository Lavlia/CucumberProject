package stepDefinition;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import pageObjects.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static pageObjects.BasePage.accessingProperties;

public class Hooks extends BaseUtil {

    Logger log = LoggerHelper.getLogger(Hooks.class);


    @Before
    public void initializeTest() throws IOException {
        if (getDriver() == null && accessingProperties("driverType").equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            addDriver(new ChromeDriver());
            log.info("Chrome browser is opened");
        } else {
            if (getDriver() == null && accessingProperties("driverType").equalsIgnoreCase("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                addDriver(new FirefoxDriver());
                log.info("Firefox browser is opened");
            }
        }
    }

    @After
    public void tearDownTestChrome(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                File screenshoot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
                String testName = scenario.getName();
                Files.copy(screenshoot.toPath(),
                        new File("F:\\repo\\CucumberBasics\\target\\Report " + testName + " " + timestamp + " screenshot.png").toPath());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        if (getDriver() != null) {
            getDriver().close();
            getDriver().quit();
            removeDriver();
            log.info("Remove browser");
        }
    }
}

