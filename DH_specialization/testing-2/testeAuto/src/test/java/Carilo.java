import digitalBooking.base.BasePage;
import digitalBooking.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Regression")
public class Carilo {
    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        BasePage basePage = new BasePage();
        basePage.openApp();
        driver = basePage.getDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {

        SearchPage page = new SearchPage();
        page.buscarCidade("Carilo");
        page.buscar();
        String resultadoBusca = page.getResultado();

        assertTrue(resultadoBusca.contains("Increíble Casa c/ Piscina, WiFi, Bosque y Playa en Carilo"));

        System.out.println("Resultado:" + resultadoBusca);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
