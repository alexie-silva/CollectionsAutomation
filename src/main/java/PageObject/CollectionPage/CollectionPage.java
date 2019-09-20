package PageObject.CollectionPage;
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
    public String frmHeader = "//frame[@name='cwx_header']";
    public String btnClose = "(//img[@class='RadWButton'])[4]";
    public String btnRequestOrCancelYes = "//button[@id='yesButton']";
    public String btnRequestOrCancelOk = "//button[@id='alertbutton']";

// Disputes
    public String liDisputes = "//span[@title='Alt+Shift+R']";
    public String lnkDisputesAddNewItem = "//a[@class='Link_menu']";
    public String txtbxDisputeReferenceNo = "//input[@id='ctl00_contentPlaceHolder_txtReferenceNumber']";
    public String txtbxDisputeInvoiceNo = "//input[@id='ctl00_contentPlaceHolder_txtInvoiceNumber']";
    public String txtbxDisputeAmount = "//input[@id='ctl00_contentPlaceHolder_txtAmount_text']";
    public String cbxDisputeQuarantined = "//input[@id='ctl00_contentPlaceHolder_cbAmountIsQuarantined']";
    public String txtbxDisputeRemarks = "//textarea[@id='ctl00_contentPlaceHolder_txtRemarks']";
    public String btnDisputeSave = "//input[@id='ctl00_contentPlaceHolder_btnSave']";

// Payment Arrangements
    public String liPaymentArrangements = "//span[@title='Alt+Shift+S']";
    public String lnkPaymentArrangementsAddNewItem = "(//a[@class='Link_menu'])[2]";
    public String txtbxPaymentArrangementPromiseAmount = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_txtAmount']";
    public String txtbxPaymentArrangementDate = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_rdpkStartingOn_dateInput']";
    public String dpdPaymentArrangementFrequency = "(//span[@class='rddlIcon'])[2]";
    public String btnPaymentArrangementSave = "//a[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl00_lnkSave']";
    public String btnPaymentArrangementContinue = "//input[@value='Continue']";
    public String btnPaymentArrangementContinueSave = "//input[@name='ctl00$contentPlaceHolder$btnSave']";
    public String cbxPaymentArrangement = "(//input[@name='chkPromiseID'])[1]";
    public String btnPaymentArrangementCancel = "//input[@name='ctl00$contentPlaceHolder$ucPromiseDueGridControl$btnCancel']";
    public String tbPaymentArrangementPromiseHistory = "//a[@id='tabPromiseHistory']";
    public String txtbxPaymentArrangementInstalment = "//input[@name='ctl00$contentPlaceHolder$gridPromise$ctl00$ctl02$ctl03$txtFrequencyNumber']";
    public String lblPaymentArrangementDateValidation = "//span[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_valCustomPromiseStartDateValidation']";

// Correspondence
    public String liCorrespondence = "//span[@title='Alt+Shift+L']";
    public String lnkCorrespondenceSendLetter = "(//a[@class='Link_menu'])[1]";
    public String lnkCorrespondenceSendEmail = "(//a[@class='Link_menu'])[2]";
    public String dpdCorrespondenceTemplate = "//a[@id='ctl00_contentPlaceHolder_ddlAvailableLetters_Arrow']";
    public String liPaymentArrangementWithDispute = "(//input[@class='rcbCheckBox'])[14]";
    public String dpdCorrespondenceRecipient = "//span[@id='ctl00_contentPlaceHolder_cbRecipient_Arrow']";
    public String cbxCorrespondenceRecipient = "(//input[@class='rcbCheckBox'])[1]";
    public String btnCorrespondenceRequest = "//input[@name='ctl00$contentPlaceHolder$btnOrderLetter']";
    public String cbxCorrespondenceTemplate = "(//input[@class='rcbCheckBox'])[2]";
    public String txtbxCorrespondenceTo = "//input[@name='ctl00$contentPlaceHolder$radToAddress']";

}
