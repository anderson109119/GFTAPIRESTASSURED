package steps;

import cucumber.api.java.pt.*;
import org.junit.Assert;
import services.UsersService;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;

public class UsersSteps {

    public Response response;
    public UsersService usersService;

    @Dado("o usuário realize uma consulta de produto")
    public void oUsuarioRealizaConsultaDeProduto() throws Exception {
        usersService = new UsersService();
        usersService.ConsultaDeProduto();
    }

    @Quando("o usuário estiver logado na página de pesquisa")
    public void oUsuarioidentificaAPaginaDeBusca() throws Exception {

        usersService.IdentificaPaginaConsulta();
    }

    @Então("^o usuário deverá ver o resultado \"([^\"]*)\"$")
    public void oUsuarioDeveraVerOResultado(String message) {
        int statusExpected = usersService.getFromMessageToStatus(message);
        Assert.assertEquals(statusExpected, usersService.getResponse().getStatusCode());
    }

}
