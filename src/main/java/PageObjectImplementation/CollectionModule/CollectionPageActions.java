package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CollectionPage;

public class CollectionPageActions extends CollectionPage {

    public void searchAccount() throws InterruptedException {
        switchFrame(frmHeader);
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
        Thread.sleep(3000);
        click(rbtnFirstAccount);

        ToNewWindow();
        waitElementToBeDisplayed(btnLHSMenu, 10);
        click(btnLHSMenu);

    }
}
