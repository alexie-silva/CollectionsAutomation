package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CollectionPage;

public class CollectionActions extends CollectionPage {

    public void searchAccount() {
        switchFrame(frmHeader);
        click(lnkCollection);

        switchFrame(frmContent);
        switchFrame(frmTopFrame);

        
    }
}
