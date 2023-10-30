package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObject.DashBoard;
import pageObject.FormyChat;
import pageObjects.AdminLoginPage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static utilities.EnvReader.ReadEnv;

public class BaseTest {
    private final ISettingsFile configReader = new JsonSettingsFile("config.json");
    private final String adminLoginUrl = configReader.getValue("/wpAdminUrl").toString();
    public Logger logger = AqualityServices.getLogger();
    ISettingsFile testdata = new JsonSettingsFile("testdata.json");


    @BeforeClass
    public void pluginSetup(){
        getBrowser().maximize();
        getBrowser().goTo(adminLoginUrl);
        getBrowser().waitForPageToLoad();

        logger.info("Navigated to admin login page");
        AdminLoginPage adminLoginPage = new AdminLoginPage();
        logger.info("Admin login page has been opened");

        adminLoginPage.setUsername(ReadEnv("Username"));
        adminLoginPage.setPassword(ReadEnv("Password"));
        adminLoginPage.clickedOnLogin();
        DashBoard dashboard = new DashBoard();
        logger.info("Login Successful");

        String pluginName = testdata.getValue("/pluginName").toString();
        String allSubMenu = dashboard.getAllMenuName();
        if (allSubMenu.contains(pluginName)) {
            logger.info("plugin found in activated state");
            dashboard.clickedOnFormyChat();
        }else {
            dashboard.clickedOnPlugins();
            String allPluginList = dashboard.getAllPluginList();
            if (allPluginList.contains(pluginName)) {
                logger.info("plugin found in deactivated state");
                dashboard.clickedOnActiveFromPluginMenu();
            }else {
                logger.info("plugin not found");
                dashboard.clickedOnAddNew();
                dashboard.setSearchPlugin(pluginName);
                dashboard.clickedOnInstall();
                dashboard.clickedOnActiveFromPluginStore();
                logger.info("Plugin Install and active successfully");
            }
        }
        dashboard.clickedOnFormyChat();
        FormyChat formyChat = new FormyChat();
        if(formyChat.isLicenseExist())
        {
            logger.info("FormyChat ultimate version is activated");
        }else {
            dashboard.clickedOnPlugins();
            String allPluginList = dashboard.getAllPluginList();
            String ultimatePluginName = testdata.getValue("/ultimatePluginName").toString();
            if(allPluginList.contains(ultimatePluginName)){
                logger.info("Ultimate version is not active");
                formyChat.clickedOnActiveUltimate();
                logger.info("Ultimate is activated");
            }else {
               dashboard.clickedOnAddNew();
               dashboard.clickedOnUploadPlugin();
               dashboard.clickedOnChooseFile(testdata.getValue("/pluginLocation").toString());
               dashboard.clickedOnInstallAfterUpload();
               dashboard.clickedOnActivePlugin();
            }
        }
        logger.info("plugin is ready for testing");
    }

    @AfterClass
    public void quitBrowser(){
        getBrowser().getDriver().quit();
    }
}
