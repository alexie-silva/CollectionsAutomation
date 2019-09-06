package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CustomerLevelMultiInstallmentPtpPage;

public class CustomerLevelMultiInstallmentPtpActions extends CustomerLevelMultiInstallmentPtpPage {

    public void multiInstallmentPtp() throws InterruptedException {

        click(lnkCollection);
        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        Thread.sleep(3000);
        click(dpdlstCollectionStatus);
        Thread.sleep(3000);
        type(txtbxFCIDN, "6100520884");





    }
}
