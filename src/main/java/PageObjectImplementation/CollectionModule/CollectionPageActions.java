package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CollectionPage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Date Created: August 26, 2019
// Author: Alexie Silva

public class CollectionPageActions extends CollectionPage {

    String parent;

// Test Case: Create a single instalment PTP for an account with an existing Dispute where there is an undisputed amount
    public void searchAccountActive() throws InterruptedException {
        click(lnkCollection);

        switchDefault();
        Thread.sleep(1500);
        switchFrame(frmContent);
        Thread.sleep(1500);
        switchFrame(frmTopFrame);
        Thread.sleep(1500);

// Select dropdowns (Dispute)
        click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusActive, 3);
        click(dpdlstCollectionStatusActive);

        switchDefault();
        Thread.sleep(1500);
        switchFrame(frmContent);
        Thread.sleep(1500);
        switchFrame(frmSearchResults);
        Thread.sleep(1500);

// Get account number for future search
        String accountNumber = getText(lblFirstAccountNumber);

        parent = driver.getWindowHandle();

// Click the first account on the results
        click(rbtnFirstAccount);

// Switch window

        for (String child : driver.getWindowHandles()) // Switch to new window opened
        {
            driver.switchTo().window(child);
        }
        maximizeBrowser();
    }

    public void dispute() throws InterruptedException {
        waitElementToBeEnabled(frmCMS, 3);
        switchFrame(frmCMS);

// Get the original collectable amount removing special characters
        String collectableAmount = getText("//*[@id='details']/fieldset[1]/div[1]/div[4]/div/div").replace("$", "").replace(",", "");

// Add Dispute
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
        click(btnClose);

        switchFrame(frmCMS);
// Get the text of the new collectable amount removing special characters
        String newCollectableAmount = getText("//*[@id='details']/fieldset[1]/div[1]/div[4]/div/div").replace("$", "").replace(",", "");

// Convert getText strings to float
        float cA = Float.parseFloat(collectableAmount);
        float dA = Float.parseFloat(disputeAmount);
        float diff = cA - dA;
        float nCa = Float.parseFloat(newCollectableAmount);
        try {
            Assert.assertEquals(diff, nCa);
            System.out.println("THE COLLECTABLE AMOUNT HAS BEEN REDUCED BY THE AMOUNT OF THE DISPUTE ENTERED");
        } catch (Exception e) {
            System.out.println("***THE COLLECTABLE AMOUNT HAS NOT BEEN REDUCED BY THE AMOUNT OF THE DISPUTE ENTERED");
        }
    }

    public void singlePTP() throws InterruptedException {
        switchDefault();
        click(btnLHSMenu);
        click(liPaymentArrangements);
        switchFrame(frmLHSContent);
        waitElementToBeDisplayed(lnkPaymentArrangementsAddNewItem, 3);
        click(lnkPaymentArrangementsAddNewItem);

// Get the date 15 days after today
        String daysAfterToday = LocalDate.now().plusDays(15).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        driver.findElement(By.xpath(txtbxPaymentArrangementPromiseAmount)).clear();
        Thread.sleep(1000);
        type(txtbxPaymentArrangementPromiseAmount, "1000");
        driver.findElement(By.xpath(txtbxPaymentArrangementDate)).clear();
        Thread.sleep(1000);
        click(txtbxPaymentArrangementDate);
        type(txtbxPaymentArrangementDate, daysAfterToday);
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(btnPaymentArrangementSave, 3);
        click(btnPaymentArrangementSave);
        waitElementToBeEnabled(btnPaymentArrangementContinue, 3);
        click(btnPaymentArrangementContinue);
        waitElementToBeEnabled(btnPaymentArrangementContinueSave, 3);
        click(btnPaymentArrangementContinueSave);
        switchDefault();
        click(btnClose);
    }

