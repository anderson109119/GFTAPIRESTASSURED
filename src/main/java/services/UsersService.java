package services;

import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import pojo.Produtos;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


@Log4j2
public class UsersService extends TestingSupport {

    public UsersService(){

        pages.Produtos produto = new pages.Produtos();

        //Utilizando a classe Produtos para trazer os produtos necessários

        // Sugestão: Fazer um laço para produtos
        setURI(getConfiguration().urlBase() + produto.adidas);
        //setSchemaFile("schemas/users/users-schema.json");
        //setDataFile("Usuarios","usuarios");
    }

    // Apontando para variáveis de Produtos.java
    // Fazer um laço para lista de produtos
    public void setField(Produtos user, String field, String value) {
        switch (field){
            case "adidas": user.getAdidas(); break;
            default: break;
        }
    }

    public String getField(String field) {
        String res = "";
        Produtos usersAux = getGson().fromJson(getResponse().jsonPath().prettify(), Produtos.class);

        switch (field){
            case "produto": res  = usersAux.getAdidas(); break;
            default: break;
        }
        return res;
    }

    public void ConsultaDeProduto() {

        setResponse(given(). // Dados de resposta
                when().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                get(getURI()). // A url é complementada com users de acordo com a linha 12 esta classe "setURI(getConfiguration().urlBase() + "/users");"

                        then().extract().response()

        );
        logResponse();
    }

    public void IdentificaPaginaConsulta() {

        // Criar validação para que verifique que o usuário esteja na página

        System.out.println("Validar que o usuário esteja na página");


        }

}
