package Utilities;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Action {
    public static WebDriver driver;
    public static String currentUser;
    public static Boolean isWA = false;
    File currentDirectory = new File(new File("").getAbsolutePath());
    Random rand = new Random();
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    Workbook workbook = initExcel(readXml("dataFilename"));
    WebDriverWait wait;
// -------- SELECT BROWSER -------- //
    public void openBrowser(String browser) {
        try {
            String lowerBrowser = browser.toLowerCase();
            if (lowerBrowser.contains("chrome")) {
                System.setProperty("webdriver.chrome.driver", currentDirectory.toString().concat("\\drivers\\chromedriver_76.exe"));
                System.setProperty("webdriver.chrome.args", "--disable-logging");
                System.setProperty("webdriver.chrome.silentOutput", "true");
                driver = new ChromeDriver(); }
            if (lowerBrowser.contains("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDirectory.toString().concat("\\drivers\\geckodriver.exe"));
                driver = new FirefoxDriver(); }
            if(lowerBrowser.contains("ie")){
                File ieFile = new File(currentDirectory.toString().concat("\\drivers\\IEDriverServer32bit.exe"));
                System.setProperty("webdriver.ie.driver", ieFile.getAbsolutePath());
                DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
                ieCaps.setCapability("nativeEvents", false);
                ieCaps.setCapability("unexpectedAlertBehaviour", "accept");
                ieCaps.setCapability("ignoreProtectedModeSettings", true);
                ieCaps.setCapability("disable-popup-blocking", true);
                ieCaps.setCapability("enablePersistentHover", true);
                ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "google.com");
                driver = new InternetExplorerDriver(); }
                System.out.println("-->ACTION: " + browser.toUpperCase() + " BROWSER IS OPENED");
        } catch (Exception e) {
            System.out.println("***FAILED TO OPEN " + browser + " BROWSER");
            System.exit(1); }
    }
// -------- BROWSER ACTIONS -------- //
    public void navigateURL(String URL){
        driver.navigate().to(URL);
        System.out.println("-->ACTION: NAVIGATED TO " + URL);
    }
// -------- Maximize Window Browser -------- //
    public void maximizeBrowser(){
        try{
            driver.manage().window().maximize();
            System.out.println("-->ACTION: BROWSER IS MAXIMIZED");
        } catch (Exception e) {
            System.out.println("***FAILED TO MAXIMIZE BROWSER");
            System.exit(1); }
    }
// -------- CLICK USING XPATH-------- //
    public void click(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).click();
            System.out.println("-->ACTION: XPATH " + xpath + " IS CLICKED");
        } catch (Exception e) {
            System.out.println("***FAILED TO CLICK XPATH " + xpath);
            System.exit(1); }
    }
// -------- CLICK with option to select element locator -------- //
    public void click(String locator, String path){
        locator = locator.toLowerCase();
        try{
            switch (locator){
                case "xpath":
                    driver.findElement(By.xpath(path)).click();
                    break;
                case "css":
                    driver.findElement(By.cssSelector(path)).click();
                    break;
                case "classname":
                    driver.findElement(By.className(path)).click();
                    break;
                case "name":
                    driver.findElement(By.name(path)).click();
                    break;
                case "id":
                    driver.findElement(By.id(path)).click();
                    break;
                case "linktext":
                    driver.findElement(By.linkText(path)).click();
                    break; }
            System.out.println("-->ACTION: " + locator.toUpperCase() + " " + path.toUpperCase() + " IS CLICKED");
        } catch (Exception e) {
            System.out.println("***FAILED TO CLICK " + locator + " " + path);
            System.exit(1); }
    }
// -------- DOUBLE CLICK USING WEBELEMENT -------- //
    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        try{
            actions.doubleClick(element).build().perform();
            System.out.println("-->ACTION: ELEMENT " + element + " is DOUBLE CLICKED");
        } catch (Exception e) {
            System.out.println("***FAILED TO DOUBLE CLICK ELEMENT " + element);
            System.exit(1); }
    }
