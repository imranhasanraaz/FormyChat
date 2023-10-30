package pageObject;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class WhatsappInfo extends BaseForm {
    public WhatsappInfo(){
        super(By.xpath("//span[@x-text='currentStep.title' and text()='WhatsApp Info']"), "Whatsapp info page");
    }

    private final IButton countryCode = getElementFactory().getButton(By.xpath("(//button[contains(@class, 'scf-input')])[1]"), "Country Code");
    private final IButton bangladesh = getElementFactory().getButton(By.xpath("//span[@x-html='`${country.emoji} (${country.phone_code}) - ${country.name}`'][normalize-space()='(880) - Bangladesh']"), "Select Bangladesh");
    private final ITextBox whatsappNumber = getElementFactory().getTextBox(By.id("whatsapp_number"),"Whatsapp Number");
    private final IButton whatsappDirectWebInactive = getElementFactory().getButton(By.xpath("//div[contains(@class, 'scf-switch') and contains(@class, 'whatsAppredirect') and contains(@class, 'inactive')]"), "whatsApp Redirect Web Inactive Button");
    private final ITextBox whatsappPresetMessage = getElementFactory().getTextBox(By.id("whatsapp_preset"), "Whatsapp Preset Message");
    private final IButton nextPage = getElementFactory().getButton(By.xpath("//span[@x-text='nextButton']"), "Next");
    private final ILabel invalidNumberMessage = getElementFactory().getLabel(By.xpath("//div[@class='text-sm text-red-400 bg-red-50 p-2 mt-2 rounded-md']"), "Invalid Number");

    public String getInvalidNumberMessage(){
        return invalidNumberMessage.getText();
    }
    public void clickedOnCountryCode(){
        countryCode.clickAndWait();
    }
    public void selectBangladesh(){
        bangladesh.state().waitForClickable();
        bangladesh.clickAndWait();
    }
    public void setWhatsappNumber(String number){
        whatsappNumber.clearAndType(number);
    }
    public void setWhatsappNumberBlank(){
        whatsappNumber.clearAndType(" ");
    }
    public void setWhatsappDirectWebActive(){
        if(whatsappDirectWebInactive.state().isExist()){
            whatsappDirectWebInactive.clickAndWait();
        }
    }
    public void setWhatsappPresetMessage(String message){
        whatsappPresetMessage.clearAndType(message);
    }
    public void clickedOnNext(){
        nextPage.clickAndWait();
    }
}
