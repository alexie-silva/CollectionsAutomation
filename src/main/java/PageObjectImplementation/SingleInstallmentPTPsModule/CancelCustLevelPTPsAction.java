package PageObjectImplementation.SingleInstallmentPTPsModule;
import PageObject.SingleInstallmentPTPsPage.CancelCustLevelPTPsPage;


public class CancelCustLevelPTPsAction extends CancelCustLevelPTPsPage {

    public void cancelPTP () throws InterruptedException{

        click(lnkCollection);

        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        Thread.sleep(3000);
        click(dpdlstCollectionStatus);


    }
}
