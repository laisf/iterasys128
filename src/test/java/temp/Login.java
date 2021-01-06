package temp;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Login {
    String url;
    WebDriver driver;
    String pastaPrint = "evidencia/" +new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));


    }


    @Before
    public void iniciar (){
        url = "https://www.petz.com.br";
        System.setProperty("webdriver.chrome.driver","drivers/Chrome/87/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
    }



    @After
    public void finalizar(){
        driver.quit();
    }

    @Dado("^que acesso o site da Petz$")
    public void queAcessoOSiteDaPetz() throws IOException, InterruptedException {
        driver.get(url);
        Thread.sleep(30000);
        tirarPrint("Passo 01 - Acessou o site Petz");

    }

    @Quando("^preciono Cadastre-se$")
    public void precionoCadastreSe() throws InterruptedException, IOException {
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("button.greetings")).click();
        tirarPrint("Passo 02 - Pressionou o botão Cadastre-se");

    }

    @E("^seleciono Entrar$")
    public void selecionoEntrar() throws IOException, InterruptedException {
        driver.findElement(By.cssSelector("a.button-login")).click();
        Thread.sleep(30000);
        tirarPrint("Passo 03 - Pressionou o botão Entrar");
        
    }

    @Quando("^preencho o \"([^\"]*)\" e a \"([^\"]*)\" e clico em entrar$")
    public void preenchoOEAEClicoEmEntrar(String email, String senha) throws IOException, InterruptedException {
        Thread.sleep(30000);
        driver.findElement(By.xpath("//body/div[8]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys(email);
        driver.findElement(By.id("senha")).sendKeys(senha);
        driver.findElement(By.cssSelector("input.btn.modal-petz-btn.btn-redondo-verde")).click();
        Thread.sleep(30000);
        tirarPrint("Passo 04 - Preencheu os campos");

    }

    @Entao("^efetuo o login com sucesso$")
    public void efetuoOLoginComSucesso() throws IOException {
        tirarPrint("Passo 05 - Fez login");
    }
// Login sem sucesso

    @Dado("^que acesso o site da Petz cenario$")
    public void queAcessoOSiteDaPetzCenario() throws InterruptedException, IOException {
        driver.get(url);
        Thread.sleep(30000);
        tirarPrint("Passo 01 - Acessou o site Petz");
    }

    @Quando("^aperto Cadastre-se$")
    public void apertoCadastreSe() throws InterruptedException, IOException {
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("button.greetings")).click();
        tirarPrint("Passo 02 - Pressionou o botão Cadastre-se");
    }

    @E("^clico Entrar$")
    public void clicoEntrar() throws InterruptedException, IOException {
        driver.findElement(By.cssSelector("a.button-login")).click();
        Thread.sleep(30000);
        tirarPrint("Passo 03 - Pressionou o botão Entrar");
    }
    @Quando("^preencho o Email com o endereco \"([^\"]*)\" e a Senha com \"([^\"]*)\" e clico em entrar$")
    public void preenchoOEmailComOEnderecoEASenhaComEClicoEmEntrar(String email, String senha) throws InterruptedException, IOException {
        Thread.sleep(30000);
        driver.findElement(By.xpath("//body/div[8]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys(email);
        driver.findElement(By.id("senha")).sendKeys(senha);
        driver.findElement(By.cssSelector("input.btn.modal-petz-btn.btn-redondo-verde")).click();
        tirarPrint("Passo 04 - Preencheu o campos");
    }

    @Entao("^aparece a mensagem que os dados estao incorrentos$")
    public void apareceAMensagemQueOsDadosEstaoIncorrentos() throws IOException {

        tirarPrint("Passo 05 - Mensagem de incorreto");

        Assert.assertEquals("Dados incorretos!", driver.findElement(By.xpath("//div[contains(text(),'Dados incorretos!')]")).getText());
    }



}
