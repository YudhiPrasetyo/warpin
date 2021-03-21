import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class EbayAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();


        WebElement clickCategory = driver.findElement(By.cssSelector("li[class*='saved'] + li[data-currenttabindex*='0'] "));
        clickCategory.click();

        WebElement clickCategoryCell = driver.findElement(By.cssSelector("div[class*='b-list__header'] + ul li:nth-of-type(11) a"));
        clickCategoryCell.click();

        WebElement clickSmartPhoneParts = driver.findElement(By.xpath("//a[contains(text(), 'Cell Phones & Smartphones')]"));
        clickSmartPhoneParts.click();

        WebElement clickMoreRefinements = driver.findElement(By.cssSelector("li[class*='x-refine__main__list--more'] div"));
        js.executeScript("window.scrollBy(0,-500)", "");
        clickMoreRefinements.click();


        Thread.sleep(3000);
        driver.quit();

    }
}
