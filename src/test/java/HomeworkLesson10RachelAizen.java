import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HomeworkLesson10RachelAizen {

    private static ChromeDriver driver;
    private static NgWebDriver ngWebDriver;

    @BeforeClass
    public static void runOnceBeforeClass()
    {driver = (ChromeDriver) DriverSingleton.getDriverInstance();
    ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
    System.setProperty("webdriver.chromedriver.driver", "C:\\Users\\888\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.get("https://dgotlieb.github.io/Selenium/synchronization.html");}

    //1
    @Test
    public void assignment1()
    {driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.id("checkbox")).isDisplayed();
    driver.findElement(By.id("btn")).click();
    driver.findElement(By.id("message")).isDisplayed();}

    @Test
    public void assignment1B() throws InterruptedException
    {driver.findElement(By.id("hidden")).click();
    Thread.sleep(5000);
    driver.findElement(By.cssSelector("div[style='']")).isDisplayed();}

    @Test
    public void assignment1C()
    {driver.findElement(By.id("rendered")).click();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish2")));
    String result = driver.findElement(By.id("finish2")).getText();
    assertEquals(result, "This is a new element");}

    //2
    @Test
    public void assignment2()
    {String name = "Rachel";
    driver.navigate().to("https://dgotlieb.github.io/AngularJS/main.html");
    ngWebDriver.waitForAngularRequestsToFinish();
    WebElement namechange = driver.findElement(ByAngular.model("firstName"));
    namechange.clear();
    namechange.sendKeys("Rachel");
    assertEquals(driver.findElement(By.xpath("//input")).getAttribute("value"),"Rachel");}

    //3
    // Answer: Give a defined time for the Selenium to wait for a page to load.

    //4
    @Test
    public void assignment4() throws InterruptedException
    {driver.get("https://dgotlieb.github.io/WebCalculator/");
    System.out.println(driver.findElement(By.id(Constants.Seven)).getSize());
    System.out.println(driver.findElement(By.id("six")).isDisplayed());
    WebCalculator.Five();
    WebCalculator.Plus();
    WebCalculator.Five();
    WebCalculator.Equals();
    Thread.sleep(1000);
    String Expecting = "10";
    assertEquals(Expecting, WebCalculator.Result());}

    @AfterClass
    public void endAll()
    {driver.quit();}

}
