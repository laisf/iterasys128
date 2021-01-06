package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Evidences; // precisa importar pq esta em outro pacote

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConsultaProduto {
    Evidences evidences; //referencia a classe Evidences que nós criamos
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
      System.out.println("Passo 00 - Preparou o setup"); //Instanciou Selenium como ChromeDriver
        evidences = new Evidences();

    }
    @After
    public void finalizar(){
        driver.quit();
        System.out.println("Passo 06 - Fechou o navegador");
    }





    @Dado("^que acesso o site da Petz \"([^\"]*)\"$")
    public void que_acesso_o_site_da_Petz(String id) throws IOException {
        driver.get(url);
        this.id = id;
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 01 - Acessou o site da Petz");
        System.out.println("Passo 01 - Acessou o site da Petz");


    }

    @Quando("^procuro por \"([^\"]*)\" e pressiono Enter$")
    public void procuro_por_e_pressiono_Enter(String termo) throws IOException {
        driver.findElement(By.id("search")).sendKeys(termo);
        //todo: tirar print
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 02 - Procurou por " + termo);
        driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
        System.out.println("Passo 02 - Procurou por " + termo);

    }

    @Entao("^exibe a lista de produtos relacionados a \"([^\"]*)\"$")
    public void exibe_a_lista_de_produtos_relacionados_a(String termo) throws IOException {
        assertEquals(termo + " - Produtos pet em promoção | Petz",driver.getTitle()); //compara com o que esta escrito na aba ativa!
        assertEquals("RESULTADOS PARA \"" + termo.toUpperCase() + "\"", driver.findElement(By.cssSelector("h1.h2Categoria.nomeCategoria")).getText()); //aspas e as letras maiusculas
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 03 - Exibiu a lista de produtos relacionados com" + termo);
        System.out.println("Passo 03 - Exibiu a lista de produtos relacionados com" + termo);

    }

    @Quando("^seleciono o primeiro produto da lista$")
    public void seleciono_o_primeiro_produto_da_lista() throws IOException {
        //driver.findElement(By.cssSelector("img.product-img.img-responsive")).click(); //pela imagem
        driver.findElement(By.xpath("//h3[contains(., 'Ração Royal Canin Maxi - Cães Adultos - 15kg')]")).click();
        //driver.findElement(By.cssSelector("h3.nome_produto)")).click(); pelo nome do produto
        //driver.findElement(By.cssSelector("li.liProduct:nth-child(3) > a:nth-child(2)")).click(); //pega sempre o primeiro
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 04 - Selecionou o primeiro produto da lista");
        System.out.println("Passo 04 - Selecionou o primeiro produto da lista");
    }

    @Entao("^verifico que a marca como \"([^\"]*)\" com preco normal de \"([^\"]*)\" e \"([^\"]*)\" para assinantes$")
    public void verifico_que_a_marca_como_com_preco_normal_de_e_para_assinantes(String marca, String precoNormal, String precoAssinante) throws IOException {
        assertEquals("Royal Canin", driver.findElement(By.cssSelector("span.blue")).getText()); //marca
        assertEquals("R$ 232,69", driver.findElement(By.cssSelector("div.price-current")).getText()); //preco
        assertEquals("R$ 209,42", driver.findElement(By.cssSelector("span.price-subscriber")).getText()); //preco assinantes
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 05 - Verificou a marca como " + marca + ", o preco normal" + precoNormal + "e o preco do assinante como" + precoAssinante);
        System.out.println("Passo 05 - Verificou a marca como " + marca + ", o preco normal" + precoNormal + "e o preco do assinante como" + precoAssinante);
    }

       //Cenario: Consulta Produto Fixo com Clique na lupa
        @Quando("^procuro por \"([^\"]*)\" e clico na lupa$")
        public void procuro_por_e_clico_na_lupa(String termo) throws IOException {
            driver.findElement(By.id("search")).sendKeys(termo);
            //todo: tirar print
            evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 02 - Procurou por " + termo);
            driver.findElement(By.cssSelector("button.button-search")).click();
            System.out.println("Passo 02 - Procurou por " + termo);
        }

    @Entao("^exibe uma lista de produtos aproximados e a mensagem de que encontrou \"([^\"]*)\"$")
    public void exibe_uma_lista_de_produtos_aproximados_e_a_mensagem_de_que_encontrou(String termo) throws IOException {
        assertEquals("Os resultados desta busca são aproximados, pois não encontramos resultados para \"" + termo + "\"",driver.findElement(By.cssSelector("span.descricao-lucene:nth-child(2)")).getText());
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo x - Acessou o site da Petz");
            }


    @Entao("^exibe uma caixa de alerta  dizendo que precisa preencher pelo menos tres letras no termo$")
    public void exibeUmaCaixaDeAlertaDizendoQuePrecisaPreencherPeloMenosTresLetrasNoTermo() throws IOException {
    assertEquals("Digite pelo menos 3 caracteres",driver.switchTo().alert().getText());
    driver.switchTo().alert().accept(); //clica no positivo/ok
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo y - Exibiu mensagem de erro");
    }


    @Entao("^verifico a \"([^\"]*)\" com o \"([^\"]*)\" e \"([^\"]*)\"$")
    public void verificoAComOE(String marca, String precoNormal, String precoAssinante) throws IOException {
        assertEquals(marca, driver.findElement(By.cssSelector("span.blue")).getText()); //marca
        assertEquals(precoNormal, driver.findElement(By.cssSelector("div.price-current")).getText()); //preco
        assertEquals(precoAssinante, driver.findElement(By.cssSelector("span.price-subscriber")).getText()); //preco assinantes
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 05 - Verificou a marca como " + marca + ", o preco normal" + precoNormal + "e o preco do assinante como" + precoAssinante);
        System.out.println("Passo 05 - Verificou a marca como " + marca + ", o preco normal" + precoNormal + "e o preco do assinante como" + precoAssinante);


    }

    @Quando("^seleciono o \"([^\"]*)\" da lista$")
    public void selecionoODaLista(String produtoDescricao) throws IOException {
        driver.findElement(By.xpath("//h3[contains(.,\'" + produtoDescricao + "\')]")).click();
        evidences.takesScreenshot(driver, id, pastaPrint, "consultarProduto - Passo 4b - Selecionou o primeiro produto da lista");
        System.out.println("Passo 4b - Selecionou o primeiro produto da lista");
    }



}

