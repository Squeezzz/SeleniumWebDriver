import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfileEdit {
    WebDriver driver = new ChromeDriver();
    Data getData = new Data();
    WebDriverWait waiting = new WebDriverWait(driver, Duration.ofMillis(500));

    private By btnLogIn = By.xpath("//div[@class='r1yVH']//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnAuthorizationLogIn = By.xpath("//div[@class='form-group']//input[@class='btn btn-default btn-block-level']");
    private By btnProfilePicture = By.xpath("//div[@class='TkpKu']//button[@class='ptze8 jpBZ0 uOpQU']");
    private By btnAccountSettings = By.xpath("//ul[@class='O6hdO ruKGA oh0KJ']//a[@class='KR60y VVTRX WP6Ak eziW_ svE7J IquXd']");
    private By btnEditProfile = By.xpath("//div[@class='AW1O4']//a[@class='Z1oo6 CwMIr DQBsa p1cWU jpBZ0 EzsBC KHq0c Olora I0aPD dEcXu']");
    private By inputEditFirstName = By.xpath("//div[@class='form-group']//input[@class='form-control']");
    private By btnUpdateAccount = By.xpath("//div[@class='form-group']//input[@class='btn btn-default btn-block-level']");
    private By getAccountUpdatedText = By.xpath("//div[@class='row']//div[@class='col-xs-10 col-sm-6 center-block flash__message']");

    @Test
    public void profileEdit(){
        driver.get(getData.getURL);
        driver.findElement(btnLogIn).click();
        driver.findElement(inputEmail).sendKeys(getData.email);
        driver.findElement(inputPassword).sendKeys(getData.password);
        driver.findElement(btnAuthorizationLogIn).click();
        driver.findElement(btnProfilePicture).click();
        driver.findElement(btnAccountSettings).click();
        waiting.until(ExpectedConditions.elementToBeClickable(btnEditProfile));
        driver.findElement(btnEditProfile).click();
        driver.findElement(inputEditFirstName).clear();
        driver.findElement(inputEditFirstName).sendKeys(getData.editedFirstName);
        driver.findElement(btnUpdateAccount).click();
        String getTextVisualSearch = driver.findElement(getAccountUpdatedText).getText();
        Assert.assertEquals("Account updated!",getTextVisualSearch);
        driver.quit();
    }
}
