import Base.BasePage;
import Pages.LoginPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        BasePage basePage = new BasePage();
        basePage.openApp();
        driver = basePage.getDriver();
    }

    @Test
    public void testeLogin() throws InterruptedException {

        LoginPage page = new LoginPage();
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

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
