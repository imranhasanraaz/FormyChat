package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Frontend;

import java.util.ArrayList;
import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class FrontendTest extends BaseTestOfFrontend{
    Frontend frontend = new Frontend();
    @Test(priority = 1)
    public void testOfFormIsOpenByDefault() {
        Assert.assertTrue(frontend.waitForDisplayed(), "Frontend is not open");
        logger.info("Verify that form is open By default");
        Assert.assertTrue(frontend.isFormIsOpenByDefault(), "Form is not open");
    }
    @Test(priority = 2)
    public void testOfVerifyFont(){
        logger.info("Verify that font is match with testdata");
        Assert.assertEquals(frontend.getFontName(), testdata.getValue("/fontName").toString(), "Front does not matched");
    }
    @Test(priority = 3)
    public void testOfFromHeader(){
        logger.info("Verify That form header text is match with testdata");
        Assert.assertEquals(frontend.getFormHeaderText(), testdata.getValue("/formTitle").toString());
    }
    @Test(priority = 4)
    public void testOfSubmitButtonText(){
        logger.info("Verify That submit button text is match with testdata");
        Assert.assertEquals(frontend.getSubmitButtonText(), testdata.getValue("/submitButtonText").toString());
    }
    @Test(priority = 5)
    public void testOfCallToActionText(){
        logger.info("Verify That Call to Action text is match with testdata");
        Assert.assertEquals(frontend.getCallToActionText(), testdata.getValue("/callToActionText").toString());
    }
    @Test(priority = 6)
    public void testOfIconSize(){
        logger.info("Verify that Icon has it's maximum size");
        String actualSize = frontend.getIconSize();
        String expectedSize = testdata.getValue("/maximumIconSize").toString();
        Assert.assertTrue(actualSize.contains(expectedSize), "Icon size does not working");
    }
    @Test(priority = 7)
    public void testOfFormPosition(){
        logger.info("Verify that form is open in left side");
        Assert.assertTrue(frontend.isFormPositionLeft(), "Form is not in left side");
    }

    @Test(priority = 8)
    public void testThatWhatsappOpenInNewTab() throws InterruptedException {
        logger.info("Verify that Whatsapp is open in new tab after clicked submitted button");
        frontend.setName(testdata.getValue("/formData/name").toString());
        frontend.setEmail(testdata.getValue("/formData/email").toString());
        frontend.setNumber(testdata.getValue("/formData/number").toString());
        frontend.setMessage(testdata.getValue("/formData/message").toString());
        frontend.clickedOnSubmitButton();
        List<String> tabs = new ArrayList<>(getBrowser().getDriver().getWindowHandles());
        getBrowser().getDriver().switchTo().window(tabs.get(1));
        String actualCurrentUrl = getBrowser().getCurrentUrl();
        String expectedUrl = testdata.getValue("/whatsappURL").toString();
        Assert.assertTrue(actualCurrentUrl.contains(expectedUrl), "Whatsapp is not open");
        getBrowser().getDriver().switchTo().window(tabs.get(0));
        Thread.sleep(5000);

    }
}
