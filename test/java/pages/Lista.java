package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Lista extends PageObject {
    //resultado para
    @FindBy(xpath = "//body/div[10]/div[1]/div[1]/div[1]/div[5]/ul[1]/li[3]")
    private WebElement resultadoParaProduto;


    public Lista(WebDriver driver) {
        super(driver);
    }


    public String lerResultadoParaProduto() {
        return resultadoParaProduto.getText();
    }


    public String lerTituloAba() {
        return driver.getTitle();

    }

    // Clicar no produto escolhido
    public void clicarNoProdutoDaLista(String produtoDescricao) {
        WebElement nomeDoProduto = driver.findElement(By.xpath("//a[contains(text(),'"+produtoDescricao+"')]"));
        nomeDoProduto.click();
    }

}
