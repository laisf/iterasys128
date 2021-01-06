package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Json {

    public static String ler(String caminhoMassa){
        String jsonData = null; // Cria a string totalmente limpa
        {
            try {
                FileUtils.readFileToString(new File(caminhoMassa), jsonData);
            }catch (IOException e){
                e.printStackTrace();

            }
        }


        return jsonData;
    }
}
