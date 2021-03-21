import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GistAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,5);

        driver.get("https://www.github.com/");
        driver.manage().window().maximize();

        WebElement btnSignIn = driver.findElement(By.xpath("//a[contains(text(), 'Sign in')]"));
        btnSignIn.click();

        WebElement inputUserName = driver.findElement(By.cssSelector("input[id='login_field']"));
        inputUserName.sendKeys("pintarwarung123@gmail.com");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement inputPassword = driver.findElement(By.cssSelector("input[id='password']"));
        inputPassword.sendKeys("Warpin123");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement btnLogin = driver.findElement(By.cssSelector("input[class*='btn-block']"));
        btnLogin.click();

        WebElement btnDropDown = driver.findElement(By.cssSelector("summary[class*='Header-link'] svg"));
        btnDropDown.click();

        WebElement menuNewGist = driver.findElement(By.cssSelector("details-menu[class*='dropdown-menu'] a:nth-of-type(3)"));
        menuNewGist.click();

        WebElement inputNewGist = driver.findElement(By.cssSelector("input[class*='js-blob-filename'] "));
        inputNewGist.sendKeys("NewGist");

        WebElement inputContents = driver.findElement(By.cssSelector("pre[class*='CodeMirror-line'] "));
        inputContents.sendKeys("ini adalah  kontent");

        WebElement btnCreateGist = driver.findElement(By.cssSelector("button[class*='BtnGroup-item']"));
        btnCreateGist.click();

        WebElement btnEdit = driver.findElement(By.cssSelector("svg[class*='octicon-pencil']"));
        btnEdit.click();

        WebElement inputEditNewGist = driver.findElement(By.cssSelector("input[class*='js-blob-filename'] "));
        inputEditNewGist.sendKeys("NewGistEdit");

        WebElement btnUpdate = driver.findElement(By.cssSelector("button[class*='btn btn-primary']"));
        btnUpdate.click();

        Thread.sleep(3000);
        driver.quit();

    }
}
