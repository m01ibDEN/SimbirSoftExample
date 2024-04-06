package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Attach;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static WebDriver driver;
    public String BaseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    public static final String GRID_HUB_URL = "http://192.168.1.112:4444/wd/hub";

    public void setUp(boolean useRemote) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.LINUX);

        if (useRemote) {
            driver = new RemoteWebDriver(new URL(GRID_HUB_URL), capabilities);
        } else {
            System.setProperty("webdriver.chrome.driver", "/home/ten0l/drivers/chromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(BaseUrl);

    }

    @BeforeEach
    void init() throws MalformedURLException {
        setUp(Boolean.parseBoolean(System.getProperty("useRemote", "false")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterEach
    void addAttachments() {
        Attach.attachCSVFile("transactions.csv");
        driver.close();
        driver.quit();
    }
}

