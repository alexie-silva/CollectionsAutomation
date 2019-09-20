package PageObjectImplementation.LogoutModule;
import PageObject.LogoutPage.LogoutPage;
import org.junit.Assert;
import java.io.IOException;

public class LogoutPageActions extends LogoutPage {

    public void logoutToCollections() throws IOException, InterruptedException {

        switchFrame(frmHeader);
        click(lnkLogout);
        Thread.sleep(2000);
        try {
            Assert.assertTrue(isElementDisplayed(lblLogoutVerification));
            System.out.println("USER LOGOUT ACTION PAGE: PASSED");
        }catch (Exception e){
            System.out.println("***USER LOGOUT ACTION PAGE: FAILED");
        }
    }
    //END OF TEST//
}