// Test Case: Payment Arrangement (with dispute) Letter for account with PTP
    public void correspondenceLetter() throws InterruptedException {
        switchDefault();
        click(btnLHSMenu);
        click(liCorrespondence);
        switchFrame(frmLHSContent);
        click(lnkCorrespondenceSendLetter);
        click(dpdCorrespondenceTemplate);
        waitElementToBeEnabled(liPaymentArrangementWithDispute, 3);
        click(liPaymentArrangementWithDispute);
        click(dpdCorrespondenceTemplate);
        waitElementToBeEnabled(dpdCorrespondenceRecipient, 3);
        click(dpdCorrespondenceRecipient);
        waitElementToBeEnabled(cbxCorrespondenceRecipient, 3);
        click(cbxCorrespondenceRecipient);
        click(btnCorrespondenceRequest);
        switchFrame(frmLHSContent);
        click(btnRequestOrCancelYes);
        Thread.sleep(1000);
        switchDefault();
        switchFrame(frmLHSContent);
        switchFrame(frmLHSContent);
        click(btnRequestOrCancelOk);
        switchDefault();
        switchFrame(frmLHSContent);
        try {
            Assert.assertTrue(isContainText("//a[@id='ctl00_contentPlaceHolder_radGridLetterPending_ctl00_ctl04_lnkLetterDesc']", "Payment Arrangement - with dispute"));
            System.out.println("CORRESPONDENCE LETTER WAS DISPLAYED UNDER PENDING TAB");
        } catch (Exception e) {
            System.out.println("***CORRESPONDENCE LETTER WAS NOT DISPLAYED UNDER PENDING TAB");
        }
    }

// Test Case: Payment Arrangement (with dispute) Email for account with PTP
    public void correspondenceEmail() throws InterruptedException {
        click(lnkCorrespondenceSendEmail);
        click(dpdCorrespondenceTemplate);
        waitElementToBeEnabled(cbxCorrespondenceTemplate, 3);
        click(cbxCorrespondenceTemplate);
        click(dpdCorrespondenceTemplate);
        waitElementToBeEnabled(txtbxCorrespondenceTo, 3);
        click(txtbxCorrespondenceTo);
        Thread.sleep(1000);
        type(txtbxCorrespondenceTo, "test@ignore.com");
        click(btnCorrespondenceRequest);
        Thread.sleep(1000);
        click(btnCorrespondenceRequest);
        switchFrame(frmLHSContent);
        click(btnRequestOrCancelYes);
        Thread.sleep(1000);
        switchDefault();
        switchFrame(frmLHSContent);
        switchFrame(frmLHSContent);
        click(btnRequestOrCancelOk);
        switchDefault();
        switchFrame(frmLHSContent);
        try {
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_radGridLetterPending_ctl00__0']/td[4]/div", "test@ignore.com"));
            System.out.println("CORRESPONDENCE EMAIL WAS DISPLAYED UNDER PENDING TAB");
        } catch (Exception e) {
            System.out.println("***CORRESPONDENCE EMAIL WAS NOT DISPLAYED UNDER PENDING TAB");
        }
        switchDefault();
        click(btnClose);
    }

// Test Case: Cancel an account level PTP that does not require approval
    public void cancelPaymentArrangement() throws InterruptedException {
        switchDefault();
        click(btnLHSMenu);
        click(liPaymentArrangements);
        switchFrame(frmLHSContent);

        String promiseGiverPromiseDue = getText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__0']/td[9]");

        waitElementToBeEnabled(cbxPaymentArrangement, 3);
        click(cbxPaymentArrangement);
        click("//option[@value='4']");
        click(btnPaymentArrangementCancel);
        switchFrame(frmLHSContent);
        click(btnRequestOrCancelYes);
        switchDefault();
        switchFrame(frmLHSContent);
        waitElementToBeEnabled(tbPaymentArrangementPromiseHistory, 3);
        click(tbPaymentArrangementPromiseHistory);

// Get the text of the last row that is constantly changing after each cancellation
        String promiseGiverPromiseHistory = getText("(//div[@id='ctl00_contentPlaceHolder_ucPromiseListGridHistory_radPromiseAccountPromiseList']//table//tr)[last()]//td[9]");
        switchDefault();
        click(btnClose);
        try {
            Assert.assertEquals(promiseGiverPromiseDue, promiseGiverPromiseHistory);
            System.out.println("CANCELLED PAYMENT ARRANGEMENT WAS ADDED ON THE PROMISE HISTORY TABLE");
        } catch (Exception e) {
            System.out.println("***CANCELLED PAYMENT ARRANGEMENT WAS NOT ADDED ON THE PROMISE HISTORY TABLE");
        }
    }

