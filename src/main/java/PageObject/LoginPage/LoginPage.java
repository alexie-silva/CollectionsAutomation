package PageObject.LoginPage;
import Utilities.Action;

public class LoginPage extends Action {

    /* Elements naming convention (e.g btnSubmit, txtbxUsername, rbtnYesAgreement etc)
    --> btn - button
    --> lbl - label
    --> txtbx - textbox
    --> rbtn - radio button
    --> cbx - checkbox
    --> dpd - dropdown
    --> dpdlst - dropdown list
    --> lnk - hyperlink
    --> tb - tabs
    --> tbl - tables
    --> li - lists
    */

//LOGIN TEXT
    public String txtContinue = "//*[@id='overridelink']";
    public String txtbxUsername = "//*[@id='txtUsername']";
    public String txtbxPassword = "//*[@id='txtPassword']";
    public String lblDashboard = "//ul[@class='rmRootGroup rmToggleHandles rmHorizontal']";
    public String frmHeader = "//frame[@name='cwx_header']";
    public String btnLogin = "//*[@id=\"btnLogin\"]";
}
