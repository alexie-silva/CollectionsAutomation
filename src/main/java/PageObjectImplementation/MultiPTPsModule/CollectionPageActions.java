<<<<<<< HEAD:src/main/java/PageObjectImplementation/MultiPTPsModule/CollectionPageActions.java
package PageObjectImplementation.MultiPTPsModule;
import PageObject.MultiPTPsPage.CollectionPage;
=======
package PageObjectImplementation.CollectionModule;

import PageObject.CollectionPage.CollectionPage;
import org.testng.Assert;
>>>>>>> 723c062a79965b5a6fa44e061f2764c8e8ea3a57:src/main/java/PageObjectImplementation/CollectionModule/CollectionPageActions.java

public class CollectionPageActions extends CollectionPage {

    public void searchAccountActive() throws InterruptedException {
        click(lnkCollection);

        switchDefault();
        Thread.sleep(2000);
        switchFrame(frmContent);
        Thread.sleep(2000);
        switchFrame(frmTopFrame);
        Thread.sleep(2000);

// Select dropdowns (Dispute)
        click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusActive, 3);
        click(dpdlstCollectionStatusActive);

        switchDefault();
        Thread.sleep(2000);
        switchFrame(frmContent);
        Thread.sleep(2000);
        switchFrame(frmSearchResults);
        Thread.sleep(2000);

// Get account number for future search
        String accountNumber = getText(lblFirstAccountNumber);

// Click the first account on the results
        click(rbtnFirstAccount);
    }

    public void disputes() throws InterruptedException {
        for (String child : driver.getWindowHandles()) // Switch to new window opened
        {
            driver.switchTo().window(child);
        }

        maximizeBrowser();
        switchFrame(frmCMS);

// Get the collectable amount for future search
        String collectableAmount = getText("//*[@id='details']/fieldset[1]/div[1]/div[4]/div/div").replace("$", "").replace(",", "");

        switchDefault();
        click(btnLHSMenu);
        click(liDisputes);
        switchFrame(frmLHSContent);
        waitElementToBeDisplayed(lnkDisputesAddNewItem, 3);
        click(lnkDisputesAddNewItem);

        String referenceNo = readExcel("TestData.xlsx", "Disputes", 1, 1);
        String invoiceNo = readExcel("TestData.xlsx", "Disputes", 2, 1);
        String disputeAmount = readExcel("TestData.xlsx", "Disputes", 3, 1);
        String remarks = readExcel("TestData.xlsx", "Disputes", 4, 1);

        type(txtbxDisputeReferenceNo, referenceNo);
        type(txtbxDisputeInvoiceNo, invoiceNo);
        type(txtbxDisputeAmount, disputeAmount);
        click(cbxDisputeQuarantined);
        type(txtbxDisputeRemarks, remarks);
        click(btnDisputeSave);
        switchDefault();
        click(btnDisputeClose);

        switchFrame(frmCMS);
        String newCollectableAmount = getText("//*[@id='details']/fieldset[1]/div[1]/div[4]/div/div").replace("$", "").replace(",", "");

        float cA = Float.parseFloat(collectableAmount);
        float dA = Float.parseFloat(disputeAmount);
        float diff = cA-dA;
        float ncA = Float.parseFloat(newCollectableAmount);

        Assert.assertEquals(diff, ncA);

        switchDefault();
        click(btnLHSMenu);
        click(liPaymentArrangements);
        switchFrame(frmLHSContent);
        waitElementToBeDisplayed(lnkPaymentArrangementsAddNewItem, 3);
        click(lnkPaymentArrangementsAddNewItem);
        click(txtbxPaymentArrangementPromiseAmount);
        type(txtbxPaymentArrangementPromiseAmount, "1000");
        String paymentDate = getCurrentDate("dd-mm-yyyy");
        type(txtbxPaymentArrangementDate, paymentDate);
        Thread.sleep(5000);
//        click(btnPaymentArrangementContinue);
    }
}

        /*click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusDispute, 5);
        click(dpdlstCollectionStatusDispute);

// Switch frame
        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmSearchResults);
        Thread.sleep(3000);

// Check if there are accounts under Dispute
        if (isElementDisplayed(lblNoRecordFound))
        {
            click(rbtnFirstAccount);
        }

        type(txtbxCollectorSearch, accountNumber);

        String parent = driver.getWindowHandle(); // Store the current window handle

}*/

