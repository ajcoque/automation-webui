package co.com.sofka.questions.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.sofka.userinterfaces.login.Login.VALIDATION_SPANMESSAGE;

public class LoginError implements Question<Boolean> {

    private static final String VALIDATION_INVALID_DATA = "Invalid credentials";
    private static final String VALIDATION_EMPTY_DATA = "Username cannot be empty";
    private String validation;

    public LoginError wasFilledAndGet(String validation) {
        this.validation = validation;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //String d = VALIDATION_SPANMESSAGE.resolveFor(actor).getText().trim();
        return (VALIDATION_SPANMESSAGE.resolveFor(actor).containsOnlyText(validation));
    }

    public static LoginError loginError() {
        return new LoginError();
    }
}
