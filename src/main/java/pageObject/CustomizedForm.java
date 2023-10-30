package pageObject;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomizedForm extends BaseForm {
    public CustomizedForm(){
        super(By.xpath("//span[@class='text-slate-700 font-semibold']"), "Step 2");
    }
    private final IButton customSize = getElementFactory().getButton(By.xpath("//label[contains(@class, 'opacity-60')]"), "Custom size");
    private final IButton sizeSlider = getElementFactory().getButton(By.xpath("//input[@x-model='options.icon.size_custom']"), "Custom size slider");
    private final IButton positionLeft = getElementFactory().getButton(By.xpath("//label[normalize-space()='left']"), "position left");
    private final ITextBox callToActionText = getElementFactory().getTextBox(By.id("call_to_action_text"), "Call to action text");
    private final ITextBox formTitle = getElementFactory().getTextBox(By.id("form_title"), "Form title");
    private final ITextBox formSubmitText = getElementFactory().getTextBox(By.id("form_submit"), "form_submit");
    private final IComboBox fontFamily = getElementFactory().getComboBox(By.xpath("//select[contains(@class,'w-full scf-input')]"), "font family");
    private final IButton openByDefault = getElementFactory().getButton(By.xpath("//div[@class = 'scf-switch inactive']/label[contains(text(), 'Open by default')]"), "Open by default inactive");
    private final IButton next = getElementFactory().getButton(By.xpath("//span[contains(@x-text,'nextButton')]"), "Save and activated Form");

    public void clickedOnNext(){
        next.getJsActions().scrollIntoView();
        next.clickAndWait();
    }
    public void setOpenByDefaultActive(){
        if(openByDefault.state().isExist()){
            openByDefault.clickAndWait();
        }

    }
    public void setFontFamily(String fontName){
        fontFamily.getJsActions().scrollIntoView();
        fontFamily.selectByText(fontName);
    }
    public void setFormTitle(String title){
        formTitle.getJsActions().scrollIntoView();
        formTitle.clearAndType(title);
    }
    public void setFormSubmitText(String text){
        formSubmitText.getJsActions().scrollIntoView();
        formSubmitText.clearAndType(text);
    }
    public void setCallToActionText(String text){
        callToActionText.getJsActions().scrollIntoView();
        callToActionText.clearAndType(text);
    }
    public void clickedOnCustomSize(){
        customSize.clickAndWait();
    }
    public void setIconSizeMaximum(){
        WebElement element = sizeSlider.getElement();
        Actions move = new Actions(AqualityServices.getBrowser().getDriver());
        move.moveToElement(element).clickAndHold().moveByOffset(100,0).release().perform();
    }
    public void setPositionLeft(){
        positionLeft.clickAndWait();
    }
}
