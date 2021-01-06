package api;


import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utils.Json;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//@RunWith(Parameterized.class)
public class Usuario {
    String uri = "https://petstore.swagger.io/v2"; //uri é de interface pq nao é um site pra usar url
    String caminhoMassa = "src/test/resources/data/usuario.json"; // caminho da massa de teste

    JSONObject jsonObj = new JSONObject(Json.ler(caminhoMassa)); // Ler a massa de teste em formato json



    @Test
    public void criarUsuario(){
        given() // Dado (preparacao)
            .contentType("application/json") // tipo de conteudo da API (xml ou json)
            .log().all() //logar tudo que acontece na ida - request/requisicao
            .body(jsonObj.getJSONObject("user1"))
        .when() // Quando (vai ser sempre a açao)
            .post(uri + "/user") //criar um usuario
            //.delete() para deletar
            //.get() //consultar
            //.put() // alterar
        .then() //Entao (sao os asserts)
             .log().all() //logar tudo que acontece na volta - response/resposta
             .statusCode(200) //checagem minima de que a resquest foi atendida
             .body("code", equalTo(200)) // verifica se o valor do codigo no body da response = 200
             .body("type", equalTo("unkown")) //checar se volta o unkown como resposta
             .body("message", equalTo("1"))
        ;



    }

}
