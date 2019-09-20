package PaymentArrangement;
import PageObjectImplementation.CollectionModule.CollectionPageActions;
import PageObjectImplementation.LoginModule.LoginPageActions;
import PageObjectImplementation.LoginModule.LoginPageCreditOfficerBrunoActions;
import PageObjectImplementation.LoginModule.LoginPageCreditOfficerSharonActions;
import PageObjectImplementation.LogoutModule.LogoutPageActions;
import Utilities.TestInitialize;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PaymentArrangement_AccountLevelTest extends TestInitialize {
    LoginPageActions login = new LoginPageActions();
    LoginPageCreditOfficerBrunoActions loginBruno = new LoginPageCreditOfficerBrunoActions();
    LoginPageCreditOfficerSharonActions loginSharon = new LoginPageCreditOfficerSharonActions();
    CollectionPageActions collection = new CollectionPageActions();
    LogoutPageActions logout = new LogoutPageActions();

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

    @Test (priority = 1, testName = "User Log in")
    public void TC001_userLoginSuccessfully() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            login.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 2, testName = "User Account Search")
    public void TC002_searchAccount() {
        try {
            System.out.println("ACCOUNT SEARCHED SUCCESSFULLY: STARTED");
            collection.searchAccountActive();
        } catch (Exception e) {
            System.out.println("***ACCOUNT SEARCHED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 3, testName = "Create Disputes")
    public void TC003_createDispute() {
        try {
            System.out.println("DISPUTE CREATED SUCCESSFULLY: STARTED");
            collection.dispute();
        } catch (Exception e) {
            System.out.println("***DISPUTE CREATED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 4, testName = "Create Single Promise-To-Pay")
    public void TC004_createSinglePTP() {
        try {
            System.out.println("PAYMENT ARRANGEMENT CREATED SUCCESSFULLY: STARTED");
            collection.singlePTP();
        } catch (Exception e) {
            System.out.println("***PAYMENT ARRANGEMENT CREATED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 5, testName = "Create Correspondence Letter")
    public void TC005_createCorrespondenceLetter() {
        try {
            System.out.println("CORRESPONDENCE LETTER CREATED SUCCESSFULLY: STARTED");
            collection.correspondenceLetter();
        } catch (Exception e) {
            System.out.println("***CORRESPONDENCE LETTER CREATED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 6, testName = "Create Correspondence Email")
    public void TC006_createCorrespondenceEmail() {
        try {
            System.out.println("CORRESPONDENCE EMAIL CREATED SUCCESSFULLY: STARTED");
            collection.correspondenceEmail();
        } catch (Exception e) {
            System.out.println("***CORRESPONDENCE EMAIL CREATED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 7, testName = "Cancel Payment Arrangement")
    public void TC007_cancelPaymentArrangement() {
        try {
            System.out.println("PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: STARTED");
            collection.cancelPaymentArrangement();
        } catch (Exception e) {
            System.out.println("***PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 8, testName = "Create Multi Installment Promise-To-Pay Full Net Debt")
    public void TC008_createMultiInstallmentPTPfullNetDebt() {
        try {
            System.out.println("PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: STARTED");
            collection.createMultiInstallmentPTPfullNetDebt();
        } catch (Exception e) {
            System.out.println("***PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 9, testName = "Create Multi Installment Promise-To-Pay Partial Net Debt")
    public void TC008_createMultiInstallmentPTPpartialNetDebt() {
        try {
            System.out.println("PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: STARTED");
            collection.createMultiInstallmentPTPpartialNetDebt();
        } catch (Exception e) {
            System.out.println("***PAYMENT ARRANGEMENT CANCELLED SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 9, testName = "User Logout")
    public void TC009_userLogoutSuccessfully () {
        try {
            System.out.println("USER LOGOUT SUCCESSFULLY: STARTED");
            logout.logoutToCollections();
        } catch (Exception e) {
            System.out.println("***USER LOGOUT SUCCESSFULLY: FAILED!");
        }
    }

    @Test(priority = 10, testName = "User Logout")
    public void TC010_userLoginSuccessfully() {
        try{
            System.out.println("USER LOGIN SUCCESSFULLY: STARTED");
            loginSharon.successfulLogin();
        }catch (Exception e){
            System.out.println("***USER LOGIN SUCCESSFULLY: FAILED!");
        }
    }

    @AfterClass
    public void endTest () {
        //driver.manage().deleteAllCookies();
    }
}
