package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Attach;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MainTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public final String BaseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public void setUp(boolean useRemote) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);

        if (useRemote) {
            driver = new RemoteWebDriver(new URL(System.getProperty("remoteUrl")), capabilities);
        } else {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(BaseUrl);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @BeforeEach
    void init() throws MalformedURLException {
        setUp(Boolean.parseBoolean(System.getProperty("useRemote", "false")));
    }
    @AfterEach
    void addAttachments() {
        Attach.attachCSVFile("transactions.csv");
        driver.close();
        driver.quit();
    }
}

