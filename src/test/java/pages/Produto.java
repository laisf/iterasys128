package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Produto extends PageObject {

    @FindBy(css = "span.d-block.price__por")
    private WebElement preco;

    @FindBy(css = "h1.product__name")
    private WebElement produtoDescricao;

    public Produto(WebDriver driver) {
        super(driver);

    }

    public String lerPreco(){
        return preco.getText();

    }

    public String lerProdutoDescricao(){
        return produtoDescricao.getText();



    }
}