// -------- DOUBLE CLICK USING XPATH -------- //
    public void doubleClick(String xpath){
        Actions actions = new Actions(driver);
        try{
            actions.doubleClick(driver.findElement(By.xpath(xpath))).build().perform();
            System.out.println("-->ACTION: XPATH " + xpath.toUpperCase() + " is DOUBLE CLICKED");
        } catch (Exception e) {
            System.out.println("***FAILED TO DOUBLE CLICK XPATH" + xpath);
            System.exit(1); }
    }
// -------- DOUBLE CLICK with option to select element locator -------- //
    public void doubleClick(String locator, String path){
        Actions actions = new Actions(driver);
        try{
            switch (locator){
                case "xpath":
                    actions.doubleClick(driver.findElement(By.xpath(path))).perform();
                    break;
                case "css":
                    actions.doubleClick(driver.findElement(By.cssSelector(path))).perform();
                    break;
                case "className":
                    actions.doubleClick(driver.findElement(By.className(path))).perform();
                    break;
                case "name":
                    actions.doubleClick(driver.findElement(By.name(path))).perform();
                    break;
                case "id":
                    actions.doubleClick(driver.findElement(By.id(path))).perform();
                    break;
                case "linkText":
                    actions.doubleClick(driver.findElement(By.linkText(path))).perform();
                    break; }
            System.out.println("-->ACTION: " + locator.toUpperCase() + " " + path.toUpperCase() + " IS DOUBLE CLICKED");
        } catch (Exception e) {
            System.out.println("***FAILED TO DOUBLE CLICK " + locator + " " + path);
            System.exit(1); }
    }
// -------- TYPE TEXT VIA XPATH-------- //
    public void type(String xpath, String text){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(text);
            System.out.println("-->ACTION: TEXT " + text + " IS TYPED ON XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO TYPE " + text + " ON ELEMENT " + xpath );
            System.exit(1); }
    }
    // -------- TYPE TEXT VIA XPATH WITH CLEAR OPTION-------- //
    public void type(String xpath, String text, Boolean isClearText){
        try{
            if(isClearText) {
                driver.findElement(By.xpath(xpath)).clear();
                driver.findElement(By.xpath(xpath)).sendKeys(Keys.BACK_SPACE); }
            driver.findElement(By.xpath(xpath)).sendKeys(text);
            System.out.println("-->ACTION: FIELD IS CLEARED AND TEXT " + text + " IS TYPED ON XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO CLEAR FIELD AND TYPE " + text + " ON ELEMENT " + xpath );
            System.exit(1); }
    }
// -------- TYPE TEXT with option to select element locator -------- //
    public void type(String locator, String path, String text){
        WebElement element;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            switch (locator){
                case "xpath":
                    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
                    element.sendKeys(text);
                    break;
                case "css":
                    driver.findElement(By.cssSelector(path)).sendKeys(text);
                    break;
                case "className":
                    driver.findElement(By.className(path)).sendKeys(text);
                    break;
                case "name":
                    driver.findElement(By.name(path)).sendKeys(text);
                    break;
                case "id":
                    driver.findElement(By.id(path)).sendKeys(text);
                    break;
                case "linkText":
                    driver.findElement(By.linkText(path)).sendKeys(text);
                    break; }
            System.out.println("-->ACTION: TEXT " + text + " IS TYPED ON " + locator.toUpperCase() + " " + path.toUpperCase());
        } catch (Exception e) {
            System.out.println("***FAILED TO TYPE " + text + " ON " + locator.toUpperCase() + " " + path.toUpperCase() );
            System.exit(1); }
    }
// -------- VERIFY IF ELEMENT IS DISPLAY (WILL RETURN TRUE OR FALSE) -------- //
    public boolean isElementDisplayed(String xpath){
        if(driver.findElements(By.xpath(xpath)).size() != 0){
            System.out.println("-->ACTION: ELEMENT " + xpath.toUpperCase() + " IS DISPLAYED");
            return true;
        } else{
            System.out.println("-->ACTION: ELEMENT " + xpath.toUpperCase() + " IS NOT DISPLAYED");
            return false; }
    }
