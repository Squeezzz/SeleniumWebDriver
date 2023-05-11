import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
    WebDriver driver = new ChromeDriver();
    Data getData = new Data();

    private By btnLogIn = By.xpath("//div[@class='r1yVH']//a[@class='cLLOA p1cWU jpBZ0 EzsBC KHq0c XHI2L']");
    private By btnJoinUnsplash = By.linkText("Join Unsplash");
    private By inputFirstName = By.xpath("//div[@class='form-group']//input[@id='user_first_name']");
    private By inputLastName = By.xpath("//div[@class='form-group']//input[@id='user_last_name']");
    private By inputEmail = By.xpath("//div[@class='form-group']//input[@id='user_email']");
    private By inputUsername = By.xpath("//div[@class='form-group']//input[@id='user_username']");
    private By inputPassword = By.xpath("//div[@class='form-group']//input[@id='user_password']");
    private By btnJoin = By.xpath("//div[@class='form-group']//input[@class='btn btn-default btn-block-level']");

    @Test

    public void registration(){

        driver.get(getData.getURL);
        driver.findElement(btnLogIn).click();
        driver.findElement(btnJoinUnsplash).click();

        driver.findElement(inputFirstName).sendKeys(getData.firstName);
        driver.findElement(inputLastName).sendKeys(getData.lastName);
        driver.findElement(inputEmail).sendKeys(getData.email);
        driver.findElement(inputUsername).sendKeys(getData.userName);
        driver.findElement(inputPassword).sendKeys(getData.password);
        driver.findElement(btnJoin).click();
        driver.quit();
    }


}
