package tarefa;

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

public class tarefa13 {

    String url;
    WebDriver driver;
    String pastaPrint = "evidencias/" + new SimpleDateFormat("YYYY-MM-dd, HH-mm").format(Calendar.getInstance().getTime()) + "/";

    public void Printar(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
    }

    @Before
    public void inicializar() {
        url = "https://www.iterasys.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/87/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

    }
    @Test
    public void compraSiteIterasys() throws InterruptedException, IOException {
        driver.get(url);
        Thread.sleep(3000);
        Printar("C001 - Acessa a home");

        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click(); //ok no aviso dos cookies
        //driver.findElement(By.id("searchtext")).click(); //clica na barra de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("ctfl")); //digita letra por letra
        Thread.sleep(3000);
        Printar("C002 - Exibe cursos relacionados ao CFTL");
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER); //pressiona a tecla enter
        driver.findElement(By.cssSelector("span.comprar")).click(); //clica em comprar
        Printar("C003 - Exibe titulo e valor do curso CFTL");

        //validar nome do curso
        Assert.assertTrue(driver.findElement(By.cssSelector("span.item-title")).getText().contains("CTFL"));
        //Assert.assertEquals("PreparatÂ³rio CTFL", driver.findElement(By.cssSelector("span.item-title")).getText());

        //validar valor do curso
        Assert.assertEquals("R$ 22,90",driver.findElement(By.className("new-price")).getText());

        //validar o subtotal
        Assert.assertEquals("SUBTOTAL R$ 22,90",driver.findElement(By.className("subtotal")).getText());

        //validar o valor das parcelas
        Assert.assertTrue(driver.findElement(By.className("ou-parcele")).getText().contains("ou em 3 x de R$ 7,63"));








    }



    @After
    public void finalizar(){
        // driver.quit();

    }



}