// -------- VERIFY IF ELEMENT IS ENABLED (WILL RETURN TRUE OR FALSE) -------- //
    public boolean isElementEnabled(String xpath){
        if(driver.findElement(By.xpath(xpath)).isEnabled()){
            System.out.println("-->ACTION: ELEMENT " + xpath.toUpperCase() + " IS ENABLED");
            return true;
        } else{
            System.out.println("-->ACTION: ELEMENT " + xpath.toUpperCase() + " IS NOT ENABLED");
            return false; }
    }
// -------- VERIFY IF TEXT CONTAINS TEXT (WILL RETURN TRUE OR FALSE) -------- //
    public boolean isContainText(String xpath, String text){
        String xpathText = driver.findElement(By.xpath(xpath)).getText();
        if(xpathText.contains(text)){
            System.out.println("-->ACTION: XPATH TEXT " + xpathText + " CONTAINS text " + text);
            return true;
        } else{
            System.out.println("-->ACTION: XPATH TEXT " + xpathText + " DOES NOT CONTAINS text " + text);
            return false; }
    }
// -------- VERIFY IF TEXT IS AVAILABLE IN PAGE (WILL RETURN TRUE OR FALSE) -------- //
    public boolean checkTextPresent(String text){
        if(driver.getPageSource().contains(text)){
            System.out.println("-->ACTION: TEXT " + text + " IS PRESENT ON CURRENT PAGE");
            return true;
        } else{
            System.out.println("-->ACTION: TEXT " + text + " IS NOT PRESENT ON CURRENT PAGE");
            return false;
        }
    }
// -------- GET STRING VALUE VIA LOCATOR -------- //
    public String getStringValue(String locator, String path){
        String value = null;
        switch (locator){
            case "xpath": value = driver.findElement(By.xpath(path)).getText();
                break;
            case "css":
                value = driver.findElement(By.cssSelector(path)).getText();
                break;
            case "className":
                value = driver.findElement(By.className(path)).getText();
                break;
            case "name":
                value = driver.findElement(By.name(path)).getText();
                break;
            case "id":
                value = driver.findElement(By.id(path)).getText();
                break;
            case "linkText":
                value = driver.findElement(By.linkText(path)).getText();
                break;
            default:
                System.out.println("***FAILED TO RETURN ANY VALUE FROM LOCATOR " + locator.toUpperCase() + " AND PATH " + path.toUpperCase());
                return null; }
        System.out.println("-->ACTION: VALUE " + value + " WAS GENERATED FROM LOCATOR " + locator.toUpperCase() + " AND PATH " + path.toUpperCase());
        return value;
    }
// -------- GET VALUE FROM XPATH -------- //
    public String getValue(String xpath){
        String value = null;
        value = driver.findElement(By.xpath(xpath)).getAttribute("value");
        if(value == null || value.isEmpty()){
            System.out.println("***FAILED TO RETURN ANY VALUE FROM XPATH " + xpath.toUpperCase());
            return null;
        } else {
            System.out.println("-->ACTION: VALUE " + value + " WAS GENERATED FROM XPATH " + xpath.toUpperCase());
            return value; }
    }
// -------- GET TEXT FROM XPATH-------- //
    public String getText(String xpath){
        String text = driver.findElement(By.xpath(xpath)).getText();
        if(text == null || text.isEmpty()){
            System.out.println("***FAILED TO RETURN ANY TEXT FROM XPATH " + xpath.toUpperCase());
            return null;
        } else{
            System.out.println("-->ACTION: TEXT " + text + " WAS GENERATED FROM XPATH " + xpath.toUpperCase());
            return text; }
    }
