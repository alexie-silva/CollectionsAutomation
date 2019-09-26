package PageObjectImplementation.LogoutModule;
import PageObject.LogoutPage.LogoutPage;
import org.junit.Assert;

public class LogoutPageActions extends LogoutPage {

    public void logoutToCollections() throws InterruptedException {
        Thread.sleep(2000);
        String parent = driver.getWindowHandle();
        for (String child : driver.getWindowHandles()) // Switch to new window opened
        {
            if (!child.equals(parent)) {
                switchDefault();
                Thread.sleep(1000);
                waitElementToBeEnabled(btnCancel, 3);
                click(btnCancel);
                driver.switchTo().window(child);
            }
        }
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
