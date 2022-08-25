import Base.BasePage;
import Pages.LoginPage;
import Pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class SearchTest {

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
        page.buscarCidade("Punta del Este");
        Thread.sleep(2000);
        page.buscar();
        Thread.sleep(2000);
        String resultadoBusca = page.getResultado();

        assertTrue(resultadoBusca.contains("Villa Kantounes Studio Ostria"));

        System.out.println("Resultado:" + resultadoBusca);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
