package co.com.sofka.stepdefinition.paygrades;

import co.com.sofka.exceptions.ValidationTextDoNotMatch;
import co.com.sofka.stepdefinition.setup.Setup;


import co.com.sofka.userinterfaces.paygrades.currency.Currency;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.sofka.exceptions.ValidationTextDoNotMatch.VALIDATION_DO_NOT_MATCH;
import static co.com.sofka.questions.login.Login.login;
import static co.com.sofka.questions.login.LoginError.loginError;
import static co.com.sofka.questions.paygrades.PayGrades.payGrades;
import static co.com.sofka.questions.paygrades.currency.Currency.currency;
import static co.com.sofka.questions.users.Users.users;
import static co.com.sofka.tasks.login.FillLogin.fillLogin;
import static co.com.sofka.tasks.paygrades.BrowseToPayGrades.browseToPayGrades;
import static co.com.sofka.tasks.paygrades.FillPayGrade.fillPayGrade;
import static co.com.sofka.tasks.paygrades.currency.FillCurrency.fillCurrency;
import static co.com.sofka.tasks.users.BrowseToUsers.browseToUsers;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;
import static co.com.sofka.tasks.landingpage.OpenLandingPage.openLandingPage;


public class PayGradesCucumberStepDefinition extends Setup{

    private static final String ACTOR_NAME = "admin";

    private  String username;
    private  String password;

    private  String nameGrade;
    private  String nameCurrency;
    private  String minSalary;
    private  String maxSalary;

    private static final String VALIDATION_EXCEPTION_MESSAGE = "El aplicativo no guarda los datos del grado de pago";
    private static final String VALIDATION_EXCEPTION_MESSAGE_CURRENCY = "El aplicativo no guarda los datos de la moneda";


    @Given("el administrador del sistema se encuentra en la seccion de Pay Grade")
    public void elAdministradorDelSistemaSeEncuentraEnLaSeccionDePayGrade() {
        actorSetupTheBrowser(ACTOR_NAME);
        theActorInTheSpotlight().attemptsTo(
                openLandingPage()
        );
        username = "Admin";
        password = "admin123";
        fillData();
        theActorInTheSpotlight().attemptsTo(
                browseToPayGrades()
        );
    }

    @When("el administrador ingresa un name de grado de pago NO existente y presiona en el boton agregar,adicionalmente agrega los datos de la moneda: nombre, salario minimo y maximo y presiona guardar")
    public void elAdministradorIngresaUnNameDeGradoDePagoNOExistenteYPresionaEnElBotonAgregarAdicionalmenteAgregaLosDatosDeLaMonedaNombreSalarioMinimoYMaximoYPresionaGuardar() {
        nameGrade = "Grade B";
        theActorInTheSpotlight().attemptsTo(
                fillPayGrade()
                        .usingName(nameGrade)
        );

        nameCurrency = "Colombian Peso";
        minSalary = "1000000.96";
        maxSalary = "10000000.96";
        theActorInTheSpotlight().attemptsTo(
                fillCurrency()
                        .usingNameCurrency(nameCurrency)
                        .usingMinSalary(minSalary)
                        .usingMaxSalary(maxSalary)
        );
    }

    @Then("el sistema debera mostrar los datos de grado de pago guardados en el sistema.")
    public void elSistemaDeberaMostrarLosDatosDeGradoDePagoGuardadosEnElSistema() {
        theActorInTheSpotlight().should(
                seeThat(currency()
                        .wasFilledWithNameCurrency(nameCurrency)
                        .andWithMinimumSalary(minSalary)
                        .andWithMaximumSalary(maxSalary)
                        .is(), equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, VALIDATION_EXCEPTION_MESSAGE_CURRENCY)
                        )
        );

        theActorInTheSpotlight().attemptsTo(
                browseToPayGrades()
        );

        theActorInTheSpotlight().should(
                seeThat(payGrades()
                        .wasFilledWithName(nameGrade)
                        .is(), equalTo(true)
                )
                        .orComplainWith(
                                ValidationTextDoNotMatch.class,
                                String.format(VALIDATION_DO_NOT_MATCH, VALIDATION_EXCEPTION_MESSAGE)
                        )
        );
    }

    private void fillData(){
        theActorInTheSpotlight().attemptsTo(
                fillLogin()
                        .usingUsername(username)
                        .usingPassword(password)
        );
    }

}