// -------- WAIT FOR SPECIFIC SEC WHILE PAGE IS LOADING -------- //
    public void waitFor(int sec) {
        driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
// -------- WAIT WHILE ELEMENT IS DISPLAYED USING SPECIFIED SEC -------- //
    public void waitWhileElementIsDisplayed(String xpath, int Sec) throws InterruptedException {
        int counter = 0;
        do{
            Thread.sleep(1000);
            counter++;
        }while(driver.findElement(By.xpath(xpath)).isDisplayed() || counter != Sec);
    }
// -------- WAIT FOR ELEMENT TO BE DISPLAYED USING SPECIFIED SEC -------- //
    public void waitElementToBeDisplayed(String xpath, int Sec) throws InterruptedException {
       int counter = 0;
            do{
                Thread.sleep(1000);
                counter++;
            }while(!driver.findElement(By.xpath(xpath)).isDisplayed() || counter != Sec);
    }
// -------- WAIT FOR ELEMENT TO BE ENABLED USING SPECIFIED SEC -------- //
    public void waitElementToBeEnabled(String xpath, int Sec) throws InterruptedException {
        wait = new WebDriverWait(driver, Sec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Thread.sleep(1000);
    }
// -------- WAIT FOR TEXT TO BE PRESENT USING SPECIFIED LOCATOR AND SEC -------- //
    public void waitForTextToBePresent(String locator, String path, String text, int Sec) throws InterruptedException {
        wait = new WebDriverWait(driver, Sec);
        switch (locator){
            case "xpath":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(path), text));
                break;
            case "css":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(path), text));
                break;
            case "className":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className(path), text));
                break;
            case "name":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.name(path), text));
                break;
            case "id":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(path), text));
                break;
            case "linkText":
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.linkText(path), text));
                break; }
        Thread.sleep(1000);
    }
// -------- WAIT FOR TEXT TO BE EQUAL using xpath and specific SEC -------- //
    public void waitTextToBeEqual(String xpath, String expected, int Sec) throws InterruptedException {
        String actualText = getText(xpath);
        int counter = 0;
        do{
            Thread.sleep(1000);
            counter++;
        }while(!actualText.equals(expected) || counter != Sec);
    }
// -------- INITIALIZE EXCEL TO RETURN WORKBOOK -------- //
    public Workbook initExcel(String fileName){
        Workbook workbook = null;
        try{
            File file = new File("excelFiles/" + fileName);
            FileInputStream inputStream = new FileInputStream(file);
            workbook = WorkbookFactory.create(inputStream);
            System.out.println("-->ACTION: Workbook " + workbook.toString() + " WAS GENERATED FROM EXCEL " + fileName);
        }catch (InvalidFormatException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET DATA ON " + fileName + ". (The data source is not a valid MS Excel File!)");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET DATA ON " + fileName + ". (The data source does not exist!)"); }
        return workbook;
    }
// -------- GET DATA FROM EXCEL SHEET WITH SPECIFIC FILENAME -------- //
    public String readExcel(String fileName, String sheetName, int col, int row) {
        String value = null;
        try{
            File file = new File("excelFiles/".concat(fileName));
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();
            value = formatter.formatCellValue(sheet.getRow(row).getCell(col));
            System.out.println("-->ACTION: VALUE " + value + " WAS GENERATED FROM EXCEL " + fileName);
        }catch (InvalidFormatException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET DATA ON " + fileName + ". (The data source is not a valid MS Excel File!)");
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET DATA ON " + fileName + ". (The data source does not exist!)"); }
        return value;
    }
// -------- GET XML VALUE FROM CONFIG USING KEY -------- //
    public String readXml(String key) {
        String value = null;
        try {
            File file = new File(currentDirectory.toString().concat("\\config.xml"));
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.loadFromXML(fileInput);
            fileInput.close();
            @SuppressWarnings("rawtypes")
            Enumeration enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                if (((String) enuKeys.nextElement()).contains(key)) {
                    value = properties.getProperty(key); }
            } System.out.println("-->ACTION: VALUE " + value + " WAS GENERATED FROM CONFIG.XML FILE KEY " + key);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET VALUE FROM OF " + key + " FROM CONFIG.XML. (The data source is not a valid MS Excel File!)");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET VALUE FROM OF " + key + " FROM CONFIG.XML. (The data source does not exist!)"); }
        return value;
    }
