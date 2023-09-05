package automationexercise.factory.selenium;

import automationexercise.factory.dao.utils.Setup;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.openqa.selenium.remote.service.DriverFinder;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.SQLException;
import java.time.Duration;

public class BrowserService extends Setup {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeAll
    public static  void installDriver() {
        String caminhoDriver = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);
    }

    // inicia o browser
    public void initChromeDriver(String url){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.get(url);  // Abre o navegador
        driver.manage().window().maximize();  // Maximizar navegador


    }

    public void quit(){
        driver.quit();
    }


}
