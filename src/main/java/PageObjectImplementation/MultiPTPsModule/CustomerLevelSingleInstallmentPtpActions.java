package PageObjectImplementation.MultiPTPsModule;
import PageObject.MultiPTPsPage.CustomerLevelSingleInstallmentPtpPage;
import org.junit.Assert;
import org.openqa.selenium.By;


public class CustomerLevelSingleInstallmentPtpActions extends CustomerLevelSingleInstallmentPtpPage {

    public void singleInstallmentPTP() throws InterruptedException {


        click(lnkCollection);
        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        click(dpdlstCollectionStatus);
        Thread.sleep(3000);
        type(txtbxFCIDN, "6100520884");

        //Search Account
        click(btnSearch);
        Thread.sleep(2000);

        //Radio Button Click
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        switchFrame(frmContent);
        switchFrame(frmSearchResults);

        String parent = driver.getWindowHandle(); // Store the current window handle
        click(rdbtnAccount);
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        //Click FCIDN
        switchFrame(frmFCIDN);
        click(btnFCIDN);
        Thread.sleep(3000);

        //Left Hand Side Menu
        switchDefault();
        click(btnLHS);
        Thread.sleep(5000);

        //Payment Arrangement
        click(btnPaymentArrangement);
        Thread.sleep(1000);
        switchFrame(frmPaymentArrangement);
        click(btnAdvanceView);
        Thread.sleep(3000);
        click(btnAddnewItem);
        Thread.sleep(3000);

        //Remove Value and Apply Changes
        click(btnRemoveItem);
        Thread.sleep(1000);
        click(dpdValue);
        Thread.sleep(1000);
        click(dpdValueIsNotNull);
        Thread.sleep(1000);
        click(btnApply);

        //Select Checkbox
        String parent1 = driver.getWindowHandle(); // Store the current window handle
        waitElementToBeEnabled(chkbxValue1, 2);
        click(chkbxValue1);
        waitElementToBeEnabled(chkbxValue2, 2);
        click(chkbxValue2);
        Thread.sleep(3000);
        click(btnOK);

        //Collapse Account List
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        switchFrame(frmSaveArrangement);
        click(btnExpandAccount1);
        Thread.sleep(2000);
        click(btnExpandAccount2);
        Thread.sleep(2000);


        /*click(btnCalendar);
        click(btnCalendarDate);*/
        waitElementToBeEnabled(txtbxDate, 2000);
        //click(txtbxDate);
        driver.findElement(By.xpath(txtbxDate)).clear();
        Thread.sleep(2000);
        type(txtbxDate, "16092019");

        waitElementToBeEnabled(txtbxAmount, 2000);
        //click(txtbxAmount);
        driver.findElement(By.xpath(txtbxAmount)).clear();
        Thread.sleep(2000);
        type(txtbxAmount, "1000");


        //Save Created Grid Payment
        click(btnSaveGrid);
        Thread.sleep(5000);

        String parent2 = driver.getWindowHandle(); // Store the current window handle
        click(btnContinue);
        Thread.sleep(5000);
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }


        waitElementToBeEnabled(frmSave, 3);
        switchFrame(frmSave);

        click(btnSvePayment);
        Thread.sleep(5000);

        //Verification
        Assert.assertTrue(isElementDisplayed(wrdPaymentArrangement));
        System.out.println("Single Installment PTP was verified created.");

}



}
