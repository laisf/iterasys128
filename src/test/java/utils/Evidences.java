package utils; //chama de classe de apoio que tudo que se  repetiria nos teste se coloca aqui!!!

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Evidences {



    // método para tirar print
    public void takesScreenshot(WebDriver driver, String id, String pastaPrint, String nomePrint) throws IOException { //webdriver, driver precisou instanciar o chrome ]driver pq ele esta em outra classe e precisa chamar ele nessa tb

        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto,new File(pastaPrint + "Cenario " + id + "/" + nomePrint + ".png"));
    }
}