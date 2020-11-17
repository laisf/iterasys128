package site;
//bibliotecas



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//classes
public class Listas {
    String url;
    WebDriver driver;

    @Before
    public void inicializar(){
        url = "https://www.iterasys.com.br/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();


    }

    @Test
    public void compraSiteIterasys() throws InterruptedException {
        driver.get(url);
        Thread.sleep(3000);

        driver.findElement(By.cssSelector("a.cc-btn.cc-dismiss")).click(); //ok no aviso dos cookies
        //driver.findElement(By.id("searchtext")).click(); //clica na barra de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys(Keys.chord("ctfl")); //digita letra por letra
        Thread.sleep(3000);
        driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER); //pressiona a tecla enter
        driver.findElement(By.cssSelector("span.comprar")).click(); //clica em comprar






    }



    @After
    public void finalizar(){
        driver.quit();


    }












}
