package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import utils.Evidences;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class ConsultaProduto {
    String url;
    WebDriver driver;
    String pastaPrint = "evidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime()) + "/";


    public void tirarPrint(String nomePrint ) throws IOException {
            File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(foto, new File(pastaPrint + "Cenario" + "/" + nomePrint + ".png"));
        }


    @Before
    public void inicializar() {
        url = "https://www.cobasi.com.br";
        System.setProperty("webdriver.chrome.driver","drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();



    }

    @After
    public void finalizar() throws IOException {
       driver.quit();
       tirarPrint("consultarProduto - Passo 07 - Fechou");
       System.out.println("Passo 07 - Fechou");
    }

    @Dado("^que acesso o site da Cobasi$")
    public void que_acesso_o_site_da_Cobasi() throws IOException {
        driver.get(url);
        tirarPrint("consultarProduto - Passo 01 - Acessou o site");
        //System.out.println("Passo 01 - Acessou o site");

    }

    @E("^procuro por \"([^\"]*)\" e aperto Enter$")
    public void procuroPorEApertoEnter(String termo) throws IOException, InterruptedException {
        Thread.sleep(25000);
        driver.findElement(By.xpath("//header/div[1]/div[1]/div[3]/div[1]/fieldset[1]/input[2]")).sendKeys(termo + Keys.ENTER);
        Thread.sleep(15000);
        tirarPrint("consultarProduto - Passo 02 - Procurou por " + termo);
        System.out.println("Passo 02 - Procurou por " + termo);
    }



    @Quando("^exibe a lista de produtos relacionados ao \"([^\"]*)\"$")
    public void exibe_a_lista_de_produtos_relacionados_ao(String termo) throws IOException {
        Assert.assertEquals(termo + " - Cobasi",driver.getTitle());
        Assert.assertEquals("VOCÊ BUSCOU POR \"" + termo.toUpperCase() + "\"",driver.findElement(By.xpath("//body/div[10]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[3]")).getText());
        tirarPrint("consultarProduto - Passo 03 - Exibiu a lista de produtos relacionados com" + termo);
        System.out.println("Passo 03 - Exibiu a lista de produtos relacionados com" + termo);

    }

    @E("^seleciono o \"([^\"]*)\" da lista$")
    public void selecionoODaLista(String produtoDescricao) throws IOException, InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'"+ produtoDescricao +"')]")).click();
        Thread.sleep(15000);
        tirarPrint("consultarProduto - Passo 04 - Selecionou o item");
        System.out.println("Passo 04 - Selecionou o item");

    }

    @Entao("^verifico o \"([^\"]*)\" e o \"([^\"]*)\"$")
    public void verificoOEO(String preco, String produtoDescricao) throws IOException, InterruptedException {
        Assert.assertEquals("Por: " + preco + "à vista",driver.findElement(By.cssSelector("span.d-block.price__por")).getText());
        Assert.assertEquals(produtoDescricao,driver.findElement(By.cssSelector("h1.product__name")).getText());
        Thread.sleep(15000);
        tirarPrint("consultarProduto - Passo 05 - Selecionou o item");
        System.out.println("Passo 05 - Selecionou o item");


    }



}




