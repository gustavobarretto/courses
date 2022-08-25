package digitalBooking.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage {

    public static WebDriver driver;
    protected static final String URL = "http://fe.deitech.online/";

    public BasePage() {
//        if (driver == null) {
//        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
//            driver.manage().window().maximize();
//        }
    }

    public void openApp() {
        getDriver().get(URL);
        getDriver().manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getWebElement(By locator) {
        WebElement elemento = null;
        try {
            elemento = driver.findElement(locator);
        } catch (Exception e) {
            System.out.println("Elemento não encontrado:");
            System.out.println("Mensagem de erro:" + e);
        }
        return elemento;
    }

    public void quitDriver(){
        getDriver().quit();
    }

}
