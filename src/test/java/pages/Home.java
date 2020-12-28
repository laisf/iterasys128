package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends PageObject{
    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/fieldset[1]/input[2]")
    private WebElement caixaPesquisa;

    @FindBy(css = "btn-buscar")
    private WebElement lupa;

    public Home(WebDriver driver) {
        super(driver);
    }

    public void buscarProdutoComEnter(String produto){
        caixaPesquisa.clear();
        caixaPesquisa.sendKeys(produto + Keys.ENTER);
    }
}
