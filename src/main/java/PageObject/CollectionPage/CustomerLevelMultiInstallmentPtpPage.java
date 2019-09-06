package PageObject.CollectionPage;
import Utilities.Action;


public class CustomerLevelMultiInstallmentPtpPage extends Action {


    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String frmContent = "//frame[@name='cwx_content']";
    public String frmTopFrame = "//frame[@name='searchTopFrame']";
    public String dpdlstCollectionStatus = "//option[@value='114']";
    public String txtbxFCIDN = "//input[@id='ctl00_contentPlaceHolder_collectorSearchText']";
    public String btnSearch = "//input[@name='collectorSearchButton']";
    public String rdbtnAccount = "(//input[@name='rdEmpID'])[5]";
    public String frmSearchResults = "//frame[@name='searchResultFrame']";



}
