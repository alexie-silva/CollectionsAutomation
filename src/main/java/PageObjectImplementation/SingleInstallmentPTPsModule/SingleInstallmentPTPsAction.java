package PageObjectImplementation.SingleInstallmentPTPsModule;
import PageObject.SingleInstallmentPTPsPage.SingleInstallmentPTPsPage;
import org.junit.Assert;
import org.openqa.selenium.By;


public class SingleInstallmentPTPsAction extends SingleInstallmentPTPsPage {

    public void ptpSingleIntallmentCreation () throws InterruptedException{

        click(lnkCollection);

        //Search Account
        switchDefault();
        Thread.sleep(1000);
        switchFrame(frmContent);
        Thread.sleep(1000);
        switchFrame(frmTopFrame);
        Thread.sleep(1000);
        click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusActive, 5);
        click(dpdlstCollectionStatusActive);
        //Frame
        switchDefault();
        Thread.sleep(1000);
        switchFrame(frmContent);
        Thread.sleep(1000);
        switchFrame(frmSearchResults);
        Thread.sleep(1000);

        //Click Radio Button
        String parentWinHandle = driver.getWindowHandle(); // Store the current window handle
        click(rdbtnAccount);

        for (String handle : driver.getWindowHandles()) // Switch to new window opened
        {
            driver.switchTo().window(handle);
        }

        //Click FCIDN
        switchFrame(frmFCIDN);
        click(btnFCIDN);
        Thread.sleep(3000);

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

        click("(//span[@class='t-font-icon rgIcon rgExpandIcon'])[2]"); // collapse button
        Thread.sleep(2000);
        click("(//span[@class='t-font-icon rgIcon rgExpandIcon'])[2]"); // collapse button
        Thread.sleep(2000);

//        waitElementToBeEnabled(dpdFrequency, 2000);
//        click(dpdFrequency);
//        Thread.sleep(3000);
//        click(dpdFrequencyMonthly);
//        Thread.sleep(3000);

        waitElementToBeEnabled(txtbxAmount, 2000);
        //click(txtbxAmount);
        driver.findElement(By.xpath(txtbxAmount)).clear();
        Thread.sleep(2000);
        type(txtbxAmount, "9377.13");

        driver.findElement(By.xpath(txtbxDate)).clear();
        Thread.sleep(2000);
        type(txtbxDate, "13092019");


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

        Thread.sleep(3000);
        click(btnSavePayment);
        Thread.sleep(5000);

        //Verification
        Assert.assertTrue(isElementDisplayed(wrdPaymentArrangement));
        System.out.println("Single Instalment PTP against the full Net Debt of all accts under an FCIDN");





    }
}
