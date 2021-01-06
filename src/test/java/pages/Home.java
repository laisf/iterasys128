package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageObject { //significa que ele continua de onde a pageobject comecou, por isso ela extende

   //Atributos / Elementos da Pagina
    @FindBy(id = "search") //mesma coisa que o findElemente
    private WebElement busca; //eh o apelido

    @FindBy(css = "button.button-search")
    private WebElement lupa;

      // Construtor Obrigatorio

    public Home(WebDriver driver){
        super(driver);
    }

    public void buscarProdutoComEnter(String produto){
        busca.clear();
        busca.sendKeys(produto + Keys.ENTER); //escrever o termo e dar enter
    }
    public void buscarProdutoComLupa(String produto) {
        busca.sendKeys(produto);
        lupa.click();
    }


}
