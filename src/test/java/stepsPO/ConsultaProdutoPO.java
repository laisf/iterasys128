package stepsPO;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Home;
import pages.Lista;
import pages.Produto;
import utils.Evidences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConsultaProdutoPO {
    // Paginas
    Home home;
    Lista lista;
    Produto produto;

    // Classes de Apoio / Utils
    Evidences evidences; //referencia a classe Evidences que nós criamos

    // Atributos e Objetos
    String id; //id compartilhado por todos os blocos de steps
    String url;
    WebDriver driver;
    static String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()) + "/";



    @Before
    public void iniciar(){
        url = "http://www.petz.com.br";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/87/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

        evidences = new Evidences();
        home = new Home(driver);
        lista = new Lista(driver);
        produto = new Produto(driver);

    }
    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Passo 06 - Fechou o navegador");
    }

    @Dado("^que acesso o site da Petz \"([^\"]*)\" PO$")
    public void que_acesso_o_site_da_Petz_PO(String id) {
        driver.get(url);
    }

    @Quando("^procuro por \"([^\"]*)\" e pressiono Enter PO$")
    public void procuroPorEPressionoEnterPO(String produto) {
        home.buscarProdutoComEnter(produto);
    }

    @Entao("^exibe a lista de produtos relacionados a \"([^\"]*)\" PO$")
    public void exibeAListaDeProdutosRelacionadosAPO(String produto) {
        // Titulo da Aba
        assertEquals(produto + " - Produtos pet em promoção | Petz", lista.lerTituloAba());

        // Resultado para Prodruto
        assertEquals("RESULTADOS PARA \"" + produto.toUpperCase() + "\"", lista.lerResultadoParaProduto());

        //Mensagem de Erro
        //assertEquals("Os resultados desta busca são aproximados, pois não encontramos resultados para \"" + " + "produto + "\"",lista.lerMensagemDeErro());

    }

    @Quando("^seleciono o produto \"([^\"]*)\" da lista PO$")
    public void selecionoOProdutoDaListaPO(String produto) throws InterruptedException {
        // Clicar no Produto da Lista
        Thread.sleep(40000);
        lista.clicarNoProdutoNaLista(produto);
        Thread.sleep(40000);

    }

    @Entao("^verifico a marca como \"([^\"]*)\" com preco normal de \"([^\"]*)\" e \"([^\"]*)\" para assinantes PO$")
    public void verificoAMarcaComoComPrecoNormalDeEParaAssinantesPO(String marca, String precoNormal, String precoAssinate) throws InterruptedException {

        Thread.sleep(40000);
        // Validar marca
        assertEquals(marca,produto.lerMarca());

        // Validar Preco normal
        assertEquals(precoNormal, produto.lerPrecoNormal());

        //Validar Preco Assinante
        assertEquals(precoAssinate, produto.lerPrecoAssinante());


    }




}
