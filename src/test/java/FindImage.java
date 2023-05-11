import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FindImage {
    Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;
    WebDriver driver = new ChromeDriver();
    Data getData = new Data();
    WebDriverWait waiting = new WebDriverWait(driver, Duration.ofMillis(500));

    private By btnVisualSearch = By.xpath("//div[@class='TkpKu']//button[@class='r7Rbd jpBZ0']");
    private By inputChooseFile = By.xpath("//div[@class='GD3rC mNDtF ktOwB']//input[@class='ctM_F gdt34']");
    private By getText = By.xpath("//div[@class='Aa1sS j8AIa xNKUO dvBHu oh0KJ']//h1[@class='dvBHu oh0KJ']");

    @Test
    public void findImage(){

        driver.get(getData.getURL);
        waiting.until(ExpectedConditions.elementToBeClickable(btnVisualSearch));
        driver.findElement(btnVisualSearch).click();
        waiting.until(ExpectedConditions.elementToBeClickable(inputChooseFile));
        driver.findElement(inputChooseFile).sendKeys(getData.imagePath);
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xv")
                .keyUp(cmdCtrl)
                .perform();
        waiting.until(ExpectedConditions.elementToBeClickable(getText));
        String getTextVisualSearch = driver.findElement(getText).getText();
        Assert.assertEquals("Visual search",getTextVisualSearch);
        driver.quit();
    }
}