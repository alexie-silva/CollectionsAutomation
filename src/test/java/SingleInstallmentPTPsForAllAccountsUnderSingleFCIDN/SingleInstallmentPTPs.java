package SingleInstallmentPTPsForAllAccountsUnderSingleFCIDN;
import PageObjectImplementation.LoginModule.LoginPageActions;
import PageObjectImplementation.LoginModule.LoginPageCreditOfficerBrunoActions;
import PageObjectImplementation.LogoutModule.LogoutPageActions;
import PageObjectImplementation.SingleInstallmentPTPsModule.SingleInstallmentPTPsAction;
import Utilities.TestInitialize;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SingleInstallmentPTPs extends TestInitialize {

    LoginPageCreditOfficerBrunoActions loginBruno = new LoginPageCreditOfficerBrunoActions();
    LoginPageActions login = new LoginPageActions();
    LogoutPageActions logout = new LogoutPageActions();
    SingleInstallmentPTPsAction ptpSingleInstallment = new SingleInstallmentPTPsAction();


    @BeforeClass
    public void reportConfiguration() {
        try{
            //UPDATE "suiteName" FOR EACH TEST SUITE
            String suiteName = "DSS-AUTOMATION";
            test = extent.createTest(suiteName);
            System.out.println("REPORT CONFIGURATION: PASSED");
        }catch (Exception e){
            System.out.println("***FAILED TO CONFIGURE REPORT");
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Test(priority = 1, testName = "User Login")
    public void TC001_userLoginSuccessfully() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            loginBruno.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");

        }
    }

    @Test(priority = 2, testName = "Single Installment PTP")
    public void TC002_SingleInstallmentPtpTest() {
        try{
            System.out.println("Single Installment PTP");
            ptpSingleInstallment.ptpSingleIntallmentCreation();
        }catch (Exception e){
            System.out.println("***USER CANNOT SEARCH ACCOUNT: FAILED!");

        }
    }

    @Test(priority = 3, testName = "User Login")
    public void TC003_managerLogin() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            login.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");

        }
    }

    @Test(priority = 4, testName = "Cancel Customer Level PTP")
    public void TC004_CancelCustLevelPTP() {
        try {
            System.out.println("Cancel Customer Level PTP");
            ptpSingleInstallment.cancelPTP();
        }catch (Exception e){
            System.out.println("User cannot cancel PTP");
        }
    }






  /*  @Test (priority = 3, testName = "User Logout")
    public void TC003_userLogoutSuccessfully() {
        try{
            System.out.println("USER LOGOUT SUCCESSFULLY: STARTED");
            logout.logoutToCollections();
        }catch (Exception e){
            System.out.println("***USER LOGOUT SUCCESSFULLY: FAILED!");
        }
    } */

    @AfterClass
    public void endTest() {
        driver.manage().deleteAllCookies();
    }
//End Class
}


