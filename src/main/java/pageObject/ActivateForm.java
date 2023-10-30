package pageObject;

import aquality.selenium.elements.interfaces.IButton;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class ActivateForm extends BaseForm {
    public ActivateForm(){
        super(By.xpath("//span[@class='text-slate-700 font-semibold']"), "Activate the form page");
    }

    private final IButton save = getElementFactory().getButton(By.xpath("//span[contains(@x-text,'nextButton')]"), "Save and activated Form");
    private final IButton activatedFormyChat = getElementFactory().getButton(By.xpath("//div[@class = 'scf-switch inactive']/label[contains(text(), 'Activate FormyChat')]"), "Activated Formy Chat");
    private final IButton done = getElementFactory().getButton(By.xpath("//div[contains(text(), 'Done')]"), "Done");

    public void clickedOnDone(){
        done.clickAndWait();
    }

    public void setActivatedFormyChat(){
        if(activatedFormyChat.state().isExist()){
            activatedFormyChat.clickAndWait();
        }
    }
    public void clickedOnSave(){
        save.clickAndWait();
    }
}