// -------- WRITE A VALUE TO CONFIG.XML -------- //
    public void writeXml(String key, String value) {
        try {
            File file = new File(currentDirectory.toString().concat("\\config.xml"));
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            NodeList entry = doc.getElementsByTagName("entry");
            for(int i = 0;i<entry.getLength();i++){
                Node childEntry = entry.item(i);
                NamedNodeMap nnmEntry = childEntry.getAttributes();
                Node nodeAttr = nnmEntry.getNamedItem("key");
                if(nodeAttr.getTextContent().equals(key)){
                    childEntry.setTextContent(value); }
            } TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "SYSTEM");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "http://java.sun.com/dtd/properties.dtd");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            System.out.println("-->ACTION: WRITING OF XML HAS BEEN COMPLETED");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET VALUE FROM OF " + key + " FROM CONFIG.XML. (The data source is not a valid MS Excel File!)");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("***FAILED TO GET VALUE FROM OF " + key + " FROM CONFIG.XML. (The data source does not exist!)"); }
    }
// -------- SETTING OF CURRENT USER -------- //
    public void setUser(String user){
        currentUser = user;
    }
// -------- SENDING OF EMAIL REPORT CONFIGURATION-------- //
    public void sendTestReport() {
        System.out.println("-->ACTION: SENDING OF REPORT IN PROGRESS");
        final String emailSMTPserver = "smtp.gmail.com";
        final String emailServerPort = "465";
        final String senderEmailID = readXml("senderEmailID");
        final String emailSubject = readXml("emailSubject") + " - ";
        final String reportFileName = readXml("reportFilename");
        final String reportPath = readXml("reportPath");
        final String receiverEmailID = readXml("receiverEmailIDCommaSeparated");
        String emailBody = "***DO NOT REPLY - This is a automatically generated email*** \r\n \r\n Please see attached file for the Test Automation Result";
        Properties props = new Properties();
        props.put("mail.smtp.host", emailSMTPserver);
        props.put("mail.smtp.user", senderEmailID);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", emailServerPort);
        props.put("mail.debug", "false");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.EnableSSL.enable", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        try {
            String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(emailSubject.concat(timeStamp));
            msg.setFrom(new InternetAddress(senderEmailID));
            String[] recipientList = receiverEmailID.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++; }
            msg.setRecipients(Message.RecipientType.TO, recipientAddress);
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setText(emailBody);
            FileDataSource source = new FileDataSource(currentDirectory.toString().concat(reportPath).concat(reportFileName));
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(reportFileName);
            // Create Multipart E-Mail.
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("-->ACTION: SENDING OF EMAIL REPORT IS SUCCESSFUL");
        } catch (Exception mex) {
            System.out.println("***FAILED TO SEND EMAIL REPORT");
            mex.printStackTrace(); }
    }
// -------- SET SMTP AUTHENTICATOR -------- //
    public class SMTPAuthenticator extends javax.mail.Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            final String senderEmailID = readXml("senderEmailID");
            final String senderPassword = readXml("senderPassword");
            return new PasswordAuthentication(senderEmailID, senderPassword); }
    }
// -------- GENERATE RANDOM NUMBER -------- //
    public int randomNumber(int num){
        int random = rand.nextInt(num);
        random = random + 1;
        System.out.println("-->ACTION: GENERATION OF RANDOM NUMBER IS SUCCESSFUL");
        return random;
    }
// -------- KEY PRESS UP -------- //
    public void keyUp(){
        new Actions(driver).sendKeys(Keys.ARROW_UP).build().perform();
        System.out.println("-->ACTION: UP KEY IS PRESSED");
    }
// -------- KEY PRESS DOWN -------- //
    public void keyDown(){
        new Actions(driver).sendKeys(Keys.ARROW_DOWN).build().perform();
        System.out.println("-->ACTION: DOWN KEY IS PRESSED");
    }
