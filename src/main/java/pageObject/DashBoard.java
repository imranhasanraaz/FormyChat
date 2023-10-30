package pageObject;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

public class DashBoard extends BaseForm {
    public DashBoard(){
        super(By.xpath("//div[normalize-space()='Dashboard']"), "Dashboard");
    }
    private final ILabel wpMenu = getElementFactory().getLabel(By.xpath("//ul[@id='adminmenu']"), "Menu");
    private final IButton formyChat = getElementFactory().getButton(By.xpath("//div[@class='wp-menu-name' and text()='FormyChat']"), "FormyChat plugin");
    private final IButton plugins = getElementFactory().getButton(By.xpath("//a[contains(@class, 'menu-top') and contains(@class, 'menu-icon-plugins')]//div[@class='wp-menu-name']"), "plugins");
    private final ILabel allPluginList =getElementFactory().getLabel(By.id("the-list"), "Plugin List");
    private final IButton activePlugin = getElementFactory().getButton(By.id("activate-social-contact-form"), "Plugin Activated Button");
    private final IButton addNew = getElementFactory().getButton(By.xpath("//a[@class='page-title-action']"), "Add New plugin");
    private final ITextBox searchPlugin = getElementFactory().getTextBox(By.id("search-plugins"), "Search in Plugin store");
    private final IButton install = getElementFactory().getButton(By.xpath("//a[@class='install-now button' and @data-slug='social-contact-form']"), "Install Button");
    private final IButton active = getElementFactory().getButton(By.xpath("//a[@class='button activate-now button-primary' and @data-slug='social-contact-form']"), "Active Button");
    private final IButton uploadPlugin = getElementFactory().getButton(By.xpath("//span[@class='upload']"), "Upload Plugin");
    private final IButton chooseFile = getElementFactory().getButton(By.xpath("//input[@id='pluginzip']"), "Choose file");
    private final IButton installAfterUpload = getElementFactory().getButton(By.xpath("//input[@id='install-plugin-submit']"), "plugin install button");
    private final IButton activePluginWhileInstall = getElementFactory().getButton(By.xpath("//a[@class='button button-primary']"), "Active plugin while installing");

    public void clickedOnInstallAfterUpload(){
        installAfterUpload.clickAndWait();
    }
    public void clickedOnUploadPlugin(){
        uploadPlugin.clickAndWait();
    }
    public String getAllMenuName(){
        return wpMenu.getText();
    }
    public void clickedOnFormyChat(){
        formyChat.clickAndWait();
    }
    public void clickedOnPlugins(){
        plugins.clickAndWait();
    }
    public String getAllPluginList(){
        return allPluginList.getText();
    }
    public void clickedOnActiveFromPluginMenu(){
        activePlugin.clickAndWait();
    }
    public void clickedOnAddNew(){
        addNew.clickAndWait();

    }
    public void setSearchPlugin(String keyword){
        searchPlugin.clearAndType(keyword);
    }
    public void clickedOnInstall(){
        install.state().waitForDisplayed();
        install.clickAndWait();
    }
    public void clickedOnActiveFromPluginStore(){
        active.state().waitForClickable(Duration.ofMinutes(5));
        active.clickAndWait();
    }

    public void clickedOnChooseFile(String path){
        String filePath = new File(path).getAbsolutePath();
        chooseFile.sendKeys(filePath);
    }

    public void clickedOnActivePlugin() {
        activePluginWhileInstall.clickAndWait();
    }
}
