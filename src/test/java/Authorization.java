import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Authorization {
    WebDriver driver = new ChromeDriver();
    Data getData = new Data();


    private By btnLogIn = By.xpath("//div[@class='r1yVH']//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnAuthorizationLogIn = By.xpath("//div[@class='form-group']//input[@class='btn btn-default btn-block-level']");
    private By getErrorText = By.xpath("//div[@class='flash flash--alert animated js-flash js-flash-alert']//div[@class='row']//div[@class='col-xs-10 col-sm-6 center-block flash__message']");



    @Test
    public void authorization(){

        driver.get(getData.getURL);
        driver.findElement(btnLogIn).click();
        driver.findElement(inputEmail).sendKeys(getData.email);
        driver.findElement(inputPassword).sendKeys(getData.password);
        driver.findElement(btnAuthorizationLogIn).click();
        driver.quit();
    }

    @Test
    public void negativeAuthorization(){

        driver.get(getData.getURL);
        driver.findElement(btnLogIn).click();
        driver.findElement(inputEmail).sendKeys(getData.wrongEmail);
        driver.findElement(inputPassword).sendKeys(getData.password);
        driver.findElement(btnAuthorizationLogIn).click();

        String getError = driver.findElement(getErrorText).getText();
        Assert.assertEquals("Invalid email or password.",getError);
        driver.quit();
    }

}
