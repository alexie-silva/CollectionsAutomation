package PageObjectImplementation.MultiPTPsModule;
import PageObject.MultiPTPsPage.CustomerLevelPage;
import org.junit.Assert;
import org.openqa.selenium.By;

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
        Thread.sleep(1000);
        switchFrame(frmTopFrame);
        Thread.sleep(1000);
        click(dpdlstCollectionStatus);
        waitElementToBeEnabled(txtbxAccountNumber, 2);
        type(txtbxAccountNumber, "04279203");
        Thread.sleep(3000);

        click(btnSearch);
        Thread.sleep(2000);

        switchDefault();
        Thread.sleep(1000);
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
        //click(txtFCIDN);

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

        click(dpdValue);
        Thread.sleep(1000);
        click(dpdValue1);
        waitElementToBeEnabled(btnApply, 3);
        click(btnApply);

        // Click checkbox
        waitElementToBeEnabled(cbxNZD, 3);
        click(cbxNZD);
        waitElementToBeEnabled(cbxUSD, 3);
        click(cbxUSD);

        // Submit
        Thread.sleep(1000);
        click(btnOKSubmit);
        Thread.sleep(5000);

        Assert.assertTrue(isElementDisplayed(containsTxt));
        System.out.println("Passed: Cannot Create PTP");

        switchDefault();
        click(btnWindowClose);

        driver.switchTo().window(parent);

    }

    public void singleInstallmentPTP() throws InterruptedException {

        waitElementToBeEnabled("//frame[@name='cwx_header']", 3);
        switchFrame("//frame[@name='cwx_header']");

        click(lnkCollection);
        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        click(dpdlstCollectionStatus);
        Thread.sleep(3000);
        type(txtbxFCIDN, "04279211");

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
        waitElementToBeEnabled(txtbxDate, 2000);
        driver.findElement(By.xpath(txtbxDate)).clear();
        Thread.sleep(2000);
        type(txtbxDate, "26092019");

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

        switchDefault();
        click(btnWindowClose);

        driver.switchTo().window(parent);

    }


    public void multiInstallmentPtp() throws InterruptedException {



        /*Pre-Condition:
        FCIDN with 3 AUD Accounts, 3 NZD Accounts, 3 USD Accounts and 2 SGD Accounts.
        All accounts must be CT-Bill and Account Currency is indicated on CMS for each account*/


        //Search Account
        waitElementToBeEnabled("//frame[@name='cwx_header']", 3);
        switchFrame("//frame[@name='cwx_header']");

        click(lnkCollection);
        switchDefault();
        Thread.sleep(1000);
        switchFrame(frmContent);
        Thread.sleep(1000);
        switchFrame(frmTopFrame);
        Thread.sleep(1000);
        click(dpdlstCollectionStatus2);
        Thread.sleep(1000);
        type(txtbxFCIDN, "5816513001");
        waitElementToBeDisplayed(btnSearch, 3);
        click(btnSearch);
        Thread.sleep(3000);


        //Radio Button Click
        driver.switchTo().defaultContent();
        switchFrame(frmContent);
        switchFrame(frmSearchResults1);
        String parent = driver.getWindowHandle(); // Store the current window handle
        click(rdbtnAccount1);
        Thread.sleep(3000);
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        //Click FCIDN
        switchFrame(frmFCIDN1);
        click(btnFCIDN1);
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
        click(dpdValueItem);
        Thread.sleep(1000);
        click(dpdValueIsNotNull);
        Thread.sleep(1000);
        click(btnApply);


        //Select Checkbox
        String parent1 = driver.getWindowHandle(); // Store the current window handle
        waitElementToBeEnabled(chkbxValue01, 2);
        click(chkbxValue01);
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
        type(txtbxAmount, "300");


        driver.findElement(By.xpath(txtbxDate)).clear();
        Thread.sleep(2000);
        type(txtbxDate, "26092019");

        waitElementToBeEnabled(txtbxInstallment, 2000);
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
        System.out.println("Multiple Installment PTP was verified created.");

        switchDefault();
        click(btnWindowClose);

        driver.switchTo().window(parent);

    }


    public void multiVaryingInstallmentPtp() throws InterruptedException {

        waitElementToBeEnabled("//frame[@name='cwx_header']", 3);
        switchFrame("//frame[@name='cwx_header']");

        //Search Account
        click(lnkCollection);
        switchDefault();
        Thread.sleep(1000);
        switchFrame(frmContent);
        Thread.sleep(1000);
        switchFrame(frmTopFrame);
        Thread.sleep(1000);
        click(dpdlstCollectionStatus2);
        Thread.sleep(1000);
        type(txtbxFCIDN, "6100520884");
        waitElementToBeDisplayed(btnSearch, 3);
        click(btnSearch);
        Thread.sleep(3000);


        //Radio Button Click
        driver.switchTo().defaultContent();
        switchFrame(frmContent);
        switchFrame(frmSearchResults);
        String parent = driver.getWindowHandle(); // Store the current window handle
        click(rdbtnAccountVarying);
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
        waitElementToBeEnabled(chkbxValueVar1, 2);
        click(chkbxValueVar1);
        Thread.sleep(3000);
        waitElementToBeEnabled(chkbxValueVar2, 2);
        click(chkbxValueVar2);
        Thread.sleep(3000);
        click(btnOK);

        //Collapse Account List
        for (String child : driver.getWindowHandles()) // Switch to new window opened

        {
            driver.switchTo().window(child);
        }

        switchFrame(frmAddPaymentArrangement1);

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
        Thread.sleep(2000);

        //Save Created Grid Payment
        click(btnSaveGrid1);
        Thread.sleep(5000);


        String parent2 = driver.getWindowHandle(); // Store the current window handle
        click(btnContinue2);
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