// Test Case: Multi Installment PTP against the full Net Debt of an account
    public void createMultiInstallmentPTPfullNetDebt() throws InterruptedException {
        String child = driver.getWindowHandle();
        if(child != null){
            driver.close();
            driver.switchTo().window(parent);
        }
        switchFrame(frmHeader);
        searchAccountActive();
        switchFrame(frmCMS);

// Get the net debt amount to be entered as promise amount later
        String netDebt = getText("//*[@id='details']/fieldset[1]/div[1]/div[1]/div/div").replace("$", "").replace(",", "");

// Convert getText strings to float
        float nD = Float.parseFloat(netDebt);
        float promiseAmount = nD / 3;

// Convert float to string rounding off to 2 decimals

        String newPromiseAmount = String.format("%.2f",promiseAmount);

        switchDefault();
        click(btnLHSMenu);
        click(liPaymentArrangements);
        switchFrame(frmLHSContent);
        waitElementToBeDisplayed(lnkPaymentArrangementsAddNewItem, 3);
        click(lnkPaymentArrangementsAddNewItem);

        driver.findElement(By.xpath(txtbxPaymentArrangementPromiseAmount)).clear();
        Thread.sleep(1000);
        type(txtbxPaymentArrangementPromiseAmount, newPromiseAmount);
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(dpdPaymentArrangementFrequency, 3);
        click(dpdPaymentArrangementFrequency);
        Thread.sleep(1500);
        click("//li[contains(text(), 'Monthly')][1]");
        Thread.sleep(1500);
        driver.findElement(By.xpath(txtbxPaymentArrangementInstalment)).clear();
        Thread.sleep(1000);
        type(txtbxPaymentArrangementInstalment, "3");
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(btnPaymentArrangementSave, 3);
        click(btnPaymentArrangementSave);
        waitElementToBeEnabled(btnPaymentArrangementContinue, 3);
        click(btnPaymentArrangementContinue);
        waitElementToBeEnabled(btnPaymentArrangementContinueSave, 3);
        click(btnPaymentArrangementContinueSave);
        switchDefault();
        switchFrame(frmLHSContent);

        float nPa = Float.parseFloat(newPromiseAmount);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String verifyPromiseAmount = decimalFormat.format(nPa);
        try {
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__0']/td[5]", verifyPromiseAmount));
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__1']/td[5]", verifyPromiseAmount));
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__2']/td[5]", verifyPromiseAmount));
            System.out.println("MULTI INSTALLMENT PAYMENT ARRANGEMENT (FULL NET DEBT) WAS DISPLAYED ON THE PROMISE DUE TAB");
        } catch (Exception e) {
            System.out.println("***MULTI INSTALLMENT PAYMENT ARRANGEMENT (FULL NET DEBT) WAS NOT DISPLAYED ON THE PROMISE DUE TAB");
        }
        switchDefault();
        click(btnClose);
    }

