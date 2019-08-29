package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CustomerLevelPage;


public class CustomerLevelActions extends CustomerLevelPage {

    public void searchAccount(){
        
        waitElementToBeEnabled(lnkCollection);
        click(lnkCollection);
        waitElementToBeEnabled();



    }


}
