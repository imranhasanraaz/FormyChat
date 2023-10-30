package pageObject;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class Frontend extends BaseForm {
    public Frontend(){
        super(By.xpath("//div[@class='wp-block-group alignwide is-content-justification-space-between is-layout-flex wp-container-3 wp-block-group-is-layout-flex']//a[normalize-space()='FormyChat']"), "homepage");
    }
    private final IButton formIsOpen = getElementFactory().getButton(By.xpath("//div[@class='scf-form-close']"), "From is Open");
    private final ILabel formTitle = getElementFactory().getLabel(By.xpath("//div[@class='scf-form-title']"), "form title");
    private final IButton submitButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Submit Button");
    private final IButton callToAction = getElementFactory().getButton(By.xpath("//div[@class='scf-cta']"), "Call to Action");
    private final IButton icon = getElementFactory().getButton(By.xpath("//div[@class='scf-icon-image']"), "Icon");
    private final ILabel leftPosition = getElementFactory().getLabel(By.xpath("//div[@class= 'scf-form left']"), "Form Position Left");
    private final ITextBox name = getElementFactory().getTextBox(By.id("name"), "Name Field");
    private final ITextBox email = getElementFactory().getTextBox(By.id("email"), "email Field");
    private final ITextBox number = getElementFactory().getTextBox(By.id("phone"), "number Field");
    private final ITextBox message = getElementFactory().getTextBox(By.id("message"), "message Field");


    public void setName(String value){
        name.clearAndType(value);
    }
    public void setEmail(String value){
        email.clearAndType(value);
    }
    public void setNumber(String value){
        number.clearAndType(value);
    }
    public void setMessage(String value){
        message.clearAndType(value);
    }
    public void clickedOnSubmitButton(){
        submitButton.clickAndWait();
    }
    public String getIconSize(){
        return icon.getAttribute("style");
    }
    public boolean isFormIsOpenByDefault() {
        return formIsOpen.state().waitForDisplayed();
    }

    public String getFontName(){
        return formTitle.getCssValue("font-family");
    }
    public String getFormHeaderText(){
        return formTitle.getText();
    }
    public String getSubmitButtonText(){
        return submitButton.getText();
    }
    public String getCallToActionText(){
        return callToAction.getText();
    }
    public boolean isFormPositionLeft(){
        return leftPosition.state().isExist();
    }
}