// -------- KEY PRESS LEFT -------- //
    public void keyLeft(){
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).build().perform();
        System.out.println("-->ACTION: LEFT KEY IS PRESSED");
    }
// -------- KEY PRESS RIGHT -------- //
    public void keyRight(){
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).build().perform();
        System.out.println("-->ACTION: RIGHT KEY IS PRESSED");
    }
// -------- KEY PRESS TAB -------- //
    public void keyTab(){
        new Actions(driver).sendKeys(Keys.TAB).build().perform();
        System.out.println("-->ACTION: TAB KEY IS PRESSED");
    }
// -------- KEY PRESS ESC -------- //
    public void keyEscape(){
        new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
        System.out.println("-->ACTION: ESCAPE KEY IS PRESSED");
    }
// -------- KEY PRESS ENTER -------- //
    public void keyEnter(){
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
        System.out.println("-->ACTION: ENTER KEY IS PRESSED");
    }
// -------- KEY PRESS UP WITH XPATH -------- //
    public void keyUp(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_UP);
            System.out.println("-->ACTION: UP KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS UP KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS DOWN WITH XPATH -------- //
    public void keyDown(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_DOWN);
            System.out.println("-->ACTION: DOWN KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS DOWN KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS LEFT WITH XPATH -------- //
    public void keyLeft(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_LEFT);
            System.out.println("-->ACTION: LEFT KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS LEFT KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS RIGHT WITH XPATH -------- //
    public void keyRight(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ARROW_RIGHT);
            System.out.println("-->ACTION: RIGHT KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS RIGHT KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS TAB WITH XPATH -------- //
    public void keyTab(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.TAB);
            System.out.println("-->ACTION: TAB KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS TAB KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS ESCAPE WITH XPATH-------- //
    public void keyEscape(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ESCAPE);
            System.out.println("-->ACTION: ESCAPE KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS ESCAPE KEY for XPATH " + xpath); }
    }
// -------- KEY PRESS ENTER WITH XPATH -------- //
    public void keyEnter(String xpath){
        try{
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
            System.out.println("-->ACTION: ENTER KEY IS PRESSED FOR XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO PRESS ENTER KEY for XPATH " + xpath); }
    }
// -------- VERIFY IF XPATH IS SELECTED -------- //
    public Boolean isSelected(String xpath){
        if(driver.findElement(By.xpath(xpath)).isSelected()){
            System.out.println("-->ACTION: XPATH " + xpath + " IS SELECTED");
            return true;
        } else {
            System.out.println("-->ACTION: XPATH " + xpath + " IS NOT SELECTED");
            return false; }
    }
// -------- SELECT FROM DROPDOWN -------- //
    public void selectFromDropdowByText(String xpath, String text){
        try{
            Select dpd = new Select(driver.findElement(By.xpath(xpath)));
            dpd.selectByVisibleText(text);
            System.out.println("-->ACTION: " + text + " IS SELECTED FROM DROPDOWN XPATH " + xpath);
        } catch (Exception e) {
            System.out.println("***FAILED TO SELECT " + text + " FROM DROPDOWN XPATH " + xpath );
            System.exit(1); }
    }
// -------- SWITCH TO OTHER FRAME -------- //
    public void switchWindow(String frame){
        driver.switchTo().frame(driver.findElement(By.xpath(frame)));
        System.out.println("-->ACTION: SWITCH TO FRAME " + frame + " IS SUCCESSFUL");
    }
// -------- GENERATE CURRENT DATE -------- //
    public String getCurrentDate(String format){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("-->ACTION: CURRENT DATE " + dtf.format(now) + " IS GENERATED");
        return dtf.format(now);
    }
// -------- SET FOCUS TO XPATH (MOSTLY USED IN IE TESTING) -------- //
    public void sendEmptyKey(String xpath) {
        driver.findElement(By.xpath(xpath)).sendKeys("");
        System.out.println("-->ACTION: FOCUS IS SET TO XPATH " + xpath);
    }
// -------- JAVASCRIPT TYPE TEXT WITH CLEAR FIELDS -------- //
    public void jsType(String xpath, String text, Boolean isClearText){
        try{
            if(isClearText) {
                executor.executeScript("arguments[0].value='';", driver.findElement(By.xpath(xpath)));
            } executor.executeScript("arguments[0].value='"+text+"';", driver.findElement(By.xpath(xpath)));
            System.out.println("-->ACTION: FIELD IS CLEARED AND TEXT " + text + " IS TYPED ON XPATH " + xpath + " (JS)");
        } catch (Exception e) {
            System.out.println("***FAILED TO TYPE " + text + " ON ELEMENT " + xpath + " (JS)");
            System.exit(1); }
    }
// -------- JAVASCRIPT TYPE TEXT -------- //
    public void jsType(String xpath, String text){
        try{
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].value='"+text+"';", driver.findElement(By.xpath(xpath)));
            System.out.println("-->ACTION: FIELD IS CLEARED AND TEXT " + text + " IS TYPED ON XPATH " + xpath + " (JS)");
        } catch (Exception e) {
            System.out.println("***FAILED TO TYPE " + text + " ON ELEMENT " + xpath + " (JS)");
            System.exit(1); }
    }
// -------- JAVASCRIPT CLICK XPATH -------- //
    public void jsClick(String xpath) {
        try {
            executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(xpath)));
            System.out.println("-->ACTION: XPATH " + xpath + " IS CLICKED (JS)");
        } catch (Exception e) {
            System.out.println("***FAILED TO CLICK XPATH " + xpath + " (JS)");
            System.exit(1);
        }
    }
