import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class EbayAutomation2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class*='ui-autocomplete-input']"));
        inputSearch.sendKeys("Macbook");

        WebElement btnSearch = driver.findElement(By.cssSelector("input[class*='btn-prim']"));
        btnSearch.click();

        WebElement chooseCategory = driver.findElement(By.xpath("//span[contains (text(), 'Computers/Tablets & Networking')]"));
        chooseCategory.click();

        WebElement labelResult = driver.findElement(By.cssSelector("div[class*='srp-controls__count'] h1 span:last-of-type"));
        assertEquals("Macbook", labelResult.getText());

        Thread.sleep(3000);
        driver.quit();
    }
}
