package digitalBooking.pages;

import digitalBooking.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage {

    protected static final String inputCidade = "ciudad"; //id
    protected static final String btnBuscar = "btn-buscador"; //id
    protected static final String resultadoBusca = "card-list"; //classname
    protected static final String btnVerDetalhe = "//*[@id=\"76\"]/div[2]/a"; //xpath
    protected static final String btnIniciarReserva = "//*[@id=\"root\"]/main/div[7]/div/div[2]/div/a"; //xpath
    protected static final String inputCidadeReserva = "//*[@id=\"ciudad\"]"; //xpath
    protected static final String btnConfirmarReserva = "//*[@id=\"form-reserva\"]/div/div[2]/div/div/div[2]/button"; //xpath
    protected static final String mensagemErro = "//*[@id=\"form-reserva\"]/div[2]/h4"; //xpath

    public void buscarCidade(String cidade) throws InterruptedException {
        WebElement searchBox = getWebElement(By.id(inputCidade));
        searchBox.clear();
        searchBox.sendKeys(cidade);
        Thread.sleep(1000);
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getResultado() {
        WebElement resultado = getWebElement(By.className(resultadoBusca));
        return resultado.getText();
    }

    public void buscar() {
        WebElement buscar = getWebElement(By.id(btnBuscar));
        buscar.click();
    }

    public void verDetalhe() {
        WebElement detalhe = getWebElement(By.xpath(btnVerDetalhe));
        detalhe.click();
    }

    public void iniciarReserva() {
        WebElement reserva = getWebElement(By.xpath(btnIniciarReserva));
        reserva.click();
    }

    public void preencherCidade(String inserirCidadeReserva) {
        WebElement cidadeReserva = getWebElement(By.xpath(inputCidadeReserva));
        cidadeReserva.clear();
        cidadeReserva.sendKeys(inserirCidadeReserva);
    }

    public void confirmaReserva() {
        WebElement confirmaReserva = getWebElement(By.xpath(btnConfirmarReserva));
        confirmaReserva.click();
    }

    public String getMensagemErro() {
        WebElement erro = getWebElement(By.xpath(mensagemErro));
        return erro.getText();
    }
}
