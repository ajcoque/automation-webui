package co.com.sofka.stepdefinition.login;


import co.com.sofka.exceptions.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.setup.Setup;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.login.Login.login;
import static co.com.sofka.questions.login.LoginError.loginError;
import static co.com.sofka.tasks.login.FillLogin.fillLogin;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;


public class LoginCucumberStepDefinition extends Setup {

    private static final String ACTOR_NAME = "admin";
    private String username;
    private String password;
    private static final String MESSAGE_ERROR = "El aplicativo no redirige a la pagina esperada";
    private static final String SPAN_MESSAGE_ERROR = "El aplicativo no da la retroalimentacion correcta";
    private static final String VALIDATION_INVALID_DATA = "Invalid credentials";
    private static final String VALIDATION_EMPTY_DATA = "Username cannot be empty";


    @Given("el administrador del sistema se encuentra en la pagina de inicio de sesion")
    public void elAdministradorDelSistemaSeEncuentraEnLaPaginaDeInicioDeSesion() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandingPage()
        );
    }


    @When("el administrador ingresa los campos username y password obligatorios y solicita login")
    public void elAdministradorIngresaLosCamposUsernameYPasswordObligatoriosYSolicitaLogin() {
        username = "Admin";
        password = "admin123";
        fillData();
    }

    @Then("el sistema debera rederigir a la pagina dashboard del aplicativo web")
    public void elSistemaDeberaRederigirALaPaginaDashboardDelAplicativoWeb() {
        theActorInTheSpotlight().should(
                seeThat(login()
                        .wasFilledWithUserName(username)
                        .andWithPassword(password)
                        .is(), equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, MESSAGE_ERROR)
                        )
        );
    }


    @When("el administrador ingresa el campo username valido pero password invalido y solicita login")
    public void elAdministradorIngresaElCampoUsernameValidoPeroPasswordInvalidoYSolicitaLogin() {
        username = "admin";
        password = "admin";
        fillData();
    }

    @Then("el sistema deberá mostrar un mensaje evidenciando que los datos ingresados son invalidos")
    public void elSistemaDeberaMostrarUnMensajeEvidenciandoQueLosDatosIngresadosSonInvalidos() {
        dataIncorrect(VALIDATION_INVALID_DATA);
    }

    @When("el administrador ingresa el campo username invalido y password valido y solicita login")
    public void elAdministradorIngresaElCampoUsernameInvalidoYPasswordValidoYSolicitaLogin() {
        username = "admin123";
        password = "admin123";
        fillData();
    }

    @Then("el sistema deberá mostrar un mensaje que indique que los datos ingresados son invalidos")
    public void elSistemaDeberaMostrarUnMensajeQueIndiqueQueLosDatosIngresadosSonInvalidos() {
        dataIncorrect(VALIDATION_INVALID_DATA);
    }


    @When("el administrador no ingresa el campo username ni el campo password y solicita login")
    public void elAdministradorNoIngresaElCampoUsernameNiElCampoPasswordYSolicitaLogin() {
        username = "";
        password = "";
        fillData();
    }

    @Then("el sistema deberá mostrar un mensaje evidenciando que los campos no deben estar vacios")
    public void elSistemaDeberaMostrarUnMensajeEvidenciandoQueLosCamposNoDebenEstarVacios() {
        dataIncorrect(VALIDATION_EMPTY_DATA);
    }

    private void fillData() {
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUsername(username)
                        .usingPassword(password)
        );
    }

    private void dataIncorrect(String message) {
        theActorInTheSpotlight().should(
                seeThat(loginError()
                                .wasFilledAndGet(message),
                        equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, SPAN_MESSAGE_ERROR)
                        )
        );
    }


}