// -------- JAVASCRIPT GET TEXT VALUE -------- //
    public String jsGetTextValue(String xpath){
        String text = (String)(executor.executeScript("return arguments[0].value;", driver.findElement(By.xpath(xpath))));
        if(text == null || text.isEmpty()){
            System.out.println("***FAILED TO RETURN ANY TEXT VALUE FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return null;
        } else{
            System.out.println("-->ACTION: TEXT VALUE" + text + " WAS GENERATED FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return text; }
    }
// -------- JAVASCRIPT GET TEXT CONTENT -------- //
    public String jsGetTextContent(String xpath){
        String text = (String)(executor.executeScript("return arguments[0].innerHTML;", driver.findElement(By.xpath(xpath))));
        if(text == null || text.isEmpty()){
            System.out.println("***FAILED TO RETURN ANY TEXT CONTENT FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return null;
        } else{
            System.out.println("-->ACTION: TEXT CONTENT" + text + " WAS GENERATED FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return text; }
    }
// -------- JAVASCRIPT GET TEXT CLASS -------- //
    public String jsGetTextClass(String xpath){
        String text = (String)(executor.executeScript("return arguments[0].class;", driver.findElement(By.xpath(xpath))));
        if(text == null || text.isEmpty()){
            System.out.println("***FAILED TO RETURN ANY TEXT CLASS FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return null;
        } else{
            System.out.println("-->ACTION: TEXT CLASS" + text + " WAS GENERATED FROM XPATH " + xpath.toUpperCase() + " (JS)");
            return text; }
    }
// -------- JAVASCRIPT TYPE TEXT CONTENT -------- //
    public boolean isJSContainText(String xpath, String text){
        String strValue = (String)(executor.executeScript("return arguments[0].text;", driver.findElement(By.xpath(xpath))));
        if(strValue.contains(text)){
            System.out.println("-->ACTION: XPATH TEXT " + xpath + " CONTAINS text " + text + " (JS)");
            return true;
        } else{
            System.out.println("-->ACTION: XPATH TEXT " + xpath + " DOES NOT CONTAINS text " + text + " (JS)");
            return false; }
    }

    // ------- SWITCH ------- //

    public void switchFrame(String xpath){
        try {
            driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
        }
        catch (Exception e){
            System.out.println("Frame " + xpath + " not found upon switching");
        }
    }
//------------------------------------------------------ END CLASS ------------------------------------------------------//
}