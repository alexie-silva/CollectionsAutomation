package PageObject.MultiPTPsPage;
import Utilities.Action;

public class CustomerLevelPage extends Action {

    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String dpdlstCollectionStatus = "//option[@value='119']";
    public String dpdlstCollectionStatusActive = "//option[@value='5']";
    public String rbtnThirdAccount = ("//input[@value='7|27|0|0']");
    public String btnLHSMenu = "//img[@src='/CWX_RADR_AT/App_Themes/Flat/images/icon_menu.png']";
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


    //--Checkbox--//

    public String cbxUSD = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl33_chkSelectedItem']";
    public String cbxNZD = "//input[@id='ctl00_contentPlaceHolder_accountSearch_grvCustomerAccount_ctl00_ctl28_chkSelectedItem']";



}
