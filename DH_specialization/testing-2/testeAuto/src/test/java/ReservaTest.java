import digitalBooking.base.BasePage;
import digitalBooking.base.BasePageReserva;
import digitalBooking.pages.LoginPage;
import digitalBooking.pages.LoginPageReserva;
import digitalBooking.pages.SearchPage;
import digitalBooking.pages.SearchPageReserva;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.MethodName.class) @Tag("Regression")
public class ReservaTest {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        BasePageReserva basePage = new BasePageReserva();
        basePage.openApp();
        driver = basePage.getDriver();
    }

    @Test
    public void testSearch() throws InterruptedException {

        LoginPageReserva login = new LoginPageReserva();
        login.irParaIniciarSessao();
        Thread.sleep(2000);
        login.inserirDadosLogin("tgomes@digitalhouse.com","turma01");
        Thread.sleep(2000);
        login.fazerLogin();
        Thread.sleep(2000);

        SearchPageReserva search = new SearchPageReserva();
        search.buscarCidade("Tigre");
        Thread.sleep(2000);
        search.buscar();
        Thread.sleep(2000);
        search.verDetalhe();
        Thread.sleep(2000);
        search.iniciarReserva();
        Thread.sleep(2000);
        search.preencherCidade("Buenos Aires");
        Thread.sleep(2000);
        search.confirmaReserva();
        Thread.sleep(2000);
        String mensagemErro = search.getMensagemErro();

        assertTrue(mensagemErro.contains("Falta completar campos obligatorios"));

        System.out.println("Resultado:" + mensagemErro);
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
