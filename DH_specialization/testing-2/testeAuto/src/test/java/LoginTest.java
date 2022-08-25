import digitalBooking.pages.LoginPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Tag("Regression")
public class LoginTest {

    private static LoginPage page;

    @BeforeEach
    public void setUp() {

        page = new LoginPage();
        page.openApp();

    }

    @Test
    @Tag("Regression")
    public void testeLogin() throws InterruptedException {

        page.irParaIniciarSessao();
        Thread.sleep(2000);
        page.inserirDadosLogin("tgomes@digitalhouse.com","turma01");
        Thread.sleep(2000);
        page.fazerLogin();
        Thread.sleep(2000);
        String usuarioLogado = page.getUsuario();

        assertTrue(usuarioLogado.contains("Tiago"));

        System.out.println("Usuario logado:" + usuarioLogado);

    }

    @Tag("Regression")
    @Test
    public void testeLogin2() throws InterruptedException {

        page.irParaIniciarSessao();
        Thread.sleep(2000);
        page.inserirDadosLogin("tgomes@digitalhouse.com","turma01");
        Thread.sleep(2000);
        page.fazerLogin();
        Thread.sleep(2000);
        String usuarioLogado = page.getUsuario();

        assertTrue(usuarioLogado.contains("Tiago"));

        System.out.println("Usuario logado:" + usuarioLogado);

    }

    @AfterEach
    public void tearDown(){
        page.quitDriver();
    }
}
