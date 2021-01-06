package temp;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
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

public class Cadastro {
    String url;
    WebDriver driver;
    String pastaPrint = "evidencia/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); //selenium com a classe de tirar foto salva na memoria ram
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
    }

    @Before
    public void iniciar() throws IOException {
        url = "https://www.petz.com.br";
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/87/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--disable-notifications");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

    }


    @After
    public void finalizar() throws IOException {
        driver.quit();
        tirarPrint("Passo 07 - Fechou");
    }

    @Dado("^que entro na pagina da Petz$")
    public void queEntroNaPaginaDaPetz() throws IOException, InterruptedException {
        driver.get(url);
        Thread.sleep(30000);
        tirarPrint("Passo 01 - Acessou o site Petz");
    }

    @Quando("^clico em Cadastre-se$")
    public void clicoEmCadastreSe() throws IOException, InterruptedException {
        Thread.sleep(30000);
        driver.findElement(By.cssSelector("i.icon-user")).click();
        tirarPrint("Passo 02 - clicou em Cadastre-se");
    }


    @E("^seleciono Criar conta$")
    public void selecionoCriarConta() throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'Criar conta')]")).click();
        tirarPrint("Passo 03 - clicou em Criar Conta");
    }

    @Quando("^exibe a pagina de cadastro e preencho \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\"$")
    public void exibeAPaginaDeCadastroEPreenchoEEEEEEEE(String nomeCompleto, String email, String ddd, String celular, String sexo, String dataNascimento, String cpf, String senha, String confSenha) {
        driver.findElement(By.id("Nome")).sendKeys(nomeCompleto);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.name("cliente.dddCelular")).sendKeys(ddd);
        driver.findElement(By.cssSelector("input.form-control.celular")).sendKeys(celular);
        driver.findElement(By.id("Sexo")).sendKeys(sexo);
        driver.findElement(By.id("dataNascimento")).sendKeys(dataNascimento);
        driver.findElement(By.id("CPF-CNPJ")).sendKeys(cpf);
        driver.findElement(By.id("Senha")).sendKeys(senha);
        driver.findElement(By.id("confirmasenha")).sendKeys(confSenha);
        System.out.println("Passo 04 - Preencheu todos os campos");
    }

    @E("^clico em Criar Conta$")
    public void clicoEmCriarConta() throws IOException {
        driver.findElement(By.id("criarContaButton")).click();

        tirarPrint("Passo 05 - Clicou em criar conta");


    }


    @Entao("^crio a conta de usuario$")
    public void crioAContaDeUsuario() throws IOException {

        tirarPrint("Passo 06 - Criou a conta");
        driver.findElement(By.cssSelector("div.btns")).click();



    }


}












