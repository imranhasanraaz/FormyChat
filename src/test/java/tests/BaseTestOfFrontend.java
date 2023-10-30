package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class BaseTestOfFrontend {
    private final ISettingsFile configReader = new JsonSettingsFile("config.json");
    private final String frontendURL = configReader.getValue("/frontEndUrl").toString();
    public Logger logger = AqualityServices.getLogger();
    ISettingsFile testdata = new JsonSettingsFile("testdata.json");
    @BeforeClass
    public void frontendInitialized(){
        getBrowser().maximize();
        getBrowser().goTo(frontendURL);
        getBrowser().waitForPageToLoad();
        logger.info("Navigated to Frontend");
    }
    @AfterClass
    public void quitBrowser(){
        getBrowser().getDriver().quit();
    }
}
