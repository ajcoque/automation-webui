package co.com.sofka.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.landingpage.LandingPage.DASHBOARD;
import static co.com.sofka.userinterfaces.login.Login.VALIDATION_DASHBOARD;

public class Login implements Question<Boolean> {

    private String username;
    private String password;

    public Login wasFilledWithUserName(String username) {
        this.username = username;
        return this;
    }

    public Login andWithPassword(String password) {
        this.password = password;
        return this;
    }


    public Login is() {
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (VALIDATION_DASHBOARD.resolveFor(actor).containsOnlyText(DASHBOARD));
    }

    public static Login login() {
        return new Login();
    }
}
