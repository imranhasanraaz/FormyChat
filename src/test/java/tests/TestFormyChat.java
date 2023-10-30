package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ActivateForm;
import pageObject.CustomizedForm;
import pageObject.DashBoard;
import pageObject.WhatsappInfo;

public class TestFormyChat extends BaseTest{
    @Test
    public void testOfFormyChat() throws InterruptedException {
        DashBoard dashBoard = new DashBoard();
        dashBoard.clickedOnFormyChat();
        logger.info("Whatsapp Info Page");
        WhatsappInfo whatsappInfo = new WhatsappInfo();
        Assert.assertTrue(whatsappInfo.waitForDisplayed(), "Whatsapp Info page is not open");
        String whatsappNumber = testdata.getValue("/whatsappNumber").toString();
        whatsappInfo.clickedOnCountryCode();
        whatsappInfo.setWhatsappNumberBlank();
        logger.info("Verifying that user can not go step to without entering Whatsapp number");
        whatsappInfo.clickedOnNext();
        Assert.assertEquals(whatsappInfo.getInvalidNumberMessage(), testdata.getValue("/invalidNumberMessage").toString(), "Did not get Invalid number Message");
        whatsappInfo.selectBangladesh();
        whatsappInfo.setWhatsappNumber(whatsappNumber);
        whatsappInfo.setWhatsappDirectWebActive();
        whatsappInfo.setWhatsappPresetMessage(testdata.getValue("/presetMessage").toString());
        whatsappInfo.clickedOnNext();

        logger.info("Customized Form Page");
        CustomizedForm customizedForm = new CustomizedForm();
        Assert.assertTrue(customizedForm.waitForDisplayed(), "Customized form is not open");
        customizedForm.clickedOnCustomSize();
        customizedForm.setIconSizeMaximum();
        customizedForm.setPositionLeft();
        customizedForm.setCallToActionText(testdata.getValue("/callToActionText").toString());
        customizedForm.setFormTitle(testdata.getValue("/formTitle").toString());
        customizedForm.setFormSubmitText(testdata.getValue("/submitButtonText").toString());
        customizedForm.setFontFamily(testdata.getValue("/fontName").toString());
        customizedForm.setOpenByDefaultActive();
        customizedForm.clickedOnNext();

        logger.info("Navigated to Activate the form page");
        ActivateForm activateForm = new ActivateForm();
        Assert.assertTrue(activateForm.waitForDisplayed(), "Activated form page is not open");
        activateForm.setActivatedFormyChat();
        activateForm.clickedOnSave();
        activateForm.clickedOnDone();
        logger.info("plugin Setup is completed Now test all the things from frontend");
        Thread.sleep(5000);
    }
}
