package tarefa14;
//bibliotecas


import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

//Classes
public class Tarefa14 {
    String url;
    WebDriver driver;
    String pastaPrint = "evidencias/" + new SimpleDateFormat("YYYY-MM-dd, HH-mm").format(Calendar.getInstance().getTime()) + "/";
    

    //metodos
    
    public void Printar(String nomeprint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomeprint + ".png"));
        
    }


    @Before
    public void Iniciar() {
        url = "https://www.iterasys.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }
    @After
    public void Finalizar() {
        driver.quit();
    }

    @Test
    public void fazerLogin() throws IOException {
        driver.get(url);
        Printar("C001 - Acessa a home");
        driver.findElement(By.cssSelector("i.fa.fa-sign-in")).click();
        Printar("C002 - Exibe tela para efetuar login");
        driver.findElement(By.id("email")).sendKeys(Keys.chord("****@gmail.com"));
        driver.findElement(By.id("senha")).sendKeys(Keys.chord("*****"));
        driver.findElement(By.id("btn_login")).click();
        Printar("C003 - Acessa a pagina pessoal");

        //validar nome do botao todos os cursos

        Assert.assertEquals("Todos os cursos",driver.findElement(By.id("btn_all")).getText());
        Assert.assertEquals("Meus Cursos",driver.findElement(By.id("btn_my")).getText());



    }




}
