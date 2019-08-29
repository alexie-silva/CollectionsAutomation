package PageObjectImplementation.CollectionModule;
import PageObject.CollectionPage.CollectionPage;

public class CollectionPageActions extends CollectionPage {

    public void searchAccount() throws InterruptedException {
        click(lnkCollection);

        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmTopFrame);
        Thread.sleep(3000);
        click(dpdlstCollectionStatus);
        waitElementToBeDisplayed(dpdlstCollectionStatusActive, 5);
        click(dpdlstCollectionStatusActive);

        switchDefault();
        Thread.sleep(3000);
        switchFrame(frmContent);
        Thread.sleep(3000);
        switchFrame(frmSearchResults);
        Thread.sleep(3000);

        String parentWinHandle = driver.getWindowHandle(); // Store the current window handle
        click(rbtnFirstAccount);

        for (String handle : driver.getWindowHandles()) // Switch to new window opened
        {
            driver.switchTo().window(handle);
        }
        waitElementToBeDisplayed(btnLHSMenu, 5);
        click(btnLHSMenu);
        click(liPaymentArrangements);

        click(lnkPaymentArrangementsAddNewItem);
        click("//li[contains(text(), 'Total Amount')]");
        /*waitElementToBeDisplayed(lnkPaymentArrangementsAddNewItem, 5);
        click(lnkPaymentArrangementsAddNewItem);*/
        //driver.close(); // Close the new window, if that window no more required
        //driver.switchTo().window(parent); // Switch back to original browser (first window)


    }
}
