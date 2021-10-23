package co.com.sofka.stepdefinition.users;

import co.com.sofka.exceptions.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.setup.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.users.Users.users;
import static co.com.sofka.tasks.login.FillLogin.fillLogin;
import static co.com.sofka.tasks.users.BrowseToUsers.browseToUsers;
import static co.com.sofka.tasks.users.FillSearchUsers.fillSearchUsers;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;

public class UsersCucumberStepDefinition extends Setup {

    private static final String ACTOR_NAME = "admin";
    private String username;
    private String password;
    private static final String MESSAGE_ERROR = "No se muestran los datos del usuario consultado";

    @Given("el administrador del sistema se encuentra en la pagina de users")
    public void elAdministradorDelSistemaSeEncuentraEnLaPaginaDeUsers() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandingPage()
        );
        username = "Admin";
        password = "admin123";
        fillData();
        theActorInTheSpotlight().attemptsTo(
                browseToUsers()
        );
    }

    @When("el administrador ingresa el username del usuario existente que desea buscar y presiona en el boton Search")
    public void elAdministradorIngresaElUsernameDelUsuarioExistenteQueDeseaBuscarYPresionaEnElBotonSearch() {
        theActorInTheSpotlight().attemptsTo(
                fillSearchUsers()
                        .usingUsername(username)
        );
    }

    @Then("el sistema debera mostrar los datos del usuario consultado")
    public void elSistemaDeberaMostrarLosDatosDelUsuarioConsultado() {
        theActorInTheSpotlight().should(
                seeThat(users()
                        .wasFilledWithUserName(username)
                        .is(), equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, MESSAGE_ERROR)
                        )
        );
    }

    private void fillData() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUsername(username)
                        .usingPassword(password)
        );
    }

}
