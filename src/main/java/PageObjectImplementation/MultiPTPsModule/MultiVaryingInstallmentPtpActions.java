package PageObjectImplementation.MultiPTPsModule;
import PageObject.MultiPTPsPage.MultiVaryingInstallmentPtpPage;
import org.junit.Assert;
import org.openqa.selenium.By;


public class MultiVaryingInstallmentPtpActions extends MultiVaryingInstallmentPtpPage {

    public void multiVaryingInstallmentPtp() throws InterruptedException{

//Search Account
        click(lnkCollection);
        switchDefault();
        Thread.sleep(1000);
        switchFrame(frmContent);
        Thread.sleep(1000);
        switchFrame(frmTopFrame);
        Thread.sleep(1000);
        click(dpdlstCollectionStatus);
        Thread.sleep(1000);
        type(txtbxFCIDN, "6100520884");
        waitElementToBeDisplayed(btnSearch,3);
        click(btnSearch);
        Thread.sleep( 3000);


        //Radio Button Click
        driver.switchTo().defaultContent();
        switchFrame(frmContent);
        switchFrame(frmSearchResults);
        String parent = driver.getWindowHandle(); // Store the current window handle
        click(rdbtnAccount);
        Thread.sleep(3000);
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        //Click FCIDN
        switchFrame(frmFCIDN);
        click(btnFCIDN);
        Thread.sleep(3000);
        Assert.assertTrue(isElementDisplayed(txtCurrency));
        System.out.println("Account Currency is Indicated");

        //Left Hand Side Menu
        switchDefault();
        click(btnLHS);
        Thread.sleep(3000);


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
        Thread.sleep(3000);
        waitElementToBeEnabled(chkbxValue2, 2);
        click(chkbxValue2);
        Thread.sleep(3000);
        click(btnOK);

        //Collapse Account List
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        switchFrame(frmAddPaymentArrangement);

        waitElementToBeEnabled(dpdFrequency, 2000);
        //click(txtbxDate);
        click(dpdFrequency);
        Thread.sleep(3000);
        click(dpdFrequencyMonthly);
        Thread.sleep(3000);

        waitElementToBeEnabled(txtbxAmount, 2000);
        //click(txtbxAmount);
        driver.findElement(By.xpath(txtbxAmount)).clear();
        Thread.sleep(2000);
        type(txtbxAmount, "400");


        driver.findElement(By.xpath(txtbxDate)).clear();
        Thread.sleep(2000);
        type(txtbxDate, "30092019");

        waitElementToBeEnabled(txtbxInstallment, 2000);
        //click(txtbxAmount);
        driver.findElement(By.xpath(txtbxInstallment)).clear();
        Thread.sleep(2000);
        type(txtbxInstallment, "3");

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

        waitElementToBeDisplayed(btnCollapse, 3);
        click(btnCollapse);
        Thread.sleep(3000);
        click(btnSvePayment);
        Thread.sleep(5000);

        //Verification
        Assert.assertTrue(isElementDisplayed(wrdPaymentArrangement));
        System.out.println("Multi Varying Installment  PTP was verified created.");



    }




}
