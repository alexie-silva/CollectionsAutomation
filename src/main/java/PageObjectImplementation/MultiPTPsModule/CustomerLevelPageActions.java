package PageObjectImplementation.MultiPTPsModule;
import PageObject.MultiPTPsPage.CustomerLevelPage;
import org.junit.Assert;

public class CustomerLevelPageActions extends CustomerLevelPage {

    public void unableToCreatePTP() throws InterruptedException {

        /* Elements naming convention (e.g btnSubmit, txtbxUsername, rbtnYesAgreement etc)
    --> btn - button
    --> lbl - label
    --> txtbx - textbox
    --> rbtn - radio button
    --> cbx - checkbox
    --> dpd - dropdown
    --> dpdlst - dropdown list
    --> lnk - hyperlink
    --> tb - tabs
    --> tbl - tables
    --> li - lists
    */



        click(lnkCollection);
        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        Thread.sleep(3000);
        click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusActive, 10);
        click(dpdlstCollectionStatusActive);

        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);

        Thread.sleep(3000);
        switchFrame(frmSearchResults);


        String parent = driver.getWindowHandle(); // Store the current window handle
        click(rbtnThirdAccount);
        for (String child : driver.getWindowHandles()) // Switch to new window opened
        {
            driver.switchTo().window(child);
        }

        switchFrame("//iframe[@id='ctl00_contentPlaceHolder_ifrSingleView']");
        click(txtFCIDN);

        switchDefault();
        waitElementToBeDisplayed(btnLHS, 5);
        click(btnLHS);
        click(btnPaymentArragement);
        switchFrame(frmPaymentArrangements);
        waitElementToBeDisplayed(btnAdvanceView, 5);
        click(btnAdvanceView);
        waitElementToBeEnabled(btnAddNewItem, 5);
        click(btnAddNewItem);

        //Remove Item
        waitElementToBeEnabled(btnRemoveItem1, 3);
        click(btnRemoveItem1);
        waitElementToBeEnabled(btnRemoveItem2, 3);
        click(btnRemoveItem2);
        click(dpdValue);
        Thread.sleep(1000);
        click(dpdValue1);
        waitElementToBeEnabled(btnApply,    3);
        click(btnApply);

        // Click checkbox
        waitElementToBeEnabled(cbxNZD,3);
        click(cbxNZD);
        waitElementToBeEnabled(cbxUSD,3);
        click(cbxUSD);

        // Submit
        Thread.sleep(1000);
        click("(//input[@type='submit'])[1]");


        //Contains Text
        Assert.assertTrue(isElementDisplayed(containsTxt));
        System.out.println("User cannot create PTP");

        //Close Window
        //click("//td[@title='Close']"); // Close Window



    }




}
