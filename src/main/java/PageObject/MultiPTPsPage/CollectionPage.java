package PageObject.MultiPTPsPage;
import Utilities.Action;

public class CollectionPage extends Action {

    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String dpdlstCollectionStatus = "//option[@value='119']";
    public String dpdCollectionStatus = "//select[@name='ctl00$contentPlaceHolder$searchPickListDDL']";
    public String dpdlstCollectionStatusActive = "//option[@value='5']";
    public String dpdlstCollectionStatusDispute = "//option[@value='18']";
    public String txtbxCollectorSearch = "//input[@id='ctl00_contentPlaceHolder_collectorSearchText']";
    public String rbtnFirstAccount = "(//input[@name='rdEmpID'])[1]";
    public String lblFirstAccountNumber = "//*[@id='ctl00_contentPlaceHolder_rGResult_ctl01']/tbody/tr[1]/td[3]";
    public String btnLHSMenu = "//img[@src='/CWX_RADR_AT/App_Themes/Flat/images/icon_menu.png']";
    public String frmContent = "//frame[@name='cwx_content']";
    public String frmTopFrame = "//frame[@name='searchTopFrame']";
    public String frmSearchResults = "//frame[@name='searchResultFrame']";
    public String frmLHSContent = "//iframe[@class='RadWContentFrame']";
    public String frmCMS = "//iframe[@id='ctl00_contentPlaceHolder_ifrSingleView']";

// Disputes
    public String liDisputes = "//span[@title='Alt+Shift+R']";
    public String lnkDisputesAddNewItem = "//a[@class='Link_menu']";
    public String txtbxDisputeReferenceNo = "//input[@id='ctl00_contentPlaceHolder_txtReferenceNumber']";
    public String txtbxDisputeInvoiceNo = "//input[@id='ctl00_contentPlaceHolder_txtInvoiceNumber']";
    public String txtbxDisputeAmount = "//input[@id='ctl00_contentPlaceHolder_txtAmount_text']";
    public String cbxDisputeQuarantined = "//input[@id='ctl00_contentPlaceHolder_cbAmountIsQuarantined']";
    public String txtbxDisputeRemarks = "//textarea[@id='ctl00_contentPlaceHolder_txtRemarks']";
    public String btnDisputeSave = "//input[@id='ctl00_contentPlaceHolder_btnSave']";
    public String btnDisputeClose = "(//img[@class='RadWButton'])[4]";

// Payment Arrangements
    public String liPaymentArrangements = "//span[@title='Alt+Shift+S']";
    public String lnkPaymentArrangementsAddNewItem = "(//a[@class='Link_menu'])[2]";
    public String txtbxPaymentArrangementPromiseAmount = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_txtAmount']";
    public String txtbxPaymentArrangementDate = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_rdpkStartingOn_dateInput']";
    public String btnPaymentArrangementSave = "//a[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl00_lnkSave']";
    public String btnPaymentArrangementContinue = "//input[@value='Continue']";
}
