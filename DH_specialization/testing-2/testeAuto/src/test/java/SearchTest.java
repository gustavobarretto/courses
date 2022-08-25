import digitalBooking.base.BasePage;
import digitalBooking.pages.LoginPage;
import digitalBooking.pages.SearchPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {

    private static SearchPage page;

    @BeforeEach
    public void setUp() {

        page = new SearchPage();
        page.openApp();

    }

    @Test
    @Tag("SmokeTest")
    public void testSearch() throws InterruptedException {

        page.buscarCidade("Punta del Este");
        Thread.sleep(2000);
        page.buscar();
        Thread.sleep(2000);
        String resultadoBusca = page.getResultado();

        assertTrue(resultadoBusca.contains("Villa Kantounes Studio Ostria"));

        System.out.println("Resultado:" + resultadoBusca);
    }

    @AfterEach
    public void tearDown(){
        page.quitDriver();
    }

}
