package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver; //selenium interno

    public PageObject(WebDriver driver){ //é um construtor, quando alguem chamar a classe pageobject ela vai chamar o selenium. Esse é o selenium de fora
        this.driver = driver;//selenium da classe de dentro, esta recebendo o selenium de fora
        PageFactory.initElements(driver, this);


        //poderia ter um bloco desse em cada uma das outras  classes, home, lista e produto.
        // Esse daqui prepara o selenium para ser usado, simplemente para nao precisar ficar repetindo

    }

}
