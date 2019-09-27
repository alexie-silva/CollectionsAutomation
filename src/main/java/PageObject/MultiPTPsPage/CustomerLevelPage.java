package PageObject.MultiPTPsPage;
import Utilities.Action;

public class CustomerLevelPage extends Action {

        //Unable to Create PTP at FCIDN level for Multiple accounts with different currencies
        //04170901

    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String dpdlstCollectionStatus = "//option[@value='7']";
    public String txtbxAccountNumber = "//input[@id='ctl00_contentPlaceHolder_collectorSearchText']";
    public String rbtnThirdAccount = ("//input[@value='4|7|0|0']");
    public String frmHeader = "//frame[@name='cwx_header']";
    public String frmContent = "//frame[@name='cwx_content']";
    public String frmTopFrame = "//frame[@name='searchTopFrame']";
    public String frmMidFrame = "//frameset[@name='midFrame']";
    public String frmRightFrame = "//frame[@id='rightFrame']";
    public String frmLeftFrame = "//div[@class='LeftFrame']";
    public String frmSearchResults = "//frame[@name='searchResultFrame']";
    public String frmAccountPage = "//body[@style='margin: 0px;']";
    public String txtFCIDN = "//a[@onclick='toggle_tab(1); radr_setTab(1);']";
    public String btnLHS = "(//td[@class='ToolbarButton'])[1]";
    public String btnPaymentArragement = "//span[@class='sp-ic_nav sp-ic_nav_schedule']";
    public String frmPaymentArrangements = "//iframe[@class='RadWContentFrame']";
    public String btnAdvanceView = "(//a[@class='Link_menu'])[1]";
    public String btnAddNewItem = "(//a[@class='Link_menu'])[2]";
    public String btnRemoveItem1 = "(//a[@title='Remove Item'])[4]";
    public String btnRemoveItem2 = "(//a[@title='Remove Item'])[3]";
    public String dpdValue = "//a[@class='rfExp']";
    public String dpdValue1 = "(//a[@class='rmLink'])[20]";
    public String btnApply  = "//input[@class='rfButton']";
    public String containsTxt = "//div[contains(text(),'Account selected should be under same currency format.')]";
    public String btnOKSubmit = "(//input[@type='submit'])[1]";
    public String btnWindowClose = "//img[@id='CloseButtonwinRMPMonitoring']";

    //--Checkbox--//

    public String cbxUSD = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl16_chkSelectedItem']";
    public String cbxNZD = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl21_chkSelectedItem']";


    //**Single Installment PTP for full AUD amount under multi-CCY FCIDN
    //FCIDN Used - 6100520884
    public String txtbxFCIDN = "//input[@id='ctl00_contentPlaceHolder_collectorSearchText']";
    public String btnSearch = "//input[@name='collectorSearchButton']";
    public String rdbtnAccount = "//input[@value='1|8|0|0']";
    public String btnFCIDN = "//a[@onclick='toggle_tab(1); radr_setTab(1);']";
    public String btnPaymentArrangement = "//span[@class='sp-ic_nav sp-ic_nav_schedule']";
    public String frmPaymentArrangement = "//iframe[@class='RadWContentFrame']";
    public String btnAddnewItem = "(//a[@class='Link_menu'])[2]";
    public String btnRemoveItem = "(//a[@title='Remove Item'])[4]";
    public String dpdValueIsNotNull = "(//span[@class='rmText'])[20]";
    public String chkbxValue1 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl18_chkSelectedItem']";
    public String chkbxValue2 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl22_chkSelectedItem']";
    public String btnOK = "(//input[@type='submit'])[1]";
    public String btnExpandAccount1 = "//td[@class='rgExpandCol']";
    public String btnExpandAccount2 = "(//td[@class='rgExpandCol'])[3]";
    public String txtbxAmount = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_txtAmount']";
    public String btnSaveGrid = "//a[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl00_lnkSave']";
    public String btnContinue = "//input[@value='Continue']";
    public String btnSavePayment = "(//input[@type='submit'])[2]";
    public String txtbxDate = "//input[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl03_rdpkStartingOn_dateInput']";
    public String btnSvePayment = "//input[@value='Save']";
    public String btnCalendar = "//a[@title='Open the calendar popup.']";
    public String btnCalendarDate = "//td[@title='Thursday, September 19, 2019']";
    public String wrdPaymentArrangement = "//td[@class='TabBg']";
    public String frmFCIDN  = "//iframe[@id='ctl00_contentPlaceHolder_ifrSingleView']";
    public String frmSave    = "//iframe[@class='RadWContentFrame']";
    public String frmSaveArrangement = "(//iframe[@id='RadWindowContentFramewinRMPMonitoring'])[1]";



    //**Multi Instalment PTP for full NZD amount under multi-CCY FCIDN
    public String dpdlstCollectionStatus2 = "//option[@value='114']";
    public String rdbtnAccount1 = "//input[@value='4|5|0|0']";
    public String frmSearchResults1 = "//frame[@name='searchResultFrame']";
    public String frmFCIDN1 = "//iframe[@id='ctl00_contentPlaceHolder_ifrSingleView']";
    public String btnFCIDN1 = "//a[@onclick='toggle_tab(1); radr_setTab(1);']";
    public String txtCurrency = "//div[@id='divCurrencyOption']";
    public String dpdValueItem = "(//a[@class='rfExp'])[1]";
    public String chkbxValue01 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl16_chkSelectedItem']";
    //public String chkbxValue2 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl07_chkSelectedItem']";
    public String dpdFrequency = "(//span[@class='rddlIcon'])[2]";
    public String dpdFrequencyMonthly = "(//li[@class='rddlItem'])[1]";
    public String txtbxInstallment = "(//input[@class='riTextBox riEnabled InputText'])[1]";
    public String frmAddPaymentArrangement = "(//iframe[@id='RadWindowContentFramewinRMPMonitoring'])[1]";
    public String btnCollapse = "//input[@id='ctl00_contentPlaceHolder_gridAccountPromise_ctl00_ctl04_GECBtnExpandColumn']";





    public String rdbtnAccountVarying = "//input[@value='5|20|0|0']";
    public String chkbxValueVar1 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl30_chkSelectedItem']";
    public String chkbxValueVar2 = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl34_chkSelectedItem']";

    public String btnSaveGrid1 = "//a[@id='ctl00_contentPlaceHolder_gridPromise_ctl00_ctl02_ctl00_lnkSave']";
    public String frmAddPaymentArrangement1 = "(//iframe[@id='RadWindowContentFramewinRMPMonitoring'])[1]";
    public String btnContinue2 = "//input[@value='Continue']";

}
