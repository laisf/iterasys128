package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Evidences {

    public void tirarPrint(WebDriver driver, String id, String pastaPrint, String nomePrint ) throws IOException {
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + "Cenario" + "/" + nomePrint + ".png"));




    }


}
