package digitalBooking.pages;

import digitalBooking.base.BasePageReserva;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageReserva extends BasePageReserva {

    protected static final String txtIniciarSessao = "#root > header > nav > a:nth-child(2)"; //partialLinkText
    protected static final String inputLogin = "email"; //id
    protected static final String inputPassword = "password"; //id
    protected static final String btnEntrar = "#root > main > div > form > button"; //cssSelector
    protected static final String txtNome = "txt-nombre"; //className

    public void irParaIniciarSessao() throws InterruptedException {
        WebElement botaoIniciarSessao = getWebElement(By.cssSelector(txtIniciarSessao));
        botaoIniciarSessao.click();
        Thread.sleep(1000);
    }

    public void inserirDadosLogin(String email, String senha) {
        WebElement campoLogin = getWebElement(By.id(inputLogin));
        campoLogin.clear();
        campoLogin.sendKeys(email);
        WebElement campoSenha = getWebElement(By.id(inputPassword));
        campoSenha.clear();
        campoSenha.sendKeys(senha);

    }

    public void fazerLogin() {
        WebElement entrar = getWebElement(By.cssSelector(btnEntrar));
        entrar.click();
    }

    public String getUsuario() {
        WebElement entrar = getWebElement(By.className(txtNome));
        return entrar.getText();
    }

}
