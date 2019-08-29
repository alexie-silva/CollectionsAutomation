package PageObject.CollectionPage;
import Utilities.Action;

public class CustomerLevelPage extends Action {

    public String lnkCollection = "(//div[@class='MenuItemMiddle'])[1]";
    public String dpdlstCollectionStatus = "//option[@value='119']";
    public String dpdlstCollectionStatusActive = "//option[@value='5']";
    public String rbtnFirstAccount = "(//input[@name='rdEmpID'])[1]";
    public String btnLHSMenu = "//img[@src='/CWX_RADR_AT/App_Themes/Flat/images/icon_menu.png']";
    public String frmHeader = "//frame[@name='cwx_header']";
    public String frmContent = "//frame[@name='cwx_content']";
    public String frmTopFrame = "//frame[@name='searchTopFrame']";
    public String frmMidFrame = "//frameset[@name='midFrame']";
    public String frmRightFrame = "//frame[@id='rightFrame']";
    public String frmLeftFrame = "//div[@class='LeftFrame']";

}