// Test Case: Multi Installment PTP against the partial Net Debt of an account
    public void createMultiInstallmentPTPpartialNetDebt() throws InterruptedException {
        String child = driver.getWindowHandle();
        if(child != null){
            driver.close();
            driver.switchTo().window(parent);
        }
        switchFrame(frmHeader);
        searchAccountActive();
        switchFrame(frmCMS);

// Get the net debt amount to be entered as promise amount later
        String netDebt = getText("//*[@id='details']/fieldset[1]/div[1]/div[1]/div/div").replace("$", "").replace(",", "");

// Convert getText strings to float
        float nD = Float.parseFloat(netDebt);
        float promiseAmount = nD / 12;

// Convert float to string rounding off to 2 decimals

        String newPromiseAmount = String.format("%.2f",promiseAmount);
        String daysExceed = LocalDate.now().plusDays(35).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String today = getCurrentDate("dd-MM-yyyy");

        switchDefault();
        click(btnLHSMenu);
        click(liPaymentArrangements);
        switchFrame(frmLHSContent);
        waitElementToBeDisplayed(lnkPaymentArrangementsAddNewItem, 3);
        click(lnkPaymentArrangementsAddNewItem);

        driver.findElement(By.xpath(txtbxPaymentArrangementPromiseAmount)).clear();
        Thread.sleep(1000);
        type(txtbxPaymentArrangementPromiseAmount, newPromiseAmount);

// Test Case: Unable to create PTP with first instalment date more than 30 days from today
        driver.findElement(By.xpath(txtbxPaymentArrangementDate)).clear();
        Thread.sleep(1000);
        click(txtbxPaymentArrangementDate);
        type(txtbxPaymentArrangementDate, daysExceed);
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(btnPaymentArrangementSave, 3);
        click(btnPaymentArrangementSave);
        waitElementToBeEnabled(lblPaymentArrangementDateValidation, 3);
        try {
            Assert.assertTrue(isContainText(lblPaymentArrangementDateValidation, "Exceeded acceptable starting date of an instalment"));
            System.out.println("ERROR MESSAGE UNDER THE DATE FIELD WAS DISPLAYED");
        } catch (Exception e) {
            System.out.println("***ERROR MESSAGE UNDER THE DATE FIELD WAS NOT DISPLAYED");
        }

        driver.findElement(By.xpath(txtbxPaymentArrangementDate)).clear();
        Thread.sleep(1000);
        click(txtbxPaymentArrangementDate);
        type(txtbxPaymentArrangementDate, today);
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(dpdPaymentArrangementFrequency, 3);
        click(dpdPaymentArrangementFrequency);
        Thread.sleep(1500);
        click("//li[contains(text(), 'Monthly')][1]");
        Thread.sleep(1500);
        driver.findElement(By.xpath(txtbxPaymentArrangementInstalment)).clear();
        Thread.sleep(1000);
        type(txtbxPaymentArrangementInstalment, "3");
        click("//div[contains(text(), 'No records to display.')]");
        waitElementToBeEnabled(btnPaymentArrangementSave, 3);
        click(btnPaymentArrangementSave);
        waitElementToBeEnabled(btnPaymentArrangementContinue, 3);
        click(btnPaymentArrangementContinue);
        waitElementToBeEnabled(btnPaymentArrangementContinueSave, 3);
        click(btnPaymentArrangementContinueSave);
        switchDefault();
        switchFrame(frmLHSContent);

        float nPa = Float.parseFloat(newPromiseAmount);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String verifyPromiseAmount = decimalFormat.format(nPa);
        try {
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__0']/td[5]", verifyPromiseAmount));
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__1']/td[5]", verifyPromiseAmount));
            Assert.assertTrue(isContainText("//*[@id='ctl00_contentPlaceHolder_ucPromiseDueGridControl_radPromiseAccountPromiseList_ctl00__2']/td[5]", verifyPromiseAmount));
            System.out.println("MULTI INSTALLMENT PAYMENT ARRANGEMENT (PARTIAL NET DEBT) WAS DISPLAYED ON THE PROMISE DUE TAB");
        } catch (Exception e) {
            System.out.println("***MULTI INSTALLMENT PAYMENT ARRANGEMENT (PARTIAL NET DEBT) WAS NOT DISPLAYED ON THE PROMISE DUE TAB");
        }
        switchDefault();
        click(btnClose);
        driver.close();
        driver.switchTo().window(parent);
    }
}
