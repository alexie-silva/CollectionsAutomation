package PageObject.MultiPTPsPage;
import Utilities.Action;

public class CollectionPage extends Action {

    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String dpdlstCollectionStatus = "//option[@value='119']";
    public String dpdCollectionStatus = "//select[@name='ctl00$contentPlaceHolder$searchPickListDDL']";
    public String dpdlstCollectionStatusActive = "//option[@value='5']";
    public String rbtnFirstAccount = "(//input[@name='rdEmpID'])[1]";
    public String btnLHSMenu = "//img[@src='/CWX_RADR_AT/App_Themes/Flat/images/icon_menu.png']";
    public String liPaymentArrangements = "//span[@title='Alt+Shift+S']";
    public String lnkPaymentArrangementsAddNewItem = "(//a[@class='Link_menu'])[2]";
    public String txtbxPaymentArrangementPromiseAmount = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_txtAmount']";
    public String frmHeader = "//frame[@name='cwx_header']";
    public String frmContent = "//frame[@name='cwx_content']";
    public String frmTopFrame = "//frame[@name='searchTopFrame']";
    public String frmMidFrame = "//frameset[@name='midFrame']";
    public String frmRightFrame = "//frame[@id='rightFrame']";
    public String frmLeftFrame = "//div[@class='LeftFrame']";
    public String frmSearchResults = "//frame[@name='searchResultFrame']";

    public String lnkPromiseDue = "//span[@class='Promise Due'";
}
