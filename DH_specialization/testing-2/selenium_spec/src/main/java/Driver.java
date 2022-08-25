import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

        // Open chromedriver
        WebDriver driver = new ChromeDriver();



        // Access to the website
        driver.get("https://www.mercadolivre.com.br");
        driver.wait(3000L);

        // Selecting the element and clicking for search
        WebElement input = driver.findElement(By.cssSelector("#cb1-edit"));
        input.sendKeys("iPhone 13");
        WebElement searchButton = driver.findElement(By.cssSelector("body > header > div > form > button > div"));
        searchButton.click();







    }
}
