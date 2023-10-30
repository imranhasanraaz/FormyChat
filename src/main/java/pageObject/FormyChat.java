package pageObject;

import aquality.selenium.elements.interfaces.IButton;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class FormyChat extends BaseForm {
    public FormyChat(){
        super(By.xpath("//span[@x-text='currentStep.title' and text()='WhatsApp Info']"), "Whatsapp info page");
    }
    private final IButton license = getElementFactory().getButton(By.xpath("//a[text()='License']"), "License");
    private final IButton activeUltimate = getElementFactory().getButton(By.id("activate-formychat-ultimate"), "Active ultimate");

    public boolean isLicenseExist(){
        return license.state().isExist();
    }
    public void clickedOnActiveUltimate(){
        activeUltimate.clickAndWait();
    }
}
