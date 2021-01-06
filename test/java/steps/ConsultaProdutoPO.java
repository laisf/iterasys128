package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Home;
import pages.Lista;
import pages.Produto;
import utils.Evidences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConsultaProdutoPO {
    Home home;
    Produto produto;
    Lista lista;

    Evidences evidences;

    String id;
    String url;
    WebDriver driver;

    static String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()) + "/";

    @Before
    public void iniciar() {
        url = "https://www.cobasi.com.br";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        evidences = new Evidences();
        home = new Home(driver);
        lista = new Lista(driver);
        produto = new Produto(driver);


    }

    @After
    public void finalizar() {
        //driver.quit();
    }

    @Dado("^que acesso o site da Petz \"([^\"]*)\" PO$")
    public void queAcessoOSiteDaPetzPO(String id) throws InterruptedException {
        this.id = id;
        driver.get(url);

    }

    @Quando("^procuro por \"([^\"]*)\" e pressiono Enter PO$")
    public void procuroPorEPressionoEnterPO(String produto) {
        home.buscarProdutoComEnter(produto);

    }

    @Entao("^exibe a lista de produtos relacionados a \"([^\"]*)\" PO$")
    public void exibeAListaDeProdutosRelacionadosAPO(String produto) throws InterruptedException {
        Thread.sleep(35000);
        // Titulo da Aba
        assertEquals(produto + " - Cobasi", lista.lerTituloAba());
        Thread.sleep(15000);
        // Resultado para Prodruto
        assertEquals("VOCÊ BUSCOU POR \"" + produto.toUpperCase() + "\"", lista.lerResultadoParaProduto());

    }

    @Quando("^seleciono o produto \"([^\"]*)\" da lista PO$")
    public void selecionoOProdutoDaListaPO(String produtoDescricao) throws InterruptedException {
        Thread.sleep(15000);
        lista.clicarNoProdutoDaLista(produtoDescricao);

    }

    @Entao("^verifico o preco \"([^\"]*)\" e o nome como \"([^\"]*)\" PO$")
    public void verificoOPrecoEONomeComoPO(String preco, String produtoDescricao) throws InterruptedException {

        Thread.sleep(40000);

        // Validar Preco
        assertEquals(preco, produto.lerPreco());

        //Validar Preco Assinante
        assertEquals(produtoDescricao, produto.lerProdutoDescricao());


    }
}